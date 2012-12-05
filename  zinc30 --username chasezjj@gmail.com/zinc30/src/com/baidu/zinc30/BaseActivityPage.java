package com.baidu.zinc30;

import com.baidu.zinc30.support.PageFactory;

/**
 * 所有ActivityPage类的基类，在创建的时候会初始化Page中的AndroidElement
 * 
 * @author zhangjunjun
 * 
 */
public class BaseActivityPage {

	protected Zinc zinc;

	public BaseActivityPage(Zinc zinc) {
		this.zinc = zinc;
		PageFactory.initAndroidElements(zinc, this);
	}

	/**
	 * 指定activity是否出现
	 * 
	 * @param activity
	 *            指定activity
	 * @return 是否出现
	 */
	public boolean isActivityPresent(Class<?> activity) {
		return zinc.waitForActivity(activity.getSimpleName());
	}

	/**
	 * 指定文本是否出现
	 * 
	 * @param text
	 *            指定文本
	 * @return 是否出现
	 */
	public boolean isTextPresent(String text) {
		return zinc.waitForText(text, 1, 15000);
	}

}
