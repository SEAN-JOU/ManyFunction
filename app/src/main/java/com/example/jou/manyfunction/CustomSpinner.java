package com.example.jou.manyfunction;

import android.app.Activity;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jou on 2017/10/15.
 */

public class CustomSpinner extends BaseAdapter {

    TypedArray arrayimage;
    Activity aaa;


    public CustomSpinner(Activity aaa){
        this.aaa =aaa;
    }

    @Override
    public int getCount() {/*下拉式清單有幾個項目*/
        return 3;
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
        View v =aaa.getLayoutInflater().inflate(R.layout.layout,null);

        TextView txv =(TextView)v.findViewById(R.id.txv);
        ImageView imv =(ImageView)v.findViewById(R.id.imv);
        arrayimage = aaa.getResources().obtainTypedArray(R.array.nba_logs);/*取得類型陣列*/
        String[] avv =aaa.getResources().getStringArray(R.array.nba);/*取得字串陣列*/
        txv.setText(avv[i]);
        imv.setBackground(arrayimage.getDrawable(i));
        return v;/**/
    }
}
