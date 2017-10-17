package com.example.jou.manyfunction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Blank2Fragment extends Fragment {

    TextView score,teamname;
    Button three,reset,one,two;
    int scoreteam;

    public Blank2Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_blank2, container, false);
    }
    public void onStart(){
        super.onStart();
        one=(Button)getView().findViewById(R.id.one);/*取得fragment_blank2內的畫面*/
        two=(Button)getView().findViewById(R.id.two);
        three=(Button)getView().findViewById(R.id.three);
        reset=(Button)getView().findViewById(R.id.reset);
        score =(TextView)getView().findViewById(R.id.score);
        teamname=(TextView)getView().findViewById(R.id.teamname);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreteam = Integer.parseInt(score.getText().toString());
                scoreteam += 1;
                score.setText(scoreteam+"");
            }});

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreteam =Integer.parseInt(score.getText().toString());
                scoreteam += 2;
                score.setText(scoreteam+"");
            }});

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreteam =Integer.parseInt(score.getText().toString());
                scoreteam += 3;
                score.setText(scoreteam+"");
            }});

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.setText("0");
            }});
}}
