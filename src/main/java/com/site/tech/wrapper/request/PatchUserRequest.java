package com.site.tech.wrapper.request;

import com.site.tech.enumeration.LanguageCode;
import com.site.tech.enumeration.ThemeCode;

import javax.validation.constraints.Email;

public class PatchUserRequest {
    @Email
    private String email;
    private LanguageCode language;
    private ThemeCode theme;
    private Integer messagesCount;
    private Integer roomsCount;

    public PatchUserRequest() {
    }

    public PatchUserRequest(String email, LanguageCode language, ThemeCode theme, Integer messagesCount, Integer roomsCount) {
        this.email = email;
        this.language = language;
        this.theme = theme;
        this.messagesCount = messagesCount;
        this.roomsCount = roomsCount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
