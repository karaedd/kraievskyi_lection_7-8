package com.kraievskyi.task.service.impl;

import com.kraievskyi.task.exception.AuthenticationException;
import com.kraievskyi.task.lib.Inject;
import com.kraievskyi.task.lib.Service;
import com.kraievskyi.task.model.User;
import com.kraievskyi.task.service.AuthenticationService;
import com.kraievskyi.task.service.UserService;
import java.util.Optional;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Inject
    private UserService userService;

    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User login(String login, String password) throws AuthenticationException {
        Optional<User> user = userService.findByUserLogin(login);
        if (user.isEmpty()) {
            throw new AuthenticationException("Login or password were incorrect");
        }
        if (user.get().getPassword().equals(password)) {
            return user.get();
        }
        throw new AuthenticationException("Login or password were incorrect");
    }
}
