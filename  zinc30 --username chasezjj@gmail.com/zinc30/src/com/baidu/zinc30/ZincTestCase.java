package com.baidu.zinc30;

import java.lang.reflect.Method;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.baidu.zinc30.support.Failover;

/**
 * Zinc30测试基类,测试用例最好继承此类
 * 
 * @author zhangjunjun
 * 
 * @param <T>
 *            需要启动的Activity
 */
public class ZincTestCase<T extends Activity> extends
		ActivityInstrumentationTestCase2<T> {

	protected Zinc zinc;

	public ZincTestCase(String pkg, Class<T> activityClass) {
		super(pkg, activityClass);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// fix the bug in android ActivityInstrumentationTestCase2
		setActivityInitialTouchMode(false);
		setActivityIntent(null);

		zinc = new Zinc(getInstrumentation(), getActivity());
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		zinc.finishOpenedActivities();
		try {
			zinc.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void runTest() throws Throwable {
		int retryTimes = 1;
		boolean screenshot = false;
		Method method = getClass().getMethod(getName(), (Class[]) null);
		Failover failover = method.getAnnotation(Failover.class);
		if (failover != null) {
			if (failover.retryTimes() > 1) {
				retryTimes = failover.retryTimes();
			}
			screenshot = failover.screanshot();
		}

		while (retryTimes > 0) {
			try {
				super.runTest();
				break;
			} catch (Throwable e) {
				if (retryTimes > 1) {
					retryTimes--;
					continue;
				} else {
					if (screenshot) {
						zinc.takeScreenshot();
					}
					throw e;
				}
			}
		}
	}

}
