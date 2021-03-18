package org.lanqiao.controller;

import org.lanqiao.pojo.User;
import org.lanqiao.utils.Result;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/index")
    public Result index(List<User> userList) {
        userList.forEach(System.out::println);
        return Result.success(userList);
    }

    @RequestMapping("/login")
    public Result login(User user, HttpServletRequest request) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("1234")) {
            request.getSession().setAttribute("user", user);
            return Result.success();
        } else {
            return Result.fail();
        }
    }

}
