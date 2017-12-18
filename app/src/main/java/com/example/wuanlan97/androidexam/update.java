package com.example.wuanlan97.androidexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class update extends AppCompatActivity {

    private EditText name;
    private  EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Book b=new Book();
        b.init(this);

        name=(EditText)this.findViewById(R.id.updatename);
        name.setText(b.getName());
        password=(EditText)findViewById(R.id.updatepassword);

        Button update=(Button)findViewById(R.id.updatebuttom);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book b=new Book();
                b.init(update.this);
                b.updatename(name.getText().toString());

                if(!password.getText().toString().equals(""))
                {
                    b.updatepassword(password.getText().toString());
                }
            }
        });

    }

}
