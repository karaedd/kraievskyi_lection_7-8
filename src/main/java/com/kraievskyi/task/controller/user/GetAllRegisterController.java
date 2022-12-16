package com.kraievskyi.task.controller.user;

import com.kraievskyi.task.lib.Injector;
import com.kraievskyi.task.model.User;
import com.kraievskyi.task.service.UserService;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAllRegisterController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.kraievskyi.task");
    private final UserService userService = (UserService) injector
            .getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Set<User> allUsers = userService.getAll();
        req.setAttribute("users", allUsers);
        req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
    }
}
