package com.kraievskyi.task.dao;

import com.kraievskyi.task.model.User;
import java.util.Optional;
import java.util.Set;

public interface UserDao {

    Optional<User> findByUserName(String name);

    Set<User> getAll();
}
