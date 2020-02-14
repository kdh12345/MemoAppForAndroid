package org.androidtown.memoapplication;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Myadapter {
    private String title;
    private String body;
    private long savedTime;

    public Myadapter(String title,String body,long savedTime){
        this.title=title;
        this.body=body;
        this.savedTime=savedTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSavedTime(long savedTime) {
        this.savedTime = savedTime;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public long getSavedTime() {
        return savedTime;
    }
    public String getTextSavedTime(){
        return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(savedTime);
    }
    public String toString(){
        return "제목:"+title+"\n"
                +"내용:"+body+"\n"
                +"등록시간"+new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(savedTime)+"\n";
    }
}
