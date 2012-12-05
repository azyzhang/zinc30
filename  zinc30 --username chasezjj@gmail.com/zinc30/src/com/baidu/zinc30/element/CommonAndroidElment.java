package com.baidu.zinc30.element;

import android.view.View;
import android.widget.EditText;

import com.baidu.zinc30.AndroidElement;
import com.baidu.zinc30.AndroidElementType;
import com.baidu.zinc30.By;
import com.baidu.zinc30.By.ById;
import com.baidu.zinc30.By.ByIndex;
import com.baidu.zinc30.By.ByText;
import com.baidu.zinc30.IllegalFindByException;
import com.baidu.zinc30.Zinc;

public class CommonAndroidElment extends AndroidElmentAdaptor implements
		AndroidElement {

	protected View parentView;

	protected View view;

	protected By by;

	protected Zinc zinc;

	public CommonAndroidElment(Zinc zinc, By by) {
		this.zinc = zinc;
		this.by = by;
	}

	public CommonAndroidElment(Zinc zinc, View parentView, By by) {
		this.zinc = zinc;
		this.by = by;
		this.parentView = parentView;
	}

	@Override
	public void click() {
		View view = getView();
		zinc.clickOnView(view);
	}

	@Override
	public void longClick() {
		View view = getView();
		zinc.clickLongOnView(view);
	}

	@Override
	public boolean isDisplayed() {
		View view = getView();
		return view.isShown();
	}

	@Override
	public boolean isEnabled() {
		View view = getView();
		return view.isEnabled();
	}

	@Override
	public boolean isSelected() {
		View view = getView();
		return view.isSelected();
	}

	@Override
	public void setSelected() {
		View view = getView();
		view.setSelected(true);
	}

	@Override
	public void clear() {
		View view = getView();
		if (view instanceof EditText) {
			zinc.clearEditText((EditText) view);
		} else {
			throw new UnsupportedOperationException(
					"EditText can only support this operation!");
		}
	}

	@Override
	public AndroidElement findElement(int id) {
		View parentView = getView();
		return new CommonAndroidElment(zinc, parentView, new ById(id));
	}

	@Override
	public void sendKeys(String keys) {
		View view = getView();
		if (view instanceof EditText) {
			zinc.enterText((EditText) view, keys);
		} else {
			throw new UnsupportedOperationException(
					"EditText can only support this operation!");
		}
	}

	private View getView() {
		if (parentView != null && by instanceof ById) {
			return parentView.findViewById(((ById) by).id);
		}

		if (by instanceof ById) {
			return zinc.getView(((ById) by).id);
		}

		if (by instanceof ByText) {
			ByText byText = (ByText) by;
			if (AndroidElementType.TextView == byText.type) {
				return zinc.getText(byText.text);
			}
			if (AndroidElementType.EditText == byText.type) {
				return zinc.getEditText(byText.text);
			}
			if (AndroidElementType.Button == byText.type) {
				return zinc.getButton(byText.text);
			}
		}

		if (by instanceof ByIndex) {
			ByIndex byIndex = (ByIndex) by;
			if (AndroidElementType.TextView == byIndex.type) {
				return zinc.getText(byIndex.index);
			}
			if (AndroidElementType.EditText == byIndex.type) {
				return zinc.getEditText(byIndex.index);
			}
			if (AndroidElementType.Button == byIndex.type) {
				return zinc.getButton(byIndex.index);
			}
			if (AndroidElementType.Image == byIndex.type) {
				return zinc.getImage(byIndex.index);
			}
			if (AndroidElementType.ImageButton == byIndex.type) {
				return zinc.getImageButton(byIndex.index);
			}
		}
		
		throw new IllegalFindByException("unspport this @Findby attributes combination!");
	}

}
