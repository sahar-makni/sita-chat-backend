package com.site.tech.entity;

import com.site.tech.enumeration.LanguageCode;
import com.site.tech.enumeration.ThemeCode;

import javax.persistence.*;

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


    public User() {
    }

    public User(Long id, String email, String password, LanguageCode language, ThemeCode theme) {
        this.id = id;
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
