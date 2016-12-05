package com.example.guest.barbelith.models;

/**
 * Created by Guest on 12/5/16.
 */
public class Topic {
    String title;
    String content;
    String author;

    public Topic(String _title, String _content, String _author){
        title = _title;
        content = _content;
        author = _author;
    }

    public String getTitle(){ return title; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }
}