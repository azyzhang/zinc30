package com.baidu.zinc30.support;

import java.lang.reflect.Field;

import com.baidu.zinc30.AndroidElement;
import com.baidu.zinc30.AndroidElementType;
import com.baidu.zinc30.BaseActivityPage;
import com.baidu.zinc30.By;
import com.baidu.zinc30.By.ById;
import com.baidu.zinc30.By.ByIndex;
import com.baidu.zinc30.By.ByText;
import com.baidu.zinc30.Zinc;

public class PageFactory {

	public static BaseActivityPage initAndroidElements(Zinc zinc,
			BaseActivityPage page) {
		Class<?> clazz = page.getClass();
		while (clazz != Object.class) {
			initFields(zinc, page, clazz);
			clazz = clazz.getSuperclass();
		}
		return page;
	}

	private static void initFields(Zinc zinc, Object page, Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			FindBy findBy = field.getAnnotation(FindBy.class);
			if (findBy != null
					&& AndroidElement.class.isAssignableFrom(field.getType())) {
				try {
					AndroidElement element = getBy(findBy, field, page)
							.findAndroidElement(zinc);
					field.setAccessible(true);
					field.set(page, element);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	private static By getBy(FindBy findby, Field field, Object page) {
		int id = findby.id();
		if (id != Integer.MIN_VALUE) {
			return new ById(id);
		}

		AndroidElementType type = findby.type();
		if (type != AndroidElementType.Null) {
			String text = findby.text();
			if (!"".equals(text)) {
				return new ByText(type, text);
			}

			int index = findby.index();
			if (index != Integer.MIN_VALUE && index >= 0) {
				return new ByIndex(type, index);
			}
		}

		throw new RuntimeException("@Findby argument set error on "
				+ field.getName() + " in " + page.getClass() + "!");

	}

}
