package com.ghx.springboot.springbootvalidation.web;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull(message = "用户名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    private String age;


}
