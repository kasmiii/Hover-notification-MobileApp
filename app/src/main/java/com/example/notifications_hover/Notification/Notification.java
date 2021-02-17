package com.example.notifications_hover.Notification;

import java.util.Date;

public class Notification {

    private String title;
    private String body;
    private int image;
    private Date date;

    public Notification(String title, String body, int image, Date date) {
        this.title = title;
        this.body = body;
        this.image = image;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", image=" + image +
                ", date=" + date +
                '}';
    }
}
