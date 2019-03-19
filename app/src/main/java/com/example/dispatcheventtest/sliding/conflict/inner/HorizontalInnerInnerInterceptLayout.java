package com.example.dispatcheventtest.sliding.conflict.inner;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.example.dispatcheventtest.tools.Utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HorizontalInnerInnerInterceptLayout extends FrameLayout {
  private static final String TAG = "A";

  public HorizontalInnerInnerInterceptLayout(@NonNull Context context) {
    super(context);
  }

  public HorizontalInnerInnerInterceptLayout(
      @NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent ev) {
    if (ev.getAction() == MotionEvent.ACTION_DOWN) {
      return false;
    } else {
      Log.e(TAG, "intercept!");
      return true;
    }
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    Utils.log(TAG, "onTouchEvent");
    return true;
  }
}
