package com.xc.activity_sy1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.xc.activity_sy1.util.LogUtil;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.info("ThirdActivity:onCreate,taskId:" + getTaskId());
        setTitle("Third Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
    }
}