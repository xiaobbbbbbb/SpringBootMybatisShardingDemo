package com.zb.shardingdemo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zb.shardingdemo.entity.User;
import com.zb.shardingdemo.mapper.UserDao;
import com.zb.shardingdemo.service.UserService;
import com.zb.shardingdemo.util.PageRequest;
import com.zb.shardingdemo.util.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index(ModelMap modelMap, HttpServletRequest request){
        modelMap.addAttribute("now", DateFormat.getDateInstance().format(new Date()));
        logger.info("我是控制器日志..");
        return "index";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public PageResult list(PageRequest pageRequest) {

        return userService.getPageResult(pageRequest);
    }

    /**
     * 自定义分页
     * @return
     */
    @RequestMapping(value = "/listData")
    @ResponseBody
    public Page listData(PageRequest pageRequest) {

        return userService.getPageBySelf(pageRequest);
    }

    /**
     * add用户
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(User user) {
        userService.save(user);
        return user.toString();
    }

}
