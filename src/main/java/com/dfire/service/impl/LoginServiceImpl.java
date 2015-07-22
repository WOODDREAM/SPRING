package com.dfire.service.impl;

import com.dfire.bean.User;
import com.dfire.dao.BaseDao;
import com.dfire.exception.DaoException;
import com.dfire.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User:huangtao
 * Date:2015-07-20
 * description：
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private BaseDao baseDao;

    static String addUser = "insert into user(userName,passWord,firstName,lastName,birthday,age) values(:userName,:passWord,:firstName,:lastName,:birthday,:age);";
    static String getUser = "select * from user where userName = ? and passWord = ?";

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public User getUser(String username, String password) throws DaoException {
        User user = null;
        user = baseDao.getObject(getUser,User.class, new Object[]{username,password});
        return user;
    }

    @Override
    public void addUser(User user) throws DaoException {
        baseDao.saveOrUpdateObject(addUser,user);
    }
}
