package com.baidu.zinc30;

import android.app.Activity;
import android.os.SystemClock;

/**
 * 登陆基类，需要登陆才能操作的测试类可以继承此类
 * 
 * @author zhangjunjun
 * 
 * @param <LoginActivity>
 */
public abstract class ZincLoginTestCase<LoginActivity extends Activity> extends
		ZincTestCase<LoginActivity> {

	private final static long MINI_TIME = 300L;

	private final static long LOGIN_TIMEOUT = 120000L;

	public ZincLoginTestCase(Class<LoginActivity> activityClass) {
		super(activityClass.getPackage().getName(), activityClass);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		login();
		waitForLoginComplete();
	}

	/**
	 * 登陆操作
	 */
	protected abstract void login();

	/**
	 * 判断能登陆完成的条件
	 * 
	 * @return 是否登陆完成
	 */
	protected abstract boolean isLoginComplete();

	private void waitForLoginComplete() {
		final long endTime = SystemClock.uptimeMillis() + LOGIN_TIMEOUT;
		while (!isLoginComplete() && SystemClock.uptimeMillis() < endTime) {
			SystemClock.sleep(MINI_TIME);
		}
	}

}
