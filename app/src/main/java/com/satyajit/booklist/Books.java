package com.satyajit.booklist;

public class Books {

    private final String mBookName;

    private final String mDescription;

    private final String murl;

    private final String mImage;

    private final String mAuthor;

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
