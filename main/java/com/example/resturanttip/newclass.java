package com.example.resturanttip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class newclass extends AppCompatActivity {
   private TextView tv,tv1,tv2;
   private SeekBar sk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newclass);
        final int id=getIntent().getIntExtra("bill",0);
        tv=(TextView)findViewById(R.id.textView3);
        tv1=(TextView)findViewById(R.id.textView4);
        tv2=(TextView)findViewById(R.id.textView5);
        tv1.setText("Tip: 0 Rs");
        tv.setText("Amount : "+String.valueOf(id));
        sk=(SeekBar)findViewById(R.id.seekBar);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv1.setText("Tip: "+sk.getProgress()+" Rs");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
              tv2.setText("Your Total Bill is: "+(sk.getProgress()+id)+"Rs");
            }
        });


    }
}
