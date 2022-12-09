package com.site.tech.entity;

import com.site.tech.enumeration.LanguageCode;
import com.site.tech.enumeration.ThemeCode;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private LanguageCode language;
    @Enumerated(EnumType.STRING)
    private ThemeCode theme;
    private Integer messagesCount;
    private Integer roomsCount;

    @OneToMany(mappedBy = "sender")
    private List<Message> roomMessages;

    @ManyToMany(mappedBy = "users")
    private List<Room> rooms;


    public User() {
    }


    public User(Long id, String email, String password, LanguageCode language, ThemeCode theme, Integer messagesCount, Integer roomsCount, List<Room> rooms) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.language = language;
        this.theme = theme;
        this.messagesCount = messagesCount;
        this.roomsCount = roomsCount;
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LanguageCode getLanguage() {
        return language;
    }

    public void setLanguage(LanguageCode language) {
        this.language = language;
    }

    public ThemeCode getTheme() {
        return theme;
    }

    public void setTheme(ThemeCode theme) {
        this.theme = theme;
    }

    public Integer getMessagesCount() {
        return messagesCount;
    }

    public void setMessagesCount(Integer messagesCount) {
        this.messagesCount = messagesCount;
    }

    public Integer getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(Integer roomsCount) {
        this.roomsCount = roomsCount;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", language=" + language +
                ", theme=" + theme +
                ", messagesCount=" + messagesCount +
                ", roomsCount=" + roomsCount +
                ", rooms=" + rooms +
                '}';
    }

    public List<Message> getRoomMessages() {
        return roomMessages;
    }

    public void setRoomMessages(List<Message> roomMessages) {
        this.roomMessages = roomMessages;
    }
}
