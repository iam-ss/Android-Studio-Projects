package com.example.android.practiceapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int total=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv=(TextView) findViewById(R.id.textView);
        tv.setText("0");
    }

    public void Change (int a)
    {
        TextView tv=(TextView) findViewById(R.id.textView);
        tv.setText(String.valueOf(a));
    }

    public void Plus(View v)
    {
        if(total==10)
        {
            Toast.makeText(this,"More Orders not Possible",Toast.LENGTH_SHORT).show();
        }
        else {
            total = total + 1;
            Change(total);
        }
    }


    public void Minus(View v)
    {
        if(total==0)
            Toast.makeText(this,"Not Possible",Toast.LENGTH_SHORT).show();

        else {
            total = total - 1;
            Change(total);
        }
    }

}