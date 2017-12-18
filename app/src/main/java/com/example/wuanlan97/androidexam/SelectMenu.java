package com.example.wuanlan97.androidexam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.net.DatagramPacket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectMenu extends AppCompatActivity {

    private DatePicker datepicket;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_menu);
        datepicket=(DatePicker) findViewById(R.id.selectDatePicker);
        datepicket.setMaxDate(System.currentTimeMillis());
        Button ToMenu=(Button)this.findViewById(R.id.TuanbackToMenu);
        ToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button selectALL=(Button)this.findViewById(R.id.selectALL);
        selectALL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SelectMenu.this,select.class);
                intent.putExtra("swit","");
                startActivity(intent);
            }
        });
        Button selectIncome=(Button)this.findViewById(R.id.selectIncome);
        selectIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SelectMenu.this,select.class);
                intent.putExtra("swit","income");
                startActivity(intent);

            }
        });
        Button selectPay=(Button)this.findViewById(R.id.selectPay);
        selectPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SelectMenu.this,select.class);
                intent.putExtra("swit","pay");
                startActivity(intent);
            }
        });
        Button selectDate=(Button)this.findViewById(R.id.selectDate);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day=datepicket.getDayOfMonth();
                int mon=datepicket.getMonth()+1;
                int year=datepicket.getYear();
                String date="";
                date+=year+"-";
                if(mon<10)
                {
                    date+="0"+mon+"-"+day;
                }
                else
                {
                    date+=mon+"-"+day;
                }
                Intent intent=new Intent(SelectMenu.this,select.class);
                intent.putExtra("swit","date");
                intent.putExtra("date",date);
                startActivity(intent);
            }
        });
    }
}
