package com.example.guest.barbelith.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 12/5/16.
 */
@Parcel
public class Topic {
    String title;
    String content;
    String userId;
    String category;
    String pushId;
    long replyCount;

    public Topic() {}

    public Topic(String _title, String _content, String _userId, String _category){
        title = _title;
        content = _content;
        userId = _userId;
        category = _category;
    }

    public String getTitle(){ return title; }
    public String getContent() { return content; }
    public String getUserId() { return userId; }
    public String getCategory() { return category; }
    public String getPushId() { return pushId; }
    public long getReplyCount() { return replyCount; }

    public void setPushId(String _pushId) { pushId = _pushId; }
    public void setReplyCount(long _replyCount) { replyCount = _replyCount; };
}
