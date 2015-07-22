package com.dfire.service;

import com.dfire.bean.User;

import java.util.List;

/**
 * User:huangtao
 * Date:2015-07-22
 * description：
 */
public interface UserService {
    /**
     * 查询所有
     * @return
     */
    List<User> find();
}
