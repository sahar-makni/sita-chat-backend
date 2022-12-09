package com.site.tech.wrapper.response;

import com.site.tech.entity.Room;
import com.site.tech.entity.User;

import javax.persistence.*;
import java.sql.Timestamp;

public class MessageResponse {
    private Long id;

    private Long roomId;

    private Long senderId;

    private String text;

    private Timestamp sendDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
    }
}
