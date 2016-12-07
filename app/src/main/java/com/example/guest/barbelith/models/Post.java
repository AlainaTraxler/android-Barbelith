package com.example.guest.barbelith.models;

/**
 * Created by Guest on 12/5/16.
 */
public class Post {
    String content;
    int upvotes = 0;
    int downvotes = 0;
    String pushId;
    String topicId;
    String userId;

    public Post() {};

    public Post(String _content, String _userId){
        content = _content;
        userId = _userId;
    }

    public String getContent(){ return content; }
    public String getUserId(){ return userId; }
    public int getUpvotes(){ return upvotes; }
    public int getDownvotes(){ return downvotes; }
    public String getPushId() { return pushId; }
    public String getTopicId() { return topicId; }

    public void setPushId(String _pushId) { pushId = _pushId; }
    public void setTopicId(String _topicId) { topicId = _topicId; }
}
