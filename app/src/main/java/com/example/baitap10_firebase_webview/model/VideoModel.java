package com.example.baitap10_firebase_webview.model;

public class VideoModel {
    private String title;
    private String desc;
    private String url;

    public VideoModel(String title, String desc, String url) {
        this.title = title;
        this.desc = desc;
        this.url = url;
    }

    public VideoModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
