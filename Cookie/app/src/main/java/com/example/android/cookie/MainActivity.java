package com.example.android.cookie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.cookie.R.drawable;
import static com.example.android.cookie.R.id;
import static com.example.android.cookie.R.layout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView imageView = (ImageView) findViewById(id.android_cookie_image_view);
        imageView.setImageResource(drawable.after_cookie);


        // TODO: Find a reference to the TextView in the layout. Change the text.

        TextView textView = (TextView) findViewById(id.status_text_view);
        textView.setText("I'm so full");
    }
    

}