//package com.site.tech.service;
//
//import at.favre.lib.crypto.bcrypt.BCrypt;
//import com.site.tech.entity.User;
//import com.site.tech.repository.UserRepository;
//import com.site.tech.wrapper.request.UserRequestWrapper;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class UserServiceTest {
//    @MockBean
//    UserRepository userRepository;
//    @MockBean
//    BCrypt.Hasher bCrypt;
//    @Autowired
//    UserService userService;
//
//
//
//    @Test
//    void createUser_should_succeed() {
//        // GIVEN
//        UserRequestWrapper userRequest = new UserRequestWrapper("email@example.com", "awesome password");
//        User mockedUser = new User(1L, "email@example.com", "hashed password");
//        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
//        ArgumentCaptor<String> passwordArgumentCaptor = ArgumentCaptor.forClass(String.class);
//        when(userRepository.save(userArgumentCaptor.capture())).thenReturn(mockedUser);
//        when(bCrypt.hashToString(any(),passwordArgumentCaptor.capture().toCharArray())).thenReturn("hashed password");
//
//        // WHEN
//        User createdUser = userService.createUser(userRequest);
//        // THEN
//
//
//
//    }
//}