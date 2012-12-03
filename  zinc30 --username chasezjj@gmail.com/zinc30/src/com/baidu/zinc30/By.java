package com.baidu.zinc30;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.baidu.zinc30.element.CommonAndroidElment;
import com.baidu.zinc30.element.MenuItemAndroidElement;
import com.baidu.zinc30.element.UnknowAndroidElement;

public abstract class By implements SearchElement {

	private static Map<AndroidElementType, Class<? extends AndroidElement>> elementMap = new HashMap<AndroidElementType, Class<? extends AndroidElement>>();

	{
		elementMap.put(AndroidElementType.Button, CommonAndroidElment.class);
		elementMap.put(AndroidElementType.EditText, CommonAndroidElment.class);
		elementMap.put(AndroidElementType.Image, CommonAndroidElment.class);
		elementMap.put(AndroidElementType.ImageButton,
				CommonAndroidElment.class);
		elementMap.put(AndroidElementType.TextView, CommonAndroidElment.class);
		elementMap.put(AndroidElementType.MenuItem,
				MenuItemAndroidElement.class);
		elementMap.put(AndroidElementType.Unknow, UnknowAndroidElement.class);
	}

	public static By id(int id) {
		return new ById(id);
	}

	public static class ById extends By {

		public int id;

		public ById(int id) {
			this.id = id;
		}

		@Override
		public AndroidElement findAndroidElement(Zinc zinc) {
			return new CommonAndroidElment(zinc, this);
		}

	}

	public static class ByText extends By {

		public AndroidElementType type;

		public String text;

		public ByText(AndroidElementType type, String text) {
			this.type = type;
			this.text = text;
		}

		@Override
		public AndroidElement findAndroidElement(Zinc zinc) {
			Class<? extends AndroidElement> clazz = elementMap.get(type);
			return initAndroidElement(zinc, this, clazz);
		}
	}

	public static class ByIndex extends By {

		public AndroidElementType type;

		public int index;

		public ByIndex(AndroidElementType type, int index) {
			this.type = type;
			this.index = index;
		}

		@Override
		public AndroidElement findAndroidElement(Zinc zinc) {
			Class<? extends AndroidElement> clazz = elementMap.get(type);
			return initAndroidElement(zinc, this, clazz);
		}
	}

	public static AndroidElement initAndroidElement(Zinc zinc, By by,
			Class<? extends AndroidElement> androidElementClass) {
		try {
			Constructor<? extends AndroidElement> constructor = androidElementClass
					.getConstructor(Zinc.class, By.class);
			return constructor.newInstance(zinc, by);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

}
