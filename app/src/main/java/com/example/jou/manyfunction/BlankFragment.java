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


    EditText title,context;
    FragmentInterface fragmentInterface;
    String etitle,econtext;


    public interface FragmentInterface {
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
            fragmentInterface = (FragmentInterface) getActivity();
        } catch (Exception e) {}

        AlertDialog.Builder bbb = new AlertDialog.Builder(getActivity());//新稱一個
        bbb.setView(view);
        bbb.setPositiveButton("新增", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Shrimp shrimp = getshrimp();
                fragmentInterface.sure(shrimp);
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