package com.example.jou.manyfunction;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class Main3Activity extends  AppCompatActivity {
    TabHost mTabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        mTabHost = (TabHost)findViewById(R.id.tabHost);
        mTabHost.setup();

        TabHost.TabSpec tab1 = mTabHost.newTabSpec("0");
        tab1.setIndicator("红色");
        tab1.setContent(R.id.tab3);
        mTabHost.addTab(tab1);

        mTabHost.addTab(mTabHost
                .newTabSpec("1")
                .setIndicator("綠色")
                .setContent(R.id.tab1));

        mTabHost.addTab(mTabHost.newTabSpec("2")
                .setIndicator("蓝色")
                .setContent(R.id.tab3));
    }}




