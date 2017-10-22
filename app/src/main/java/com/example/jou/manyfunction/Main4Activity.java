package com.example.jou.manyfunction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity implements BlankFragment.qwe {

    ListView listV;
    Button btn;
    ListAdapter listAdapte;
    List<Shrimp> listshrimp = new ArrayList<>();

    public List<Shrimp> getMcoffeelist()//物件+方法名稱
    {return listshrimp;}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        listV=(ListView)findViewById(R.id.list);
        btn=(Button)findViewById(R.id.btn);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BlankFragment fff =new BlankFragment();
                fff.show(getSupportFragmentManager(),"B");

            }});}

    @Override
    public void sure(Shrimp shrimp) {
        listAdapte =new ListAdapter(this);
        listshrimp.add(shrimp);
        listV.setAdapter(listAdapte);
        listAdapte.notifyDataSetChanged();


    }


}
