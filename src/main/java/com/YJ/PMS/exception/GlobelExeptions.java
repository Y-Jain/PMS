package com.YJ.PMS.exception;

import java.time.LocalDateTime;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobelExeptions {


    @ExceptionHandler(ExecutionControl.UserException.class)
    public ResponseEntity<ErrorDetais> userEceptionHandler(ExecutionControl.UserException ue,
                                                           WebRequest req){
        ErrorDetais error=new ErrorDetais(ue.getMessage(),req.getDescription(false),LocalDateTime.now());
        return new ResponseEntity<ErrorDetais>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetais> otherEceptionHandler(Exception ue,
                                                            WebRequest req){
        ErrorDetais error=new ErrorDetais(ue.getMessage(),req.getDescription(false),LocalDateTime.now());
        return new ResponseEntity<ErrorDetais>(error,HttpStatus.BAD_REQUEST);
    }

}
