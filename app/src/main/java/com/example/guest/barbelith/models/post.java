package com.example.guest.barbelith.models;

/**
 * Created by Guest on 12/5/16.
 */
public class Post {
    String title;
    String content;
    String author;
    int upvotes = 0;
    int downvotes = 0;

    public Post(String _title, String _content, String _author){
        title = _title;
        content = _content;
        author = _author;
    }

    public String getTitle(){ return title; }
    public String getContent(){ return content; }
    public String getAuthor(){ return author; }
    public int getUpvotes(){ return upvotes; }
    public int getDownvotes(){ return downvotes; }
}
