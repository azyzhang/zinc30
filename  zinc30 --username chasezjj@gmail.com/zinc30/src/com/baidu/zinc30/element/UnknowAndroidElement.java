package com.baidu.zinc30.element;

import com.baidu.zinc30.AndroidElement;
import com.baidu.zinc30.By;
import com.baidu.zinc30.By.ByText;
import com.baidu.zinc30.Zinc;

public class UnknowAndroidElement extends AndroidElmentAdaptor implements
		AndroidElement {

	protected By by;

	protected Zinc zinc;

	public UnknowAndroidElement(Zinc zinc, By by) {
		this.zinc = zinc;
		this.by = by;
	}

	@Override
	public void click() {
		if (by instanceof ByText) {
			zinc.clickOnText(((ByText) by).text);
		}
	}

	@Override
	public void longClick() {
		if (by instanceof ByText) {
			zinc.clickLongOnText(((ByText) by).text);
		}
	}

}
