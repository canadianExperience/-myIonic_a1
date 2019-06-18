package com.me.threebuttonsintent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TEXT_ONE = "com.me.threebuttonsintent.extra.TEXT_ONE";
    public static final String TEXT_TWO = "com.me.threebuttonsintent.extra.TEXT_TWO";
    public static final String TEXT_THREE = "com.me.threebuttonsintent.extra.TEXT_THREE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("First Activity");
    }

    public void onFirstArticle(View view) {
        Intent intent_one = new Intent(this, SecondActivity.class);
        String article_one = getResources().getString(R.string.article_one);
        intent_one.putExtra(TEXT_ONE,article_one);
        startActivity(intent_one);
    }

    public void onSecondArticle(View view) {
        Intent intent_two = new Intent(this, SecondActivity.class);
        String article_two = getResources().getString(R.string.article_two);
        intent_two.putExtra(TEXT_TWO,article_two);
        startActivity(intent_two);
    }


    public void onThirdArticle(View view) {
        Intent intent_three = new Intent(this, SecondActivity.class);
        String article_three = getResources().getString(R.string.article_three);
        intent_three.putExtra(TEXT_THREE,article_three);
        startActivity(intent_three);
    }
}
