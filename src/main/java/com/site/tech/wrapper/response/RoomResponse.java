package com.site.tech.wrapper.response;

import java.util.Date;
import java.util.List;

public class RoomResponse {
    private Long id;

    private String name;

    private List<Long> userIds;
    private Date lastMessageTime;

    public RoomResponse() {
    }

    public RoomResponse(Long id, String name, List<Long> userIds, Date lastMessageTime) {
        this.id = id;
        this.name = name;
        this.userIds = userIds;
        this.lastMessageTime = lastMessageTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public Date getLastMessageTime() {
        return lastMessageTime;
    }

    public void setLastMessageTime(Date lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
    }
}
