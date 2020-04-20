package com.example.androidcourse1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private ContentAdapter adapter;
    private Toolbar toolbar;
    public List<Content> contents = new ArrayList<>();
    private static  int LAN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_change:
                changeLan();
                break;
        }
        return true;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toolbar.setTitle("");  //必须在onCreate方法执行完之后才能设置标题
    }


    @Override
    public void initView(){
        initData();
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        initRecycler();

    }

    public void initData(){
        contents.addAll(Arrays.asList(
                new Content(R.drawable.image1,"未知病毒爆发",getResources().getString(R.string.image1)),
                new Content(R.drawable.image2,"钟南山院士一线抗疫",getResources().getString(R.string.image2)),
                new Content(R.drawable.image3,"美丽的逆行者",getResources().getString(R.string.image3)),
                new Content(R.drawable.image4,"口罩纷争",getResources().getString(R.string.image4)),
                new Content(R.drawable.image5,"物资支援武汉",getResources().getString(R.string.image5)),
                new Content(R.drawable.image6,"雷神山火神山动工",getResources().getString(R.string.image6)),
                new Content(R.drawable.image7,"军队的援助",getResources().getString(R.string.image7)),
                new Content(R.drawable.image8,"各地体温检测",getResources().getString(R.string.image8)),
                new Content(R.drawable.image10,"疫情中的爱情故事",getResources().getString(R.string.image10)),
                new Content(R.drawable.image11,"疫情好转",getResources().getString(R.string.image11))
        ));
    }

    private void initRecycler(){
        recyclerView = findViewById(R.id.recycler_main);
        adapter = new ContentAdapter(this);
        adapter.setData(contents);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initListener(){
        adapter.setCardOnClick(new ContentAdapter.CardOnClick() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("key",contents.get(position));
                startActivity(intent);
            }
        });
    }


    private void changeLan(){
        contents.clear();
        if(LAN == 0){
            contents.addAll(Arrays.asList(
                    new Content(R.drawable.image1,"Unknown virus outbreak",getResources().getString(R.string.image1e)),
                    new Content(R.drawable.image2,"Academician Zhong Nanshan's first-line anti-epidemic",getResources().getString(R.string.image2e)),
                    new Content(R.drawable.image3,"Beautiful retrograde",getResources().getString(R.string.image3e)),
                    new Content(R.drawable.image4,"Mask dispute",getResources().getString(R.string.image4e)),
                    new Content(R.drawable.image5,"Material Support Wuhan",getResources().getString(R.string.image5e)),
                    new Content(R.drawable.image6,"Construction of Mount Raytheon and Mount Vulcan",getResources().getString(R.string.image6e)),
                    new Content(R.drawable.image7,"Army assistance",getResources().getString(R.string.image7e)),
                    new Content(R.drawable.image8,"Body temperature testing",getResources().getString(R.string.image8e)),
                    new Content(R.drawable.image10,"Love story in the epidemic",getResources().getString(R.string.image10e)),
                    new Content(R.drawable.image11,"The epidemic improved",getResources().getString(R.string.image11e))
            ));
            LAN = 1;
        }else {
            contents.addAll(Arrays.asList(
                    new Content(R.drawable.image1,"未知病毒爆发",getResources().getString(R.string.image1)),
                    new Content(R.drawable.image2,"钟南山院士一线抗疫",getResources().getString(R.string.image2)),
                    new Content(R.drawable.image3,"美丽的逆行者",getResources().getString(R.string.image3)),
                    new Content(R.drawable.image4,"口罩纷争",getResources().getString(R.string.image4)),
                    new Content(R.drawable.image5,"物资支援武汉",getResources().getString(R.string.image5)),
                    new Content(R.drawable.image6,"雷神山火神山动工",getResources().getString(R.string.image6)),
                    new Content(R.drawable.image7,"军队的援助",getResources().getString(R.string.image7)),
                    new Content(R.drawable.image8,"各地体温检测",getResources().getString(R.string.image8)),
                    new Content(R.drawable.image10,"疫情中的爱情故事",getResources().getString(R.string.image10)),
                    new Content(R.drawable.image11,"疫情好转",getResources().getString(R.string.image11))
            ));
            LAN = 0;
        }

        adapter.setData(contents);
    }

}
