package com.kraievskyi.task.service.impl;

import com.kraievskyi.task.exception.AuthenticationException;
import com.kraievskyi.task.model.User;
import com.kraievskyi.task.service.AuthenticationService;
import com.kraievskyi.task.service.UserService;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AuthenticationServiceImplTest {

    private static final String EMAIL = "Alex@gmail.com";
    private static final String NAME = "Alex";
    private static final String PASSWORD = "12345";
    private static UserService userService;
    private static AuthenticationService authenticationService;
    private static User user;

    @BeforeAll
    static void setUp() {
        user = new User(EMAIL, NAME, PASSWORD);
        userService = Mockito.mock(UserService.class);
        authenticationService = new AuthenticationServiceImpl(userService);
    }

    @Test
    void login() {
        Mockito.when(userService.findByUserLogin(EMAIL))
                .thenReturn(Optional.of(user));
        User actual;
        try {
            actual = authenticationService.login(EMAIL, PASSWORD);
            Assertions.assertEquals(user, actual);
        } catch (AuthenticationException e) {
            Assertions.fail("Wrong email or password", e);
        }
    }
}
