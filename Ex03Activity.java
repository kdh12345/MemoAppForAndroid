package org.androidtown.memoapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Map;

public class Ex03Activity extends AppCompatActivity {
    Map<String, ?> memoMap;
    ArrayList<MemoVo> memoVoArrayList;

    // 방법2.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex03_1);

        // 메모 정보 얻어오기
        // 키 : 저장시간 (long -> String)
        // 값 : 제목 + 본문 (String 1개)
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences preferences = getSharedPreferences("MyMemo", MODE_PRIVATE);
        memoMap = preferences.getAll();
        memoVoArrayList = new ArrayList<>(memoMap.size());
        for (Map.Entry<String, ?> entry : memoMap.entrySet()) {
            Log.d("MY", entry.getKey() + ":" + entry.getValue().toString());

            long savedTime = Long.parseLong(entry.getKey());
            String value = entry.getValue().toString();
            String[] arr = value.split("#");
            String title = arr[0];
            String content = arr[1];
            memoVoArrayList.add(new MemoVo(title, content, savedTime));

        }
        Log.d("MY", memoVoArrayList.toString());
        // 뷰
        ListView listView = findViewById(R.id.list_item);

        // 어댑터
        listView.setAdapter(new BaseAdapter() {
                                @Override
                                public int getCount() {
                                    return memoVoArrayList.size();
                                }

                                @Override
                                public Object getItem(int position) {
                                    return memoVoArrayList.get(position);
                                }

                                @Override
                                public long getItemId(int position) {
                                    return memoVoArrayList.get(position).getSavedTime();
                                }

                                @Override
                                public View getView(final int position, View convertView, ViewGroup parent) {
                                    if (convertView != null) {
                                        return convertView;
                                    }
                                    MemoVo vo = memoVoArrayList.get(position);
                                    TextView titleTv = new TextView(getApplicationContext());
                                    titleTv.setText(vo.getTitle() + "(" + vo.getTextSavedTime() + ")");
                                    titleTv.setTextSize(20);
                                    titleTv.setClickable(true);
                                    titleTv.setVisibility(View.VISIBLE);
                                    titleTv.setPadding(20, 20, 20, 20);
                                    Log.d("MY", titleTv.getText().toString());
                                    // 리스너
                                    titleTv.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            MemoVo vo = (MemoVo) getItem(position);
                                            Intent intent = new Intent(Ex03Activity.this, Ex04Activity.class);
                                            intent.putExtra("title", vo.getTitle());
                                            intent.putExtra("content", vo.getContent());
                                            intent.putExtra("time", vo.getTextSavedTime());
                                            startActivity(intent);
                                        }
                                    });
                                    return titleTv;
                                } // getView()
                            } // new BaseAdapter());
        );
    }
}
