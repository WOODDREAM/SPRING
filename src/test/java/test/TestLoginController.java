package test;

import com.dfire.bean.User;
import com.dfire.controller.LoginController;
import com.dfire.exception.DaoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

/**
 * User:huangtao
 * Date:2015-07-22
 * description：
 */
@ContextConfiguration(locations ="/applicationContext.xml" )
@RunWith(SpringJUnit4ClassRunner.class)
public class TestLoginController {

    protected MockMvc mockMvc;
    @Resource
    private LoginController loginController;

    private User user;

    @Before
    public void init(){
        user = new User();
        user.setId(11);
        user.setAge(21);
        user.setUserName("yrm");
        user.setBirthday("12/08");
        user.setFirstName("yyy");
        user.setLastName("mmm");
        user.setPassWord("1111");
    }

    @Test
    public void testLogin(){
//        loginController.login();
        Assert.assertEquals("login",loginController.login());
    }

    @Test
    public void testRegister() throws DaoException {

//        mockMvc.perform(post("/call_service/v1/call/{type}", SERVICE_TYPE).header("x-auth-token", TOKEN))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath("$.code", is("1"))).andDo(print()).andReturn().getResponse().getContentAsString();
                //        System.out.print(loginController);
//        loginController.register(user);

        Assert.assertEquals("MyHome", loginController.logon(user.getUserName(), user.getPassWord()));
    }

}
