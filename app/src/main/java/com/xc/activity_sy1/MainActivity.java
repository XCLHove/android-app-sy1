package com.xc.activity_sy1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xc.activity_sy1.util.LogUtil;
import com.xc.activity_sy1.util.ToastUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) return;
        if (requestCode != 1) return;
        String secondData = data.getStringExtra("second_data");
        TextView showSecondDataInMain = findViewById(R.id.showSecondDataInMain);
        showSecondDataInMain.setText(secondData);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.info("MainActivity:onCreate");
        setTitle("Main Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //Toast
        findViewById(R.id.showToast).setOnClickListener(view -> {
            ToastUtil.showToast(MainActivity.this, "这是一个toast消息");
        });

        //下一页(隐式)
        findViewById(R.id.nextPage).setOnClickListener(view -> {
            LogUtil.warn("下一页(隐式)");
            SimpleDateFormat formatter= new SimpleDateFormat("'当前时间：'yyyy-MM-dd HH:mm:ss'，来自MainActivity'");
            Date date = new Date(System.currentTimeMillis());
            String data = formatter.format(date);
            Intent intent = new Intent("android.intent.action.SECOND"); //隐式
            intent.putExtra("main_data", data);
            //startActivity(intent);
            startActivityForResult(intent, 1);
        });

        //下一页(显式)
        findViewById(R.id.nextPage2).setOnClickListener(view -> {
            LogUtil.warn("下一页(显式)");
            SimpleDateFormat formatter= new SimpleDateFormat("'当前时间：'yyyy-MM-dd HH:mm:ss'，来自MainActivity'");
            Date date = new Date(System.currentTimeMillis());
            String data = formatter.format(date);
            Intent intent = new Intent(MainActivity.this, SecondActivity.class); //显式
            intent.putExtra("main_data", data);
            //startActivity(intent);
            startActivityForResult(intent, 1);
        });

        //standardToSelf
        findViewById(R.id.standardToSelf).setOnClickListener(view -> {
            LogUtil.warn("standardToSelf");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        //toSingleTop
        findViewById(R.id.toSingleTop).setOnClickListener(view -> {
            LogUtil.warn("toSingleTop");
            Intent intent = new Intent(this, SingleTopActivity.class);
            startActivity(intent);
        });

        //toSingleTask
        findViewById(R.id.toSingleTask).setOnClickListener(view -> {
            LogUtil.warn("toSingleTask");
            Intent intent = new Intent(this, SingleTaskActivity.class);
            startActivity(intent);
        });

        //toSingleInstance
        findViewById(R.id.toSingleInstance).setOnClickListener(view -> {
            LogUtil.warn("standardToSelf");
            LogUtil.info("MainActivity taskId:" + getTaskId());
            Intent intent = new Intent(this, SingleInstanceActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        LogUtil.info("onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        LogUtil.info("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        LogUtil.info("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        LogUtil.info("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        LogUtil.info("onDestroy");
        super.onDestroy();
    }
}