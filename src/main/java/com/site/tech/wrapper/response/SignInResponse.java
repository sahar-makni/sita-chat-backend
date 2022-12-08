package com.site.tech.wrapper.response;

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
