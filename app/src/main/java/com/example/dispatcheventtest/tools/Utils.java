package com.example.dispatcheventtest.tools;

import android.util.Log;

public class Utils {
  public static void log(String tag, String log) {
    Log.e(tag, "--" + log + "--");
  }

  public static void log(String tag, String log, String log1) {
    Log.e(tag, "--" + log + log1 + "--");
  }

  public static double dist(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
  }
}
