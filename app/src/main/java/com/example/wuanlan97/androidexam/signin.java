package com.example.wuanlan97.androidexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signin extends AppCompatActivity {

    private EditText editusername;
    private EditText editpassword;
    private EditText editname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Button button3=(Button) findViewById(R.id.signup);
        editusername=(EditText) findViewById(R.id.SignupUsername);
        editname=(EditText) findViewById(R.id.SingupName);
        editpassword=(EditText) findViewById(R.id.SignupPassword);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Book b=new Book();
                b.init(signin.this);

                String username=editusername.getText().toString();
                String name=editname.getText().toString();
                String password =editpassword.getText().toString();

                if(b.signin(name,username,password)){finish();}

            }
        });
    }
}
