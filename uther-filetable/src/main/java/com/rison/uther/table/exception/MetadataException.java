package com.rison.uther.table.exception;

/**
 * @PACKAGE_NAME: com.rison.uther.table.exception
 * @NAME: MetadataException
 * @USER: Rison
 * @DATE: 2022/11/2 9:52
 * @PROJECT_NAME: uther
 **/
public class MetadataException extends Exception{
    public MetadataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MetadataException(String message, Throwable cause) {
        super(message, cause);
    }

    public MetadataException(String message) {
        super(message);
    }

    public MetadataException(Throwable cause) {
        super(cause);
    }
}
