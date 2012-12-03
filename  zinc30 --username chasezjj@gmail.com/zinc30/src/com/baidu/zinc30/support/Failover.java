package com.baidu.zinc30.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Failover {

	/**
	 * 直到成功运行的最大次数
	 */
	int retryTimes() default 1;

	/**
	 * 是否截图，需要在被测应用中加上android.permission.WRITE_EXTERNAL_STORAGE权限
	 */
	boolean screanshot() default false;
}
