package test;


import com.dfire.bean.User;
import com.dfire.mapper.Mapper;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User:huangtao
 * Date:2015-07-23
 * description：
 */

public class TestMybatisForUser extends BaseTest{


    @Resource(name = "userMapper")
    private Mapper mapper;

    private User user;
    @Test
    public void testMybatis(){
       user =  mapper.getUser(3);
        Assert.assertEquals("z",user.getPassWord());
    }

    @Test
    public void  testUpdate(){
        mapper.updateUser("ffff");
        user = mapper.getUser(4);
        Assert.assertEquals("aaaa",user.getPassWord());
    }

    @Test
    public void testListSelect(){
        Assert.assertEquals(5,mapper.listSelect().size());
//       System.out.print(mapper.listSelect().size());
    }

    @Test
    public void testInsert(){
        user = new User();
        user.setUserName("huangtao");
        user.setPassWord("123");
        user.setFirstName("huang");
        user.setLastName("tao");
        user.setBirthday("1208");
        user.setAge(23);
//        mapper.addUser(user);
        Assert.assertEquals(user.getUserName(),mapper.getUserByName(user.getUserName()).getUserName());
    }
}
