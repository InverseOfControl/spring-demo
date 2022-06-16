package com.ghx.springboot.springbootsecurity.entity;

import lombok.Data;

@Data
public class Permission {
    private long id;
    private String name;
    private String url;
    private String pid;
    private String description;
}
