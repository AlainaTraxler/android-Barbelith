package com.example.guest.barbelith.models;

/**
 * Created by Guest on 12/5/16.
 */
public class Post {
    String content;
    String author;
    int upvotes = 0;
    int downvotes = 0;
    String pushId;
    String topicId;

    public Post() {};

    public Post(String _content, String _author){
        content = _content;
        author = _author;
    }

    public String getContent(){ return content; }
    public String getAuthor(){ return author; }
    public int getUpvotes(){ return upvotes; }
    public int getDownvotes(){ return downvotes; }
    public String getPushId() { return pushId; }
    public String getTopicId() { return topicId; }

    public void setPushId(String _pushId) { pushId = _pushId; }
    public void setTopicId(String _topicId) { topicId = _topicId; }
}
