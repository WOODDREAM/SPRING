package com.dfire.service.impl;

import com.dfire.bean.User;
import com.dfire.mapper.Mapper;
import com.dfire.service.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * User:huangtao
 * Date:2015-07-22
 * description：
 */

@Repository(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    private Mapper mapper;

    @Override
    public List<User> find() {
        String sql = "select * from user";
        return this.mapper.operateReturnBeans(sql);
    }
}
