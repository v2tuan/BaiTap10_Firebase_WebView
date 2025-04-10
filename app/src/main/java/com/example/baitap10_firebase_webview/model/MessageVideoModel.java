package com.example.baitap10_firebase_webview.model;

import java.util.List;

public class MessageVideoModel {
    private boolean success;
    private String message;
    private List<VideoAPIModel> result;

    public MessageVideoModel(boolean success, String message, List<VideoAPIModel> result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<VideoAPIModel> getResult() {
        return result;
    }

    public void setResult(List<VideoAPIModel> result) {
        this.result = result;
    }
}
