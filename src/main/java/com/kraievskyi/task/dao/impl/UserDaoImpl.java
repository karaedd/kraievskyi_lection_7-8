package com.kraievskyi.task.dao.impl;

import com.kraievskyi.task.dao.UserDao;
import com.kraievskyi.task.lib.Dao;
import com.kraievskyi.task.model.User;
import java.util.Optional;
import java.util.Set;

@Dao
public class UserDaoImpl implements UserDao {
    private final Set<User> userDao = Set.of(
            new User("Alex@gmail.com","Alex", "12345"),
            new User("John@gmail.com", "John", "qwerty"),
            new User("David@gmail.com","David", "password"));

    @Override
    public Optional<User> findByUserName(String login) {
        return userDao.stream()
                .filter(x -> x.getLogin()
                .equals(login))
                .findFirst();
    }

    @Override
    public Set<User> getAll() {
        return userDao;
    }
}
