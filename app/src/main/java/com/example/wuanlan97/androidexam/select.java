package com.example.wuanlan97.androidexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        Book b=new Book();
        b.init(this);
        ListView listview=(ListView) findViewById(R.id.txt);
        Intent intent=getIntent();
        switch(intent.getStringExtra("swit"))
        {
            case "income":listview.setAdapter(b.selectincome());break;
            case "pay":listview.setAdapter(b.selectpay());break;
            case "date":listview.setAdapter(b.selectdate(intent.getStringExtra("date")));break;
            default:listview.setAdapter(b.selectall());break;
        }

        Button  ToDate1=(Button) findViewById(R.id.TurnbackToSelectMenu);
        ToDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}
