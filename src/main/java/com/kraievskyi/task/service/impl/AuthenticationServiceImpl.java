package com.kraievskyi.task.service.impl;

import com.kraievskyi.task.exception.AuthenticationException;
import com.kraievskyi.task.lib.Inject;
import com.kraievskyi.task.lib.Service;
import com.kraievskyi.task.model.User;
import com.kraievskyi.task.service.AuthenticationService;
import com.kraievskyi.task.service.UserService;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Inject
    private UserService userService;

    @Override
    public User login(String userName, String password) throws AuthenticationException {
        Optional<User> user = userService.findByUserName(userName);
        if (user.isEmpty()) {
            throw new AuthenticationException("Username or password were incorrect");
        }
        if (user.get().getPassword().equals(password)) {
            return user.get();
        }
        throw new AuthenticationException("Username or password were incorrect");
    }
}
