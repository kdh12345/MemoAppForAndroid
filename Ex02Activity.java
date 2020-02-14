package org.androidtown.memoapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ex02Activity extends AppCompatActivity implements View.OnClickListener {

    EditText title_et, content_et;
    Button btn_save, btn_read, btn_remove_all;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("MyMemo", MODE_PRIVATE);
        //preferences = PreferenceManager.getDefaultSharedPreferences(this);
        setContentView(R.layout.activity_ex02_1);

        title_et = findViewById(R.id.title_et);
        content_et = findViewById(R.id.content_et);
        btn_save = findViewById(R.id.btn_save);
        btn_read = findViewById(R.id.btn_read);
        btn_remove_all = findViewById(R.id.btn_remove_all);

        btn_save.setOnClickListener(this);
        btn_read.setOnClickListener(this);
        btn_remove_all.setOnClickListener(this);
    } // onCreate

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor;
        switch(v.getId()){
            case R.id.btn_save: // 저장 버튼
                editor = preferences.edit();
                String memo = title_et.getText().toString().trim()
                        + "#" + content_et.getText().toString().trim();
                editor.putString(String.valueOf(System.currentTimeMillis()), memo);
                editor.apply();
                Toast.makeText(this, "저장 완료!", Toast.LENGTH_SHORT).show();
                title_et.setText("");
                content_et.setText("");
                break;
            case R.id.btn_read:
                Intent intent = new Intent(this, Ex03Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_remove_all:
                editor = preferences.edit();
                editor.clear();
                editor.apply();
                break;
        }
    } // onClick
}
