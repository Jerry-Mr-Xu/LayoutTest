package com.jerry.layouttest;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

/**
 * 带日志的相对布局
 *
 * @author xujierui
 */
public class LogRelativeLayout extends RelativeLayout {
    private static final String TAG = "LogRelativeLayout";

    private long measureStartTime = 0;
    private long measureEndTime = 0;

    private long layoutStartTime = 0;
    private long layoutEndTime = 0;

    private final boolean isRoot;

    public LogRelativeLayout(Context context) {
        this(context, null);
    }

    public LogRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LogRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        isRoot = getId() == R.id.root;
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        if (this.measureStartTime == 0 && isRoot) {
//            this.measureStartTime = System.currentTimeMillis();
//            postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    logCostTime();
//                }
//            }, 1000);
//        }
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        if (isRoot) {
//            this.measureEndTime = System.currentTimeMillis();
//        }
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        if (this.layoutStartTime == 0 && isRoot) {
//            this.layoutStartTime = System.currentTimeMillis();
//        }
//        super.onLayout(changed, l, t, r, b);
//        if (isRoot) {
//            this.layoutEndTime = System.currentTimeMillis();
//        }
//    }

    public void logCostTime() {
        Log.i(TAG, "measure cost time: " + (this.measureEndTime - this.measureStartTime));
        Log.i(TAG, "layout cost time: " + (this.layoutEndTime - this.layoutStartTime));
    }
}
