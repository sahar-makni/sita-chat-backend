package com.site.tech.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "room")
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "room_users", joinColumns = @JoinColumn(name = "room_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @OneToMany(mappedBy = "room")
    private List<Message> roomMessages = new ArrayList<>();

    public Room() {
    }

    public Room(Long id, String name, List<User> users, List<Message> roomMessages) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.roomMessages = roomMessages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getRoomMessages() {
        return roomMessages;
    }

    public void setRoomMessages(List<Message> roomMessages) {
        this.roomMessages = roomMessages;
    }

    public Date getLastMessageTime() {
        return roomMessages
                .stream()
                .map(Message::getSendDate)
                .max(Date::compareTo)
                .orElse(null);
    }

}
