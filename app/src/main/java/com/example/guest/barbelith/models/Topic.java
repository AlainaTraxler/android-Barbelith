package com.example.guest.barbelith.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 12/5/16.
 */
@Parcel
public class Topic {
    String title;
    String content;
    String author;
    String category;

    public Topic() {}

    public Topic(String _title, String _content, String _author, String _category){
        title = _title;
        content = _content;
        author = _author;
        category = _category;
    }

    public String getTitle(){ return title; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
}
