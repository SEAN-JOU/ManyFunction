package com.example.jou.manyfunction;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

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

                    }});
                snackbar.show();
            }});

    }
}
