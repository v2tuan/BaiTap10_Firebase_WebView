package com.example.baitap10_firebase_webview.model;

public class VideoAPIModel {
    private int id;
    private String title;
    private String description;
    private String url;

    public VideoAPIModel(int id, String title, String desc, String url) {
        this.id = id;
        this.title = title;
        this.description = desc;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
