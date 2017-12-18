package com.example.wuanlan97.androidexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Book b=new Book();
        b.init(this);
        name=b.getName();
        TextView top=(TextView) findViewById(R.id.printname);
        String print="欢迎";
        print+=name;
        print+="使用";
        top.setText(print);


        Button button1=(Button) findViewById(R.id.ToUpdate);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Menu.this,update.class);
                startActivity(intent1);
            }
        });

        Button button2=(Button) findViewById((R.id.ToInsert));
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Menu.this,insert.class);
                startActivity(intent1);
            }
        });

        Button button3=(Button) findViewById(R.id.ToSelect);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Menu.this,SelectMenu.class);
                startActivity(intent1);
            }
        });
    }
}
