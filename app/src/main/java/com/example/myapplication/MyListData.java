package com.example.myapplication;

public class MyListData {
    private String question;
    private int imgID;

    public MyListData(String question, int imgID) {
        this.question = question;
        this.imgID = imgID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }
}
