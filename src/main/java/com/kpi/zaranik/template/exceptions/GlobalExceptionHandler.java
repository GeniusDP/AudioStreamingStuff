package com.kpi.zaranik.template.exceptions;

import org.apache.catalina.connector.ClientAbortException;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FileSizeLimitExceededException.class)
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    public String fileSizeLimitExceededException(FileSizeLimitExceededException e){
        return e.getMessage();
    }

    @ExceptionHandler({IOException.class, ClientAbortException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String ioException(IOException e){
        return e.getMessage();
    }


}
