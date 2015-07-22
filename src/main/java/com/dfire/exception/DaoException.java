package com.dfire.exception;

/**
 * User:huangtao
 * Date:2015-07-20
 * description：
 */
public class DaoException extends Throwable {
    public DaoException(String s, Exception e) {
        super(s,e);
    }
    public DaoException(String s){
        super(s);
    }
}
