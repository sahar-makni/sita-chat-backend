package com.site.tech.wrapper.response;

import com.site.tech.enumeration.LanguageCode;
import com.site.tech.enumeration.ThemeCode;

public class UserResponseWrapper {
    private Long id;
    private String email;
    private LanguageCode language;
    private ThemeCode theme;

    public UserResponseWrapper() {
    }

    public UserResponseWrapper(Long id, String email, LanguageCode language, ThemeCode theme) {
        this.id = id;
        this.email = email;
        this.language = language;
        this.theme = theme;
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
}
