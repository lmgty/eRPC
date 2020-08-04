package com.yufa.xz.client.controller;

import com.yufa.xz.client.remoteservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @data 2020/7/30
 */

@RestController
public class RemoteController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users/listALL")
    public String listAll() {
        return userService.listAll();
    }

    @RequestMapping("/users/{id}")
    public String listById( @PathVariable Integer id) {
        return userService.listById(id);
    }

    @RequestMapping("/addUser")
    public String create() {
        Integer count = userService.create("小白", 22, 1);
        return count.toString();
    }


}
