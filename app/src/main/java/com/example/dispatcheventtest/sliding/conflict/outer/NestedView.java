package com.example.dispatcheventtest.sliding.conflict.outer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.dispatcheventtest.tools.Utils;

import androidx.annotation.Nullable;

public class NestedView extends View {
  private static final String TAG = "B";

  public NestedView(Context context) {
    super(context);
  }

  public NestedView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent event) {
    Utils.log(TAG, "dispatchTouchEvent");
    return super.dispatchTouchEvent(event);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    Utils.log(TAG, "onTouchEvent");
    return true;
  }
}
