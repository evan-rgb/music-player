package com.example.lerry.mvpmusicplayerlerry.Utils;

/**
 * Created by ro_ on 2016/9/20.
 */

public class DateUtils {
    /**
     * 毫秒转 "mm:ss"
     * @param mSec
     * @return
     */
    public static String secToMin(int mSec) {
        int sec = mSec / 1000;
        String ans = sec / 60 + ":" + sec % 60;
        return  ans;
    }
}
