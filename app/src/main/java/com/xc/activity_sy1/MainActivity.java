package com.xc.activity_sy1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xc.activity_sy1.util.ToastUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //Toast
        findViewById(R.id.showToast).setOnClickListener(view -> {
            ToastUtil.showToast(MainActivity.this, "这是一个toast消息");
        });

        //下一页
        findViewById(R.id.nextPage).setOnClickListener(view -> {
            SimpleDateFormat formatter= new SimpleDateFormat("'当前时间：'yyyy-MM-dd HH:mm:ss'，来自MainActivity'");
            Date date = new Date(System.currentTimeMillis());
            String data = formatter.format(date);
            //Intent intent = new Intent(MainActivity.this, SecondActivity.class); //隐式
            Intent intent = new Intent("android.intent.action.SECOND"); //显示
            intent.putExtra("main_data", data);
            //startActivity(intent);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.remove)
            ToastUtil.showToast(MainActivity.this, "remove");
        if (itemId == R.id.add)
            ToastUtil.showToast(MainActivity.this, "add");
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode != RESULT_OK) return;
        if (requestCode != 1) return;
        String secondData = data.getStringExtra("second_data");
        TextView showSecondDataInMain = findViewById(R.id.showSecondDataInMain);
        showSecondDataInMain.setText(secondData);
        super.onActivityResult(requestCode, resultCode, data);
    }
}