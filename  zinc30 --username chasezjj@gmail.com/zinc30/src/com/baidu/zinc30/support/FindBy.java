package com.baidu.zinc30.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.baidu.zinc30.AndroidElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FindBy {

	/**
	 * 根据id查找
	 */
	int id() default Integer.MIN_VALUE;

	/**
	 * 根据文本查找AndroidElement
	 */
	String text() default "";

	/**
	 * 根据种类来查找AndroidElement，必须与index属性联合使用
	 * 
	 * @see AndroidElementType
	 */
	AndroidElementType type() default AndroidElementType.Null;

	/**
	 * 元素的索引，0代表第一个，1代表第二个，必须与type属性联合使用
	 */
	int index() default Integer.MIN_VALUE;
	
}
