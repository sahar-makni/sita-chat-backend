package com.site.tech.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.site.tech.entity.User;
import com.site.tech.enumeration.LanguageCode;
import com.site.tech.enumeration.ThemeCode;
import com.site.tech.mapper.UserMapper;
import com.site.tech.repository.UserRepository;
import com.site.tech.wrapper.request.ChangePasswordRequest;
import com.site.tech.wrapper.request.PatchUserRequest;
import com.site.tech.wrapper.request.SignInRequest;
import com.site.tech.wrapper.request.UserRequest;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest userRequest) {
        User user = UserMapper.INSTANCE.requestToEntity(userRequest);
        String hashedPassword = BCrypt.withDefaults().hashToString(10, user.getPassword().toCharArray());
        user.setPassword(hashedPassword);
        // set default theme and language
        user.setLanguage(LanguageCode.EN);
        user.setTheme(ThemeCode.ARYA_BLUE);
        user.setMessagesCount(0);
        user.setRoomsCount(0);
        return userRepository.save(user);
    }

    public User trySignIn(SignInRequest signInRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(signInRequest.getEmail());
        User user = optionalUser.orElseThrow(() -> new RuntimeException("user not found"));
        BCrypt.Result result = BCrypt.verifyer().verify(signInRequest.getPassword().toCharArray(), user.getPassword().toCharArray());
        if (!result.verified) {
            throw new RuntimeException("user or password are incorrect");
        }
        return user;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("404 NOT FOUND: User Not Found :'("));
    }

    public User patchUserById(Long id, PatchUserRequest patchUserRequest) {
        User user = getUserById(id);
        if (StringUtils.isNotBlank(patchUserRequest.getEmail())) {
            user.setEmail(patchUserRequest.getEmail());
        }
        if (patchUserRequest.getLanguage() != null) {
            user.setLanguage(patchUserRequest.getLanguage());
        }
        if (patchUserRequest.getTheme() != null) {
            user.setTheme(patchUserRequest.getTheme());
        }
        if (patchUserRequest.getRoomsCount() != null) {
            user.setRoomsCount(patchUserRequest.getRoomsCount());
        }
        if (patchUserRequest.getMessagesCount() != null) {
            user.setMessagesCount(patchUserRequest.getMessagesCount());
        }
        return userRepository.save(user);
    }

    public void changePassword(Long userId, ChangePasswordRequest changePasswordRequest) {
        User user = getUserById(userId);
        BCrypt.Result result = BCrypt.verifyer().verify(changePasswordRequest.getOldPassword().toCharArray(), user.getPassword().toCharArray());
        if (!result.verified) {
            throw new RuntimeException("400 BAD REQUEST: wrong old password");
        }
        String hashedPassword = BCrypt.withDefaults().hashToString(10, changePasswordRequest.getNewPassword().toCharArray());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }
}
