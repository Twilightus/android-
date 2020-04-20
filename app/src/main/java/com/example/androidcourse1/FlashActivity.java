package com.example.androidcourse1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;

public class FlashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_flash);
    }


    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

        return super.onTouchEvent(event);
    }
}
