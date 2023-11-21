package com.xc.activity_sy1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.xc.activity_sy1.util.LogUtil;

public class SingleTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.info("SingleTaskActivity:onCreate");
        setTitle("SingleTask Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_task_layout);

        //singleTaskToSelf
        findViewById(R.id.singleTaskToSelf).setOnClickListener(view -> {
            LogUtil.warn("singleTaskToSelf");
            Intent intent = new Intent(this, SingleTaskActivity.class);
            startActivity(intent);
        });

        //singleTaskToStandard
        findViewById(R.id.singleTaskToStandard).setOnClickListener(view -> {
            LogUtil.warn("singleTask To Standard");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}