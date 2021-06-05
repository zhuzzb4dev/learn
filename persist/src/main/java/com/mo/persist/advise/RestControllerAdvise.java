package com.mo.persist.advise;

import com.mo.persist.exception.BizException;
import com.mo.persist.model.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdvise {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse handleMethodException(Exception exception){
        BindingResult bindingResult = ((MethodArgumentNotValidException) exception).getBindingResult();
        String defaultMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
        return CommonResponse.createError(defaultMessage);
    }

    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse handleBizException(Exception exception){
        return CommonResponse.createError(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse handleException(Exception exception){
        exception.printStackTrace();
        return CommonResponse.createError(exception.getMessage());
    }
}
