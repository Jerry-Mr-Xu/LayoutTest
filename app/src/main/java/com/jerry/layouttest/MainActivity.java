package com.jerry.layouttest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     * 去除第一次打开的结果
     */
    private int testCount = -1;
    private Button btnLinearActivity, btnRelativeActivity, btnConstraintActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinearActivity = findViewById(R.id.btn_linear_activity);
        btnRelativeActivity = findViewById(R.id.btn_relative_activity);
        btnConstraintActivity = findViewById(R.id.btn_constraint_activity);

        btnLinearActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, LinearActivity.class), 1000);
            }
        });
        btnRelativeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, RelativeActivity.class), 1001);
            }
        });
        btnConstraintActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, ConstraintActivity.class), 1002);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        testCount++;
        if (testCount < 30) {
            btnLinearActivity.performClick();
        }else if (testCount < 60) {
            btnRelativeActivity.performClick();
        }else if (testCount < 90){
            btnConstraintActivity.performClick();
        }
    }
}
