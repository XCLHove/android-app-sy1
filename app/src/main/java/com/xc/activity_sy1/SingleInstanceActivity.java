package com.xc.activity_sy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.xc.activity_sy1.util.LogUtil;

public class SingleInstanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.info("SingleInstanceActivity:onCreate, taskId:" + getTaskId());
        setTitle("SingleInstance Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_instance_layout);

        //toThird
        findViewById(R.id.toThird).setOnClickListener(view -> {
            LogUtil.warn("toThird");
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);
        });
    }
}