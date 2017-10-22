package com.example.jou.manyfunction;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.kd.dynamic.calendar.generator.ImageGenerator;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder alertdialog;
    TextView txv;
    Spinner spn;
    Button date,btn;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList;
    ImageGenerator imageGenerator;
    Bitmap mGenerateDataIcon;
    ImageView imageView;
    Calendar ccc;
    EditText edt;
    View v;
    DatePickerDialog mdatepicker;
    Toast toast;
    int y,m,d;
    ToggleButton tog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);
        txv = (TextView)findViewById(R.id.txv1);
        spn = (Spinner)findViewById(R.id.spn);
        edt =(EditText)findViewById(R.id.edt);
        imageView =(ImageView)findViewById(R.id.imageView);
        date = (Button)findViewById(R.id.date);
        tog=(ToggleButton)findViewById(R.id.tog);


        imageGenerator = new ImageGenerator(MainActivity.this);
        imageGenerator.setIconSize(100,100);
        imageGenerator.setDateSize(30);
        imageGenerator.setMonthSize(15);
        imageGenerator.setDatePosition(60);
        imageGenerator.setMonthPosition(26);
        imageGenerator.setDateColor(Color.BLACK);
        imageGenerator.setMonthColor(Color.BLACK);

        LayoutInflater lll = getLayoutInflater();
        v =lll.inflate(R.layout.tttt,null);

        tog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(tog.isChecked()){
                    WifiManager wifiManager =(WifiManager)getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(true);
                }
                else{
                    WifiManager wifiManager =(WifiManager)getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(false);
                }

            }});

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.setClass(MainActivity.this,Main2Activity.class);
                startActivity(it);
            }});


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ccc = Calendar.getInstance();
                y = ccc.get(Calendar.YEAR);
                m = ccc.get(Calendar.MONTH);
                d = ccc.get(Calendar.DAY_OF_MONTH);


                 mdatepicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {

                        edt.setText(y+" "+(m+1)+" "+d);
                        //ccc.set(y,m,d);
                        mGenerateDataIcon = imageGenerator.generateDateImage(ccc,R.drawable.cal);
                        imageView.setImageBitmap(mGenerateDataIcon);
                    }}
                        ,y
                        ,m
                        ,d);
                mdatepicker.show();
            }});


        arrayList = new ArrayList<>();
        arrayList.add("");
        arrayList.add("wonderful");
        arrayList.add("beautiful");
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.select_dialog_item,arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        CustomSpinner sfs=new CustomSpinner(MainActivity.this);
        spn.setAdapter(sfs);


        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if(i!=0 &&i !=1 && i != 2){

                    }
                else if(i==1){
                    BlankFragment fff =new BlankFragment();
                    fff.show(getSupportFragmentManager(),"B");
                }
                else if(i==2){

                    toast=Toast.makeText(MainActivity.this,"我要當老師",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.setView(v);
                    toast.show();
                }}

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }});
    }

    public void onStart(){
        super.onStart();

    }
public  void onResume(){
    super.onResume();
    alertdialog=new AlertDialog.Builder(MainActivity.this);

    final String[]rrr =getResources().getStringArray(R.array.bbb);
    final boolean[]sss =new boolean[rrr.length];

    alertdialog.setTitle("非常好");
    alertdialog.setMultiChoiceItems(rrr, sss, new DialogInterface.OnMultiChoiceClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
            if(sss[i]){
                Toast.makeText(MainActivity.this,"你選了"+rrr[i],Toast.LENGTH_SHORT).show();
            }
        }});

    alertdialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            StringBuilder result=new StringBuilder();
            for(int w=0; w<sss.length ; w++){
                if(sss[w]){
                    result.append(rrr[w]).append("\n");
                    txv.setText(result);}
            }}});
    alertdialog.setNeutralButton("清除",new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();

        }});
    alertdialog.setNegativeButton("取消",new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            Intent aa = new Intent();
            aa.setClass(MainActivity.this,Main4Activity.class);
            startActivity(aa);



        }});
    alertdialog.show();

}}


