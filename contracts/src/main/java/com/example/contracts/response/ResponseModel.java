package com.example.contracts.response;


public class ResponseModel<T> {

    private T obj;

    public ResponseModel(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
