package com.baidu.zinc30;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.pm.ActivityInfo;
import android.view.KeyEvent;

import com.jayway.android.robotium.solo.Solo;

/**
 * 
 * 类似于Selenium中的WebDriver，整个Zinc30的核心类，里面包括了所有Robotium的方法。
 * 
 * @author zhangjunjun
 * 
 */
public class Zinc extends Solo {

	public final static int LANDSCAPE = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE; // 0
	public final static int PORTRAIT = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT; // 1
	public final static int RIGHT = KeyEvent.KEYCODE_DPAD_RIGHT;
	public final static int LEFT = KeyEvent.KEYCODE_DPAD_LEFT;
	public final static int UP = KeyEvent.KEYCODE_DPAD_UP;
	public final static int DOWN = KeyEvent.KEYCODE_DPAD_DOWN;
	public final static int ENTER = KeyEvent.KEYCODE_ENTER;
	public final static int MENU = KeyEvent.KEYCODE_MENU;
	public final static int DELETE = KeyEvent.KEYCODE_DEL;
	public final static int CLOSED = 0;
	public final static int OPENED = 1;

	public Zinc(Instrumentation instrumentation, Activity activity) {
		super(instrumentation, activity);
	}

	public Zinc(Instrumentation instrumentation) {
		super(instrumentation, null);
	}

}
