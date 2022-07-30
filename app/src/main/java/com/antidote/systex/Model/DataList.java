package com.antidote.systex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataList {

    private String title;
    private String content;
    private String img;
    private String msgTime;

    public DataList(String title, String content, String img, String msgTime) {
        this.title = title;
        this.content = content;
        this.img = img;
        this.msgTime = msgTime;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImg() {
        return img;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public String getDefaultUrl(){
        return "https://file.coffee/u/bo8GXmoUP4goMI.jpg";
    }

}
