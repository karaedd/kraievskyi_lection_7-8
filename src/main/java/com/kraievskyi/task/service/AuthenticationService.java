package com.kraievskyi.task.service;

import com.kraievskyi.task.exception.AuthenticationException;
import com.kraievskyi.task.model.User;

public interface AuthenticationService {
    User login(String login, String password) throws AuthenticationException;
}
