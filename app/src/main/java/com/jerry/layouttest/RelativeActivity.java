package com.jerry.layouttest;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.FrameMetrics;
import android.view.Window;

public class RelativeActivity extends AppCompatActivity {
    private static final String TAG = "RelativeActivity";

    private final Window.OnFrameMetricsAvailableListener metricsListener = new Window.OnFrameMetricsAvailableListener() {
        @Override
        public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int dropCountSinceLastInvocation) {
            final FrameMetrics metricsCopy = new FrameMetrics(frameMetrics);
            Log.i(TAG, "layout measure duration : " + metricsCopy.getMetric(FrameMetrics.LAYOUT_MEASURE_DURATION));
        }
    };
    private final Handler metricsHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_relative);
        findViewById(R.id.root).postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().addOnFrameMetricsAvailableListener(metricsListener, metricsHandler);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getWindow().removeOnFrameMetricsAvailableListener(metricsListener);
    }
}
