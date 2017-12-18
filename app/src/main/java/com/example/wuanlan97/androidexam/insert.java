package com.example.wuanlan97.androidexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class insert extends AppCompatActivity {

    private EditText money;
    private Boolean income=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        RadioGroup swit=(RadioGroup)this.findViewById(R.id.insertradio);
        swit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioID=group.getCheckedRadioButtonId();
                RadioButton swit=(RadioButton)findViewById(radioID);

                if(swit.getText().toString().equals("收入"))
                {
                    income=true;
                }else
                {
                    income=false;
                }
            }
        });
        money=(EditText)findViewById(R.id.Money);
        Button InsertMoney=(Button) findViewById(R.id.insertMoney);
        InsertMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clear="0";
                Book b=new Book();
                b.init(insert.this);
                String Money=money.getText().toString();
                if(income)
                {if(b.income(Money))
                {
                    ((EditText) findViewById(R.id.Money)).setText(null);
                }
                }
                else
                { if(b.pay(Money))
                {
                    ((EditText) findViewById(R.id.Money)).setText(null);
                }
                }
            }
        });
        Button back=this.findViewById(R.id.InsertTurnback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
