package com.dfire.dao.impl;

import com.dfire.dao.BaseDao;
import com.dfire.exception.DaoException;
import com.dfire.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * User:huangtao
 * Date:2015-07-20
 * description：
 */
@Repository
public class BaseDaoImpl implements BaseDao{
    @Autowired
    private DBUtil util;

    public DBUtil getUtil() {
        return util;
    }

    public void setUtil(DBUtil util) {
        this.util = util;
    }

    @Override
    public <T extends Serializable> void saveOrUpdateObject(String sql, T entity) throws DaoException {
        util.addOrUpdate(sql,entity);
    }

    @Override
    public <T extends Serializable> List<T> getObjList(String sql, Class<T> clasName, Object[] objs) throws DaoException {
        return (List<T>) util.getObjList(sql,clasName,objs);
    }

    @Override
    public <T extends Serializable> T getObject(String sql, Class<T> clazz, Object[] objs) throws DaoException {
        return (T)util.getObject(sql,clazz,objs);
    }

    @Override
    public Map<String, ?> find(String sql, Object[] objects) throws DaoException {
        return  util.getMap(sql,objects);
    }

    @Override
    public int isExist(String sql, Object[] obj) throws DaoException {
        return util.isExist(sql,obj);
    }

    @Override
    public int editObject(String ssql, Object[] obj) throws DaoException {
        return util.editobject(ssql,obj);
    }

    @Override
    public void batchOperate(String sql, List<?> objLs) throws DaoException {
        util.batchOperate(sql,objLs);
    }
}
