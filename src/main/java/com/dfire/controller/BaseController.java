package com.dfire.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User:huangtao
 * Date:2015-07-20
 * description：
 */
@Controller
public class BaseController {
    protected void ininBinder(WebDataBinder binder){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat,true));
    }
}
