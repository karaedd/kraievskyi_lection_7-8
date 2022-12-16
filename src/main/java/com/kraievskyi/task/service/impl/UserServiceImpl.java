package com.kraievskyi.task.service.impl;

import com.kraievskyi.task.dao.UserDao;
import com.kraievskyi.task.lib.Inject;
import com.kraievskyi.task.lib.Service;
import com.kraievskyi.task.model.User;
import com.kraievskyi.task.service.UserService;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public Optional<User> findByUserName(String name) {
        return userDao.findByUserName(name);
    }

    @Override
    public Set<User> getAll() {
        return userDao.getAll();
    }
}
