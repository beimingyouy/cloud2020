package com.hl.springcloud.common;

import lombok.AllArgsConstructor;
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
    private Object data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }


    public CommonResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
