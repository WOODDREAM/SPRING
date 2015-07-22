package com.dfire.mapper;

import com.dfire.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User:huangtao
 * Date:2015-07-22
 * description：
 */

@Repository( value = "userMapper")
public interface Mapper {

    @Select(value = "${sql}")
    @Results(value = {  @Result(id=true,property = "id",column = "userID"),
           @Result(property = "userName" , column = "userName"),
            @Result(property = "passWord",column = "passWord"),
            @Result(property = "firstName",column = "firstName"),
            @Result(property = "lastName",column = "lastName"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "age",column = "age"),
             })
    List<User> operateReturnBeans(@Param(value = "sql")String sql);
}
