package com.zb.shardingdemo.mapper;

import com.zb.shardingdemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

//    Page<User> listUsersPage(@Param("map") Map<String, String> map, int page,int pageSize );

    List<User> listUsers(@Param("map") Map<String, Object> map);

    List<User> findPage(@Param("map") Map<String, Object> map);

    long countPage(@Param("map") Map<String, Object> map);
}