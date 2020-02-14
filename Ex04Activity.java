package org.androidtown.memoapplication;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ex04Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex04_1);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String time= intent.getStringExtra("time");
        Log.d("My", title + "\t" + content + "\t" + time);
        ((TextView)findViewById(R.id.title)).setText(title);
        ((TextView)findViewById(R.id.content)).setText(content);
        ((TextView)findViewById(R.id.time)).setText(time);
    }
}
