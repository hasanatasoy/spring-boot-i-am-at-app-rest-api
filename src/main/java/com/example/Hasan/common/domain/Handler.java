package com.example.Hasan.common.domain;

/**
 * Created by Hasan on 20.10.2018.
 */
public interface Handler<T, R> {

    R execute(T request);

}
