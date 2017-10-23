package com.example.jou.manyfunction;


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by jou on 2017/10/22.
 */

public class ListAdapter extends BaseAdapter{

   Main4Activity aaa;

    public ListAdapter(Main4Activity aaa){
        this.aaa =  aaa;
    }

    @Override
    public int getCount() {
        return aaa.getMcoffeelist().size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =aaa.getLayoutInflater().inflate(R.layout.list_layout,null);
        TextView txv1=(TextView)v.findViewById(R.id.txv1);
        TextView txv2=(TextView)v.findViewById(R.id.txv2);
        Shrimp shrimp=aaa.getMcoffeelist().get(i);
        txv1.setText(shrimp.getTitle().toString());
        txv2.setText(shrimp.getContext().toString());

        return v;
    }}
