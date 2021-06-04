package com.mo.persist.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse<T> {
    private boolean ok = false;
    private int code = -1;
    private T data;
    private String msg;

    public static<T> CommonResponse<T> createSuccess(T data){
        CommonResponse<T> response = new CommonResponse<>();
        response.setOk(true);
        response.setCode(0);
        response.setData(data);
        return response;
    }

    public static<T> CommonResponse<T> createError(String msg){
        CommonResponse response = new CommonResponse<>();
        response.setMsg(msg);
        return response;
    }
}
