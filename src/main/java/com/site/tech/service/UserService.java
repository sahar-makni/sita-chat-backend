package com.site.tech.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.site.tech.entity.User;
import com.site.tech.mapper.UserMapper;
import com.site.tech.repository.UserRepository;
import com.site.tech.wrapper.request.UserRequestWrapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequestWrapper userRequestWrapper) {
        User user = UserMapper.INSTANCE.requestToEntity(userRequestWrapper);
        String hashedPassword = BCrypt.withDefaults().hashToString(10, user.getPassword().toCharArray());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }
}
