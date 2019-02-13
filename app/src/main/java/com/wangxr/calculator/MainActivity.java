package com.wangxr.calculator;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView contentText = findViewById(R.id.contentText);
        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
        findViewById(R.id.bt5).setOnClickListener(this);
        findViewById(R.id.bt6).setOnClickListener(this);
        findViewById(R.id.bt7).setOnClickListener(this);
        findViewById(R.id.bt8).setOnClickListener(this);
        findViewById(R.id.bt9).setOnClickListener(this);
        findViewById(R.id.bt10).setOnClickListener(this);
        findViewById(R.id.bt11).setOnClickListener(this);
        findViewById(R.id.bt12).setOnClickListener(this);
        findViewById(R.id.bt13).setOnClickListener(this);
        findViewById(R.id.bt14).setOnClickListener(this);
        findViewById(R.id.bt15).setOnClickListener(this);
        findViewById(R.id.bt16).setOnClickListener(this);
        findViewById(R.id.bt17).setOnClickListener(this);
        findViewById(R.id.bt18).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
//        System.out.println("dkkdkdk"+ v.getId());
        switch (v.getId()){
            case R.id.bt1:
//                System.out.println(v.getId());
//                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//                alertDialog.setTitle(v.getId()+"");
//                alertDialog.show();
                findViewById(R.id.contentText).setBackgroundColor(Color.RED);
                break;
            case R.id.bt2:
                break;
        }
    }
}
