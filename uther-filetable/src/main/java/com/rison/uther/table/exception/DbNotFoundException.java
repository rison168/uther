package com.rison.uther.table.exception;

/**
 * @PACKAGE_NAME: com.rison.uther.table.exception
 * @NAME: DbNotFoundException
 * @USER: Rison
 * @DATE: 2022/11/2 9:44
 * @PROJECT_NAME: uther
 **/
public class DbNotFoundException extends DDLException{
    public DbNotFoundException (){}

    public DbNotFoundException(String s){
        super(s);
    }
}
