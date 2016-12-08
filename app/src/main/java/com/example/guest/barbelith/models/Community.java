package com.example.guest.barbelith.models;

/**
 * Created by Guest on 12/7/16.
 */
public class Community {
    String creatorId;
    String name;
    String description;
    String pushId;

    public Community(String _name, String _description, String _creatorId){
        name = _name;
        description = _description;
        creatorId = _creatorId;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCreatorId() { return creatorId; }
    public String getPushId() { return pushId; }

    public void setPushId(String _pushId) { pushId = _pushId; }
}
