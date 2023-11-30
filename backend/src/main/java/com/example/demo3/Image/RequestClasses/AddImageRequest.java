package com.example.demo3.Image.RequestClasses;

public class AddImageRequest {
    private long pid;
    private String url;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
