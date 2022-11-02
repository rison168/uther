package com.rison.uther.table.exception;

/**
 * @PACKAGE_NAME: com.rison.uther.table.exception
 * @NAME: ParseException
 * @USER: Rison
 * @DATE: 2022/11/2 10:08
 * @PROJECT_NAME: uther
 **/
public class ParseException extends RuntimeException{

    public ParseException(){}

    public ParseException(String msg){
        super(msg);
    }
    public ParseException(Throwable e){
        super(e);
    }
    public ParseException(String msg, Throwable e){
        super(msg, e);
    }
}
