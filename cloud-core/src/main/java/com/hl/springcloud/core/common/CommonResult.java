package com.hl.springcloud.core.common;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zy
 * @Date: 2020/11/12 22:33
 */
@Data
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }


    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
