package com.example.dispatcheventtest.sliding.conflict.outer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

import com.example.dispatcheventtest.tools.Utils;

public class HorizontalOuterInterceptLayout extends FrameLayout {
  private int touchSlop;
  private float startX, startY;
  private static final String TAG = "A";

  public HorizontalOuterInterceptLayout(@androidx.annotation.NonNull Context context) {
    super(context);
  }

  public HorizontalOuterInterceptLayout(
      @androidx.annotation.NonNull Context context,
      @androidx.annotation.Nullable AttributeSet attrs) {
    super(context, attrs);
    touchSlop = ViewConfiguration.getTouchSlop();
    Utils.log(TAG, "touchSlop=", String.valueOf(touchSlop));
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    if (ev.getAction() == MotionEvent.ACTION_DOWN) {
      startX = ev.getX();
      startY = ev.getY();
    }
    return super.dispatchTouchEvent(ev);
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent ev) {
    final boolean intercepted;
    switch (ev.getAction()) {
      case MotionEvent.ACTION_DOWN:
        intercepted = false;
        break;
      case MotionEvent.ACTION_MOVE:
        intercepted = isIntercept(ev.getX(), ev.getY());
        Utils.log(TAG, "onInterceptTouchEvent: intercepted=" + intercepted);
        break;
      default:
        intercepted = false;
    }
    return intercepted;
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    Utils.log(TAG, "onTouchEvent");
    return true;
  }

  private boolean isIntercept(float x, float y) {
    return Math.abs(x - startX) > Math.abs(y - startY)
        && Utils.dist(x, y, startX, startY) > touchSlop;
  }
}
