package com.example.dispatcheventtest.sliding.conflict.inner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import com.example.dispatcheventtest.tools.Utils;

import androidx.annotation.Nullable;

public class NestedConflictView extends View {
  private static final String TAG = "B";
  private float startX, startY;
  private int touchSlop;

  public NestedConflictView(Context context) {
    super(context);
  }

  public NestedConflictView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    touchSlop = ViewConfiguration.getTouchSlop();
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {
      getParent().requestDisallowInterceptTouchEvent(true);
      startX = event.getX();
      startY = event.getY();
    } else if (isIntercept(event.getX(), event.getY())) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.dispatchTouchEvent(event);
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
