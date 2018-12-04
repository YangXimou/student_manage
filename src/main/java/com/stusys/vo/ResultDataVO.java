package com.stusys.vo;

/**
 * Created by Simon on 2018/12/3.
 */
public class ResultDataVO<T> extends ResultVO {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
