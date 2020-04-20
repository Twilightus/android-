package com.example.androidcourse1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends BaseActivity {


    private Toolbar toolbar;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Content key = (Content) getIntent().getSerializableExtra("key");
        if(null != key){
            imageView.setImageResource(key.getId());
            textView.setText(key.getDetail());
        }

    }


    @Override
    public void initView() {
        toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = findViewById(R.id.image_detail_top);
        textView = findViewById(R.id.text_detail);

    }

    @Override
    public void initListener() {

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
