package com.dream.springbootframe.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReturnData<T> {

    private int status = 200;
    private String message;
    private T data;
    private String error;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public ReturnData() {
    }

    public static ReturnData<Void> ok() {
        ReturnData<Void> r = new ReturnData<>();
        r.setStatus(200);
        return r;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static <T> ReturnData<T> of(T data) {
        ReturnData<T> r = new ReturnData<T>();
        r.setData( data );
        return r;
    }
}
