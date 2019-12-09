package com.demo.demosurl.demosurl.util.response;

import lombok.Data;

/**
 * @author yuanyiwen
 * @create 2019-12-07 19:11
 * @description
 */
@Data
public class ResponseVo<T> {

    private Integer code;

    private String msg;

    private T data;
}
