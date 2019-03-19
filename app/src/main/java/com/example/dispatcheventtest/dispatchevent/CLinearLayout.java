package com.example.dispatcheventtest.dispatchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class CLinearLayout extends LinearLayout {
  private static final String TAG = "C linearlayout";

  public CLinearLayout(Context context) {
    super(context);
  }

  public CLinearLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    Log.e(TAG, "dispatchTouchEvent: " + ev.getAction());
    return super.dispatchTouchEvent(ev);
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent ev) {
    Log.e(TAG, "onInterceptTouchEvent: " + ev.getAction());
    return true;
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    Log.e(TAG, "onTouchEvent: " + event.getAction());
    return false;
  }
}
