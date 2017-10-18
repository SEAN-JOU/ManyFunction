package com.example.jou.manyfunction;


import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class Main3Activity extends  AppCompatActivity {
    TabHost mTabHost;
    ProgressBar pbp;
    WebView myWebView;
    ProgressDialog pd;
    RadioGroup r1;
    RadioButton s1,s2;
    Button execute1,dialogppp,shine1,button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        r1=(RadioGroup)findViewById(R.id.r1);
        s1=(RadioButton)findViewById(R.id.s1);
        s2=(RadioButton)findViewById(R.id.s2);

        mTabHost = (TabHost)findViewById(R.id.tabHost);
        mTabHost.setup();
        myWebView = (WebView) findViewById(R.id.aaa);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://www.google.com.tw/?gws_rd=ssl");
        TabHost.TabSpec tab1 = mTabHost.newTabSpec("0");
        tab1.setIndicator("红色");
        tab1.setContent(R.id.tab2);
        mTabHost.addTab(tab1);

        mTabHost.addTab(mTabHost
                .newTabSpec("1")
                .setIndicator("綠色")
                .setContent(R.id.tab1));

        mTabHost.addTab(mTabHost.newTabSpec("2")
                .setIndicator("蓝色")
                .setContent(R.id.tab3));

        mTabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.RED);
        mTabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.GREEN);
        mTabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.YELLOW);

        execute1=(Button)findViewById(R.id.execute1);
        dialogppp=(Button)findViewById(R.id.dialogppp);
        shine1=(Button)findViewById(R.id.shine1);
        pbp =(ProgressBar)findViewById(R.id.ppp);
        button4=(Button)findViewById(R.id.button4);

        execute1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pbp.setVisibility(view.getVisibility()/*取得顯示狀態*/);/*設定顯示狀態*/

            }});


        shine1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pbp.setVisibility(View.VISIBLE/*畫面顯示*/);

                new Thread(){
                    @Override
                    public void run()
                    {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }/*新增匿名 分支執行續*/


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                pbp.setVisibility(View.INVISIBLE/*畫面隱藏*/);
                            }});}}.start();}});

        dialogppp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pd = new ProgressDialog(Main3Activity.this);
                pd.setMessage("Please Wait");
                pd.setCancelable(false);
                pd.show();
                new Thread() {
                    @Override
                    public void run()
                    {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                pd.dismiss();
                            }});}}.start();

            }});
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pbp.setVisibility(View.INVISIBLE);
            }});

        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged/*當檢查改變的時候*/(RadioGroup radioGroup, @IdRes int i) {

                switch(r1.getCheckedRadioButtonId()/*取得檢查RadioButtonId*/) {
                    case R.id.s1:
                        s1.setBackgroundColor(Color.GREEN);
                        s2.setBackgroundColor(Color.WHITE);
                        break;
                    case R.id.s2:
                        s2.setBackgroundColor(Color.RED);
                        s1.setBackgroundColor(Color.WHITE);
                        break;}


            }});



    }

    @Override
    public void onBackPressed(){
        if (myWebView.getUrl().contains("index.html"))
        {
            super.onBackPressed();
        }
        else
        {
            myWebView.goBack();
        }}}






