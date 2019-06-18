package com.me.threebuttonsintent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Second Activity");
        // set back button
        actionBar.setDisplayHomeAsUpEnabled(true);

        TextView textView = findViewById(R.id.text_article);


        String message_one = getIntent().getStringExtra(MainActivity.TEXT_ONE);
        String message_two = getIntent().getStringExtra(MainActivity.TEXT_TWO);
        String message_three = getIntent().getStringExtra(MainActivity.TEXT_THREE);


        if(message_one != null) {
            textView.setText(message_one);
        }else if(message_two != null) {
            textView.setText(message_two);
        }else if(message_three != null) {
            textView.setText(message_three);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
