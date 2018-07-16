package com.jarry.controller;

import com.github.pagehelper.PageInfo;
import com.jarry.domain.User;
import com.jarry.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jarry on 2018/6/14.
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private MybatisService mybatisService;

    @RequestMapping("/user")
    public User getUserById(Integer id) {
        return mybatisService.getUserById(id);
    }

    @RequestMapping("/user/add")
    public User addUser(Integer age, String name, String password) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setPassword(password);
        return mybatisService.addUser(user);
    }

    @RequestMapping("/user/del")
    public void delUser(Integer id) {
        mybatisService.delUser(id);
    }

    @RequestMapping("/user/update")
    public int updateUser(Integer id, Integer age, String name, String password) {
        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setName(name);
        user.setPassword(password);
        return mybatisService.updateUser(user);
    }

    @RequestMapping("/user/findAll")
    public PageInfo<User> findAll() {
        List<User> list = mybatisService.findAll();
        return new PageInfo<User>(list);
    }

    @RequestMapping("/user/ts")
    public void testTransation() {
        mybatisService.testTransation();
    }
}
