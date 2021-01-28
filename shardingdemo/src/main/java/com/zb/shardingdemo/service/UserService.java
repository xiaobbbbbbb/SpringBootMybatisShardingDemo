package com.zb.shardingdemo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zb.shardingdemo.entity.User;
import com.zb.shardingdemo.mapper.UserDao;
import com.zb.shardingdemo.util.PageRequest;
import com.zb.shardingdemo.util.PageResult;
import com.zb.shardingdemo.util.PageUtil;
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

    public PageInfo<User> getPage(PageRequest pageRequest){
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<User> list = userDao.listUsers(null);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 自定义分页
     * @return
     */
    public Page<User> getPageBySelf(PageRequest pageRequest){
        Pageable pageable = org.springframework.data.domain.PageRequest.of(pageRequest.getPageNum(),pageRequest.getPageSize());

        long count = userDao.countPage(null);
        Map<String,Object> map = new HashMap<>();
        map.put("offSet",pageable.getOffset());
        map.put("pageSize",pageRequest.getPageSize());
        List<User> list = userDao.findPage(map);
        return new PageImpl(list,pageable,count);

    }

    public PageResult getPageResult(PageRequest pageRequest){
        return PageUtil.getPageResult(pageRequest,this.getPage(pageRequest));
    }


    public int save(User user){
        return userDao.insertSelective(user);
    }

}
