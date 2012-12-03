package com.baidu.zinc30;

public interface AndroidElement {

	/**
	 * 清理EditText已有的文本
	 */
	public void clear();

	/**
	 * 点击AndroidElement
	 */
	public void click();

	/**
	 * 长按AndroidElement
	 */
	public void longClick();

	/**
	 * 在控件内部通过id来查找子元素
	 * 
	 * @param id
	 *            id
	 * @return 控件
	 */
	public AndroidElement findElement(int id);

	/**
	 * 判断AndroidElement是否展现
	 * 
	 * @return 是否展现
	 */
	public boolean isDisplayed();

	/**
	 * 判断AndroidElement是否可用
	 * 
	 * @return 是否可用
	 */
	public boolean isEnabled();

	/**
	 * 判断AndroidElement是否选中
	 * 
	 * @return 是否选中
	 */
	public boolean isSelected();

	/**
	 * 将AndroidElement设置为选中
	 */
	public void setSelected();

	/**
	 * 输入文本
	 * 
	 * @param keys
	 *            文本
	 */
	public void sendKeys(String keys);

}
