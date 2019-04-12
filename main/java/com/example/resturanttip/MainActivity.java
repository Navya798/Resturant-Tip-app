package com.example.resturanttip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private Button bt;
  private RadioGroup rd;
  private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rd=(RadioGroup)findViewById(R.id.radioGroup);
        bt=(Button)findViewById(R.id.button2);
        tv=(TextView)findViewById(R.id.textView2);
        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                tv.setText("");
                if(checkedId==R.id.radioButton)
                    Toast.makeText(MainActivity.this, "You have selected Dine In", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "You have selected Take Away", Toast.LENGTH_SHORT).show();
            }
        });
        bt.setOnClickListener(new clickhere());
    }
    class clickhere implements View.OnClickListener{
        public void onClick(View v){

            int si=rd.getCheckedRadioButtonId();
            if(si==R.id.radioButton)
                tv.setText("Your table will be booked");
            else if(si==R.id.radioButton2)
                tv.setText("Your Order will be ready in sometime");
            int total=0;
            CheckBox ch1,ch2,ch3;
            ch1=(CheckBox)findViewById(R.id.checkBox);
            ch2=(CheckBox)findViewById(R.id.checkBox2);
            ch3=(CheckBox)findViewById(R.id.checkBox3);
            if(ch1.isChecked())
                total=total+100;
            if(ch2.isChecked())
                total=total+50;
            if(ch3.isChecked())
                total=total+150;
            Intent in=new Intent(MainActivity.this,newclass.class);
            in= in.putExtra("bill",total);
            startActivity(in);


        }
    }
}
