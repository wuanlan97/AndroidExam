package com.example.wuanlan97.androidexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class setDatePicker extends AppCompatActivity {
    private DatePicker datepicket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_date_picker);

        datepicket=(DatePicker) findViewById(R.id.setdatePicker);
        datepicket.setMaxDate(System.currentTimeMillis());
        Button OK=(Button)this.findViewById(R.id.DatePickerOK);
        OK.setOnClickListener(new View.OnClickListener() {
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
                Intent intent=new Intent();
                intent.putExtra("date",date);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
