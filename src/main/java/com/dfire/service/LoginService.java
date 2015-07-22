package com.dfire.service;

import com.dfire.bean.User;
import com.dfire.exception.DaoException;

/**
 * User:huangtao
 * Date:2015-07-20
 * description：
 */
public interface LoginService {
    public User getUser(String name,String password) throws DaoException;

    public void addUser(User user) throws DaoException;
}
