package com.site.tech.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.site.tech.entity.User;
import com.site.tech.enumeration.LanguageCode;
import com.site.tech.enumeration.ThemeCode;
import com.site.tech.exception.BusinessException;
import com.site.tech.mapper.UserMapper;
import com.site.tech.repository.UserRepository;
import com.site.tech.wrapper.request.ChangePasswordRequest;
import com.site.tech.wrapper.request.PatchUserRequest;
import com.site.tech.wrapper.request.SignInRequest;
import com.site.tech.wrapper.request.UserRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User createUser(UserRequest userRequest) {
        User user = userMapper.requestToEntity(userRequest);
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
        User user = optionalUser.orElseThrow(() -> new BusinessException("user not found"));
        BCrypt.Result result = BCrypt.verifyer().verify(signInRequest.getPassword().toCharArray(), user.getPassword().toCharArray());
        if (!result.verified) {
            throw new BusinessException("user or password are incorrect");
        }
        return user;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BusinessException("404 NOT FOUND: User Not Found :'("));
    }

    public User patchUserById(Long id, PatchUserRequest patchUserRequest) {
        User user = getUserById(id);
        if (!ObjectUtils.isEmpty(patchUserRequest.getEmail()) && !patchUserRequest.getEmail().trim().isEmpty()) {
            user.setEmail(patchUserRequest.getEmail());
        }
        if (patchUserRequest.getLanguage() != null) {
            user.setLanguage(patchUserRequest.getLanguage());
        }
        if (patchUserRequest.getTheme() != null) {
            user.setTheme(patchUserRequest.getTheme());
        }
        return userRepository.save(user);
    }

    public void changePassword(Long userId, ChangePasswordRequest changePasswordRequest) {
        User user = getUserById(userId);
        BCrypt.Result result = BCrypt.verifyer().verify(changePasswordRequest.getOldPassword().toCharArray(), user.getPassword().toCharArray());
        if (!result.verified) {
            throw new BusinessException("400 BAD REQUEST: wrong old password");
        }
        String hashedPassword = BCrypt.withDefaults().hashToString(10, changePasswordRequest.getNewPassword().toCharArray());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }
}
