package com.rison.uther.table.exception;

/**
 * @PACKAGE_NAME: com.rison.uther.table.exception
 * @NAME: DDLException
 * @USER: Rison
 * @DATE: 2022/11/2 9:41
 * @PROJECT_NAME: uther
 **/
public class DDLException extends RuntimeException {

    public DDLException(){}

    public DDLException(String message){
        super(message);
    }

    public DDLException(String message, Throwable t){
        super(message, t);
    }

    public DDLException(Throwable t){
        super(t);
    }
}
