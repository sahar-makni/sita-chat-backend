package com.site.tech.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.site.tech.entity.User;
import com.site.tech.mapper.UserMapper;
import com.site.tech.repository.UserRepository;
import com.site.tech.wrapper.request.SignInRequest;
import com.site.tech.wrapper.request.UserRequestWrapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public User trySignIn(SignInRequest signInRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(signInRequest.getEmail());
        User user =  optionalUser.orElseThrow(()-> new RuntimeException("user not found"));
        BCrypt.Result result = BCrypt.verifyer().verify(signInRequest.getPassword().toCharArray(), user.getPassword().toCharArray());
        if (!result.verified) {
            throw new RuntimeException("user or password are incorrect");
        }
        return user;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->  new RuntimeException("404 NOT FOUND: User Not Found :'("));
    }
}
