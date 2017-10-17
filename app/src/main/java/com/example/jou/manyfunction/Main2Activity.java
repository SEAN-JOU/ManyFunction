package com.example.jou.manyfunction;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main2Activity extends AppCompatActivity {

    ListView lv;
    SimpleAdapter adapter;
    ArrayList<Map<String, Object>> mydata = new ArrayList();
    Blank2Fragment fragment2,fragment1;
    Button btn;


    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        floatingActionButton =(FloatingActionButton)findViewById(R.id.flo);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar;//點心條訊息
                snackbar=Snackbar.make(view,/*點心條內容*/"No internet",Snackbar.LENGTH_LONG)./*點心條內的按鍵*/setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it =new Intent();
                        it.setClass(Main2Activity.this,Main3Activity.class);
                        startActivity(it);
                    }});
                snackbar.show();
            }});

        lv = (ListView) findViewById(R.id.listView);

        HashMap<String, Object> m1 = new HashMap<>();
        m1.put("city", "台北");/*設置key值 帶入value值*/
        m1.put("code", "02");
        m1.put("img", R.drawable.a);
        mydata.add(m1);/*加進m1*/
        HashMap<String, Object> m2 = new HashMap<>();
        m2.put("city", "台中");
        m2.put("code", "04");
        m2.put("img", R.drawable.b);
        mydata.add(m2);
        HashMap<String, Object> m3 = new HashMap<>();
        m3.put("city", "高雄");
        m3.put("code", "07");
        m3.put("img", R.drawable.cal);
        mydata.add(m3);


        adapter = new SimpleAdapter(
                Main2Activity.this,/*使用的範圍*/
                mydata,/*使用的arraylist*/
                R.layout.myitem,/*SimpleAdapter使用的layout*/
                new String[] {"city", "code", "img"},
                new int[] {R.id.textView, R.id.textView2, R.id.imageView
                });
        lv.setAdapter(adapter);


    }

    protected void onStart() {
        super.onStart();
        btn=(Button)findViewById(R.id.btn);
        fragment1= (Blank2Fragment)getSupportFragmentManager().findFragmentById(R.id.f1);
        fragment2= (Blank2Fragment)getSupportFragmentManager().findFragmentById(R.id.f2);

        fragment1.teamname.setText("yellow");/*特定物件內的元件*/
        fragment2.teamname.setText("black");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment1.score.setText("0");
                fragment2.score.setText("0");

            }});
}}
