package com.example.wuanlan97.androidexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class insert extends AppCompatActivity {

    private EditText money;
    private Boolean income=true;
    private CheckBox booldatetime;
    private  boolean setdatetime=false;
    private String datetime;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode)
        {
            case 1:
                if(resultCode==RESULT_OK)
                {
                    String date=data.getStringExtra("date");
                    if(date!=null || date.equals(""))
                    {
                        datetime=date;
                        Intent intent1=new Intent(insert.this,setTimePicket.class);
                        startActivityForResult(intent1,2);
                        booldatetime.setChecked(false);
                        setdatetime=false;
                    }
                    else
                    {
                        setdatetime=false;
                        booldatetime.setChecked(false);
                    }
                }
                break;
            case 2:
                if(resultCode==RESULT_OK)
                {
                    String time=data.getStringExtra("time");
                    if(time!=null || time.equals(""))
                    {
                        datetime+=" "+time;
                        booldatetime.setChecked(true);
                        setdatetime=true;
                    }
                    else
                    {
                        setdatetime=false;
                        booldatetime.setChecked(false);
                    }
                }
        }
    }

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

        booldatetime=(CheckBox)this.findViewById(R.id.setTime);
        booldatetime.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked&&setdatetime)
                {
                    Intent intent1=new Intent(insert.this,setDatePicker.class);
                    startActivityForResult(intent1,1);
                    booldatetime.setChecked(false);
                }
                else
                {
                    setdatetime=false;
                }
            }
        });

    }
}
