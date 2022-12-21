package com.kraievskyi.task.service;

import com.kraievskyi.task.model.User;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    Optional<User> findByUserLogin(String login);

    Set<User> getAll();
}
