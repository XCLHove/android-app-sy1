package com.xc.activity_sy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.xc.activity_sy1.util.LogUtil;

public class SingleTopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.info("SingleTopActivity:onCreate");
        setTitle("SingleTop Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_top_layout);

        //singleTopToSelf
        findViewById(R.id.singleTopToSelf).setOnClickListener(view -> {
            LogUtil.warn("singleTopToSelf");
            Intent intent = new Intent(this, SingleTopActivity.class);
            startActivity(intent);
        });

        //singleTopToStandard
        findViewById(R.id.singleTopToStandard).setOnClickListener(view -> {
            LogUtil.warn("singleTop To Standard");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}