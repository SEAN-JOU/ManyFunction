package com.example.jou.manyfunction;





import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;



public class BlankFragment extends DialogFragment {


    EditText user, password;


    public BlankFragment() {
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        LayoutInflater inflater = getActivity().getLayoutInflater();//取得片段當前關聯的活動 取得緩存的LayoutInflater用於片段的視圖。
        View view = inflater.inflate(R.layout.fragment_blank, null);//取得R.layout.fragment_blank


        user = (EditText) view.findViewById(R.id.user);
        password = (EditText) view.findViewById(R.id.password);

        AlertDialog.Builder bbb = new AlertDialog.Builder(getActivity());//新稱一個
        bbb.setView(view);
        bbb.setPositiveButton("登入", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        });
        bbb.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        });
        return bbb.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }}