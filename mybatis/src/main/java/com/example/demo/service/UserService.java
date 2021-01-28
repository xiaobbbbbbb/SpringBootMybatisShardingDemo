package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserDao;
import com.example.demo.vo.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public int save(User user) {
        return userDao.insertSelective(user);
    }

    public User listUser(Long id) {
        return userDao.selectByPrimaryKey(id);

    }

    /**
     * 插件分页
     *
     * @param pageRequest
     * @return
     */
    public PageInfo<User> getPage(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        PageHelper.orderBy(" id desc");
        List<User> list = userDao.listUsers(null);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }


    /**
     * 自定义分页
     *
     * @return
     */
    public Page<User> getPageBySelf(PageRequest pageRequest) {
        Pageable pageable = org.springframework.data.domain.PageRequest.of(pageRequest.getPageNum(), pageRequest.getPageSize());

        long count = userDao.countPage(null);
        Map<String, Object> map = new HashMap<>();
        map.put("offSet", pageable.getOffset());
        map.put("pageSize", pageRequest.getPageSize());
        List<User> list = userDao.findPage(map);
        return new PageImpl(list, pageable, count);

    }

}
