package com.baidu.zinc30.element;

import com.baidu.zinc30.AndroidElement;
import com.baidu.zinc30.By;
import com.baidu.zinc30.Zinc;
import com.baidu.zinc30.By.ByIndex;
import com.baidu.zinc30.By.ByText;

public class MenuItemAndroidElement extends AndroidElmentAdaptor implements
		AndroidElement {

	protected By by;

	protected Zinc zinc;

	public MenuItemAndroidElement(Zinc zinc, By by) {
		this.zinc = zinc;
		this.by = by;
	}

	@Override
	public void click() {
		if (by instanceof ByText) {
			zinc.clickOnMenuItem(((ByText) by).text);
		}
		if (by instanceof ByIndex) {
			zinc.pressMenuItem(((ByIndex) by).index);
		}
	}

}
