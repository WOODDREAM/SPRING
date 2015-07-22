package com.dfire.filter;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * User:huangtao
 * Date:2015-07-20
 * description：自定义拦截器
 */
public class MyInterceptor extends HandlerInterceptorAdapter {
    /**
     * 最后执行，释放资源
     * @param request
     * @param response
     * @param handler
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,
                                Object handler,Exception e) throws Exception {
        super.afterCompletion(request,response,handler,e);
    }

    /**
     * 显示视图前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request,HttpServletResponse response,
                           Object handler,ModelAndView modelAndView) throws Exception {
        System.out.println(request.getContentType()+"-----"+request.getCharacterEncoding()+"------"+request.getContextPath());
        System.out.println("MyInterceptor.postHandle()---viewName:"+modelAndView.getViewName());
        super.postHandle(request,response,handler,modelAndView);

    }

    /**
     * Controller之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,
                             Object handler) throws Exception {
        String url  =request.getRequestURI();
        System.out.println("MyInterceptor.preHandle()"+url);
        return super.preHandle(request,response,handler);
    }
}
