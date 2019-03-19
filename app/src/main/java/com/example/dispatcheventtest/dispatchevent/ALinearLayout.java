package com.example.dispatcheventtest.dispatchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class ALinearLayout extends LinearLayout {
  private static final String TAG = "A linearlayout";

  public ALinearLayout(Context context) {
    super(context);
  }

  public ALinearLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    Log.e(TAG, "dispatchTouchEvent: " + ev.getAction());
    return super.dispatchTouchEvent(ev);
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent ev) {
    Log.e(TAG, "onInterceptTouchEvent " + ev.getAction());
    return false;
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    Log.e(TAG, "onTouchEvent: " + event.getAction());
    return true;
  }
}
