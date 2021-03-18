package org.lanqiao.controller;

import org.lanqiao.pojo.Message;
import org.lanqiao.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController {

    @PostMapping("insert")
    public Result insert(Message msg, HttpServletRequest req){
        System.out.println(msg);
        // list
        List<Message> msgList = (List<Message>) req.getSession().getAttribute("msgList");
        if (msgList == null) {
            msgList = new ArrayList<>();
        }
        msgList.add(msg);
        req.getSession().setAttribute("msgList", msgList);
        return Result.success();
    }

    @GetMapping("getAll")
    public Result getAll(HttpServletRequest req){
        List<Message> list = (List<Message>) req.getSession().getAttribute("msgList");
        return Result.success(list);
    }

}
