package com.hl.springcloud.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: zy
 * @Date: 2020/12/4 16:57
 */
@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String userName;
}
