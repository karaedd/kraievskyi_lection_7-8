package com.kraievskyi.task.dao.impl;

import com.kraievskyi.task.dao.UserDao;
import com.kraievskyi.task.model.User;
import com.kraievskyi.task.service.UserService;
import com.kraievskyi.task.service.impl.UserServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserDaoImplTest {
    private static final String LOGIN = "Alex@gmail.com";
    private static final String NAME = "Alex";
    private static final String PASSWORD = "12345";
    private static UserDao userDao;
    private static UserService userService;
    private static User user;

    @BeforeAll
    static void setUp() {
        user = new User(LOGIN, NAME, PASSWORD);
        userDao = Mockito.mock(UserDao.class);
        userService = new UserServiceImpl(userDao);
    }

    @Test
    void findByUserLogin_Ok() {
        Mockito.when(userDao.findByUserLogin(LOGIN)).thenReturn(Optional.of(user));
        Optional<User> actual = userService.findByUserLogin(LOGIN);
        Optional<User> expected = Optional.of(user);
        Assertions.assertEquals(actual, expected);
    }
}
