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

    public User adduser(UserRequestWrapper userRequestWrapper) {
        User user = UserMapper.INSTANCE.requestToEntity(userRequestWrapper);
        System.out.println(user);
        String hashedPassword = BCrypt.withDefaults().hashToString(10, user.getPassword().toCharArray());
        System.out.println(hashedPassword);
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }
}
