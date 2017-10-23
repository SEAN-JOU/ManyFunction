package com.example.jou.manyfunction;





import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment extends DialogFragment {


    ListView sss;
    EditText title,context;
    qwe qqq;
    String etitle,econtext;


    public interface qwe {
        void sure(Shrimp shrimp);

    }

    public BlankFragment() {
    }




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_blank, null);

        title= (EditText) view.findViewById(R.id.title);
        context = (EditText) view.findViewById(R.id.context);


        try {
            qqq = (qwe) getActivity();
        } catch (Exception f) {
        }

        sss=(ListView)view.findViewById(R.id.listView);
        Activity aaa=getActivity();



        AlertDialog.Builder bbb = new AlertDialog.Builder(getActivity());//新稱一個
        bbb.setView(view);
        bbb.setPositiveButton("新增", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Shrimp shrimp = getshrimp();
                qqq.sure(shrimp);
            }});

        bbb.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }});
        return bbb.create();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
    public Shrimp getshrimp(){
        etitle=title.getText().toString();
        econtext=context.getText().toString();
        return new Shrimp(etitle,econtext);
}}