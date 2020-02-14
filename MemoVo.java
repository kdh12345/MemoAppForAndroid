package org.androidtown.memoapplication;

import java.text.SimpleDateFormat;

public class MemoVo {
    private String title;
    private String content;
    private long savedTime;

      public MemoVo(String title, String content, long savedTime) {
        this.title = title;
        this.content = content;
        this.savedTime = savedTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSavedTime() {
        return savedTime;
    }

    public void setSavedTime(long savedTime) {
        this.savedTime = savedTime;
    }

    public String getTextSavedTime(){
        return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(savedTime);
    }
    public String toString(){
        return "제목 : " + title + "\n"
                +"내용 : " + content + "\n"
                +"등록시간 : " + new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(savedTime) + "\n";
    }
}
