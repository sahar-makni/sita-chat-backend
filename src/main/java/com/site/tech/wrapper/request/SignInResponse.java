package com.site.tech.wrapper.request;

public class SignInResponse {
    private String accessToken;

    public SignInResponse(String accessToken) {
        this.accessToken = accessToken;
    }
    public SignInResponse() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
