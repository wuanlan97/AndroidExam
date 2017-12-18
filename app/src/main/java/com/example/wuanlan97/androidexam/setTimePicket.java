package com.example.wuanlan97.androidexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class setTimePicket extends AppCompatActivity {

    private TimePicker timepic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time_picket);

        timepic=(TimePicker)this.findViewById(R.id.setTimePic);
        timepic.setIs24HourView(true);

        Button button=(Button)this.findViewById(R.id.TimePicOK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour,min;
                String time="";
                hour=timepic.getCurrentHour();
                min=timepic.getCurrentMinute();

                if(hour>10)
                {
                    time+=hour;
                }else{
                    time+="0"+hour;

                }
                time+=":";
                if(min>10)
                {
                    time+=min;
                }else{
                    time+="0"+min;

                }
                time+=":00";

                Intent intent=new Intent();
                intent.putExtra("time",time);
                setResult(RESULT_OK,intent);
                finish();

            }
        });
    }
}
