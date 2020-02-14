package org.androidtown.memoapplication;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ex01Activity extends AppCompatActivity {

    TextView text_view;
    Button btn_value, btn_reset;
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex01_1);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        n = pref.getInt("value", 0); // defValue : 만약 해당 원소가 없을 경우 기본값 0을 넣겠다.


        text_view = findViewById(R.id.value);
        btn_value = findViewById(R.id.btn_value);
        btn_reset = findViewById(R.id.btn_reset);

        text_view.setText(String.valueOf(n));  // n + "" 보다는 String.valueOf( )
        btn_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_view.setText(String.valueOf(++n));
            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = 0;
                text_view.setText(String.valueOf(n));
            }
        });
    } // onCreate

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MY", "onDestroy()");

        // 액티비티가 종료될 때
        // 로컬에 n을 저장
        // SharedPreferences 객체를 얻어옴 --> PreferenceManager를 통해 얻어옴
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        // 편집 모드 실행 ( SharedPreferences.Editor : 편집기 )
        SharedPreferences.Editor edit = pref.edit(); // 편집하겠다!

        // 편집기를 사용하여 데이터 저장
        edit.putInt("value", n); // int형 데이터를 저장하겠다! 이름 : "value", 값 : n
        edit.apply(); // 최종저장 ( apply(), commit() 을 사용. apply()를 쓰자! )
                       // 최종 저장을 하지 않으면 저장 안됨!
        // 참고 : edit.remove(String name)  -> name 원소 삭제
        //        edit.clear() -> 로컬에 저장되었던 모든 원소 삭제
    }
}
