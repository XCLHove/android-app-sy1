package com.xc.activity_sy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_lauout);
        Intent intent = getIntent();

        //main data
        String mainData = intent.getStringExtra("main_data");
        TextView showMainData = findViewById(R.id.showMainData);
        showMainData.setText(mainData);

        //second data
        Random random = new Random();
        String secondData = "随机数：" + String.valueOf(random.nextInt() + "，来自SecondActivity");
        TextView showSecondData = findViewById(R.id.showSecondData);
        showSecondData.setText(secondData);

        //返回按钮
        findViewById(R.id.back).setOnClickListener(view -> {
            intent.putExtra("second_data", secondData);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}