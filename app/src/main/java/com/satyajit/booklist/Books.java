package com.satyajit.booklist;

public class Books {

    private String mBookName;

    private String mDescription;

    private String murl;

    private String mImage;

    private String mAuthor;

    public Books(String bname, String description, String url, String img, String author){
         mBookName = bname;
         mDescription = description;
         murl = url;
         mImage = img;
         mAuthor = author;
    }

    public String getmBookName(){
        return mBookName;
    }
    public String getmDescription(){
        return mDescription;
    }
    public String getMurl(){
        return murl;
    }
    public String getmImage(){
        return mImage;
    }
    public String getmAuthor(){
        return mAuthor;
    }
}
