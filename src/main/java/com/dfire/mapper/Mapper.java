package com.dfire.mapper;

import com.dfire.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User:huangtao
 * Date:2015-07-22
 * description：
 */

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

    @Select(value = "${sql}")
    User getUserById(@Param(value = "sql")String sql);

    User getUser(int id);

    User getUserByName(String userName);

    void updateUser(String userName);

    List<User> listSelect();

    void addUser(User user);

//    public interface UserMapper {
//        @Select("SELECT * FROM users WHERE id = #{userId}")
//        User getUser(@Param("userId") String userId);
//    }

//    要注意,所指定的映射器类必须是一个接口,而不是具体的实现类。在这个示例中,注 解被用来指定 SQL 语句,但是 MyBatis 的映射器 XML 文件也可以用。
}
