package com.example.wuanlan97.androidexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AndroidExam extends AppCompatActivity {

    private EditText editusername;
    private EditText editpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_exam);
        Book b=new Book();
        b.init(this);
        editusername=(EditText) findViewById(R.id.username);
        editpassword=(EditText) findViewById(R.id.password);
        Button button1=(Button) findViewById(R.id.login);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username=editusername.getText().toString();
                String password=editpassword.getText().toString();

                Book b=new Book();
                b.init(AndroidExam.this);
                if(b.login(username,password))
                {
                    Intent intent=new Intent(AndroidExam.this,Menu.class);
                    startActivity(intent);
                }


            }
        });
        Button button2=(Button) findViewById(R.id.Tosignup);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AndroidExam.this,signin.class);
                startActivity(intent);
            }
        });
    }
}
