package com.example.customprotocol.utils;

/**
 * @Author cxr
 * @Date 2020/12/22 21:30
 */
public class Holder<T> {

    private volatile T value;

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}
