package com.site.tech.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AuthService {
    public Long getUserIdFromAccessToken(String accessToken) {
        if (ObjectUtils.isEmpty(accessToken)) {
            throw new RuntimeException("403 FORBIDDEN : no access-token provided");
        }
        // since the access token is the user ID (du to time limitation, I was not able to implement the
        // oAuth2 protocol
        return Long.parseLong(accessToken);
    }
}
