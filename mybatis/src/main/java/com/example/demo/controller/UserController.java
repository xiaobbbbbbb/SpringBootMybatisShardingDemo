package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.vo.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/index")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        return "index";
    }


    /**
     * @Description: 批量保存用户
     */
    @RequestMapping("save-user")
    @ResponseBody
    public Object saveUser(User user) {
        return userService.save(user);
    }

    /**
     * @Description: 获取用户列表
     */
    @GetMapping("getUserById")
    @ResponseBody
    public Object getUser(long id) {
        return userService.listUser(id);
    }

    /**
     * @Description: 获取用户列表
     */
    @GetMapping("getUsers")
    @ResponseBody
    public Object getUsers(PageRequest pageRequest) {

        return userService.getPage(pageRequest);
    }

    /**
     * @Description: 获取用户列表
     */
    @GetMapping("getUsersByself")
    @ResponseBody
    public Object getUsersByself(PageRequest pageRequest) {

        return userService.getPageBySelf(pageRequest);
    }
}
