package com.zb.demo.controller;


import com.zb.demo.entity.TOrder;
import com.zb.demo.service.TOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class OrderController {
    private TOrderServiceImpl orderService;

    @Autowired
    public void setOrderService(TOrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/index")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        return "index";
    }


    /**
     * @Description: 批量保存用户
     */
    @RequestMapping("save")
    @ResponseBody
    public Object save(TOrder order) {

        return orderService.save(order);
    }

    /**
     * @Description: 获取用户列表
     */
    @GetMapping("getById")
    @ResponseBody
    public Object getById(String id) {
        return orderService.findById(id);
    }

    /**
     * @Description: 分页查询
     */
    @GetMapping("getPage")
    @ResponseBody
    public Object getPage(int pageSize, int pageNo) {

        return orderService.page(pageSize,pageSize);
    }


}
