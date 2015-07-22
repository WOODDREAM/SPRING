package com.dfire.dao;

import com.dfire.exception.DaoException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * User:huangtao
 * Date:2015-07-20
 * description：
 */
public interface BaseDao {
    <T extends Serializable> void saveOrUpdateObject(String sql,T entity) throws DaoException;
    <T extends Serializable> List<T> getObjList(String sql, Class<T> clasName, Object[] objs) throws DaoException;
    <T extends Serializable> T getObject(String sql,Class<T> clazz,Object[] objs) throws DaoException;

    Map<String, ?> find(String sql, Object[] objects) throws DaoException;

    int isExist(String sql,Object[] obj) throws DaoException;
    int editObject(String ssql,Object[] obj) throws DaoException;
    void batchOperate(String sql,List<?> objLs) throws DaoException;
}
