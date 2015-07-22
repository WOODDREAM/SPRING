package com.dfire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User:huangtao
 * Date:2015-07-20
 * description：
 */
@Controller
public class MyHomeController extends BaseController {
    @RequestMapping(value="/user/myHome",method = RequestMethod.GET)
    public String ajaxGet(){
        return "myHome";
    }

}
