package com.example.android.outingtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.college_category);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,collegeActivity.class);
                startActivity(intent);
            }
        });

        tv = (TextView) findViewById(R.id.res_category);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RestaurantActivity.class);
                startActivity(intent);
            }
        });

        tv = (TextView) findViewById(R.id.malls_category);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,mallActivity.class);
                startActivity(intent);
            }
        });

        tv = (TextView) findViewById(R.id.couples_category);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,couplesActivity.class);
                startActivity(intent);
            }
        });
    }
}
