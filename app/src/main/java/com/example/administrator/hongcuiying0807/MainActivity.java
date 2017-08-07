package com.example.administrator.hongcuiying0807;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TitleSet.BarClickListener{
    TitleSet titleSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleSet= (TitleSet) findViewById(R.id.title);
        titleSet.setListener(this);
    }

    @Override
    public void imageListener(View v) {
        Toast.makeText(this,"图片",Toast.LENGTH_LONG).show();
    }

    @Override
    public void titleListener(View v) {
        Toast.makeText(this,"标题",Toast.LENGTH_LONG).show();
    }
}
