package com.dfire.controller;

import com.dfire.bean.User;
import com.dfire.exception.DaoException;
import com.dfire.service.LoginService;
import com.dfire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User:huangtao
 * Date:2015-07-20
 * description：
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    22222222222222@@@@@
    
    private UserService userService;


    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value="/user/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/user/logon",method = RequestMethod.POST)
    public String logon(String userName,String passWord){
        System.out.print("userName :"+userName);
        User user = null;
        try{
            user = loginService.getUser(userName, passWord);
        }catch(RuntimeException e){
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        if(user!=null){
           return "MyHome" ;
        }else{
            return "login";
        }
    }

    @RequestMapping(value="/user/register",method = RequestMethod.POST)
    public String register(User user) throws DaoException {
        loginService.addUser(user);
        return "login";
    }
}
