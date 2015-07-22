package com.dfire.util;

import com.dfire.exception.DaoException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User:huangtao
 * Date:2015-07-20
 * description：
 */
@Repository(value="util")
public class DBUtil {

    private Log log = LogFactory.getLog(DBUtil.class);

    private SimpleJdbcTemplate simpJdbcTemplate;

    public Integer addOrUpdate(String sql,Object obj) throws DaoException {
       Integer id=0;
        try{
//            Map  <String,Object> params = new HashMap<String, Object>();
//            params.put("userName","ffff");
//            params.put("passWord","3333");
//            params.put("firstName","3333");
//            params.put("lastName","3333");
//            params.put("birthday","3333");
//            params.put("age","33");
//            id= simpJdbcTemplate.update(sql, params);
            id= simpJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(obj));

        }catch(Exception e){
            log.info(e);
            throw new DaoException("数据库操作失败！",e);
        }
        return id;
    }

    public List<?> getObjList(String sql,Class<?> className,Object[] obj ) throws DaoException {
        List<?> list = null;
        try{
            list = simpJdbcTemplate.queryForList(sql,
                    ParameterizedBeanPropertyRowMapper.newInstance(className),obj);
        }catch(Exception e){
            log.info(e);
            throw new DaoException("数据库操作失败！",e);
        }
        return list;
    }
    public Map<String,?> getMap(String sql,Object[] obj) throws DaoException {
        Map<String,?> map = null;
        try{
            map = simpJdbcTemplate.queryForMap(sql,obj);
        }catch(Exception e){
            log.info(e);
            throw new DaoException("数据库操作失败！",e);
        }
        return map;
    }
    public Object getObject(String sql, Class<? extends Serializable> className,Object[] obj) throws DaoException {
        Object object = null;
        try{
            object = simpJdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(className),obj);
        }catch(Exception e){
            log.info(e);
//            return null;
            throw  new DaoException("数据库操作失败！",e);
        }
        return object;
    }

    /**
     * 批量操作
     * @param sql
     * @param obj
     * @return
     */
    public int[] batchOperate(String sql,List<?> obj) throws DaoException {
        int[] a = null;
        try{
          a = simpJdbcTemplate.batchUpdate(sql, SqlParameterSourceUtils.createBatch(obj.toArray()));
        }catch(Exception e){
            log.info(e);
            throw new DaoException("数据库操作失败！",e);
        }
        return a;
    }

    /**
     * 检查是否有值
     * @param sql
     * @param obj
     * @return
     */
    public int isExist(String sql,Object[] obj) throws DaoException {
        int index = 0;
        try{
            index  = simpJdbcTemplate.queryForInt(sql,obj);
        }catch (Exception e){
            log.info(e);
            throw new DaoException("数据库操作失败！",e);
        }
        return index;
    }
    public int editobject(String ssql, Object[] obj) throws DaoException {
        int index = 0;
        try{
            index = simpJdbcTemplate.update(ssql,obj);
        }catch(Exception e){
            log.info(e);
            throw new DaoException("数据库操作失败！",e);
        }
        return 0;
    }

    /**
     *
     * @param dataSource
     */
    @Resource(name="dataSource")
    public void setSimpJdbcTemplate(DataSource dataSource) {
        this.simpJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
}
