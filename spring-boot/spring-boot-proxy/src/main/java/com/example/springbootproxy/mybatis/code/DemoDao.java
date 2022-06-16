package com.example.springbootproxy.mybatis.code;


import com.example.springbootproxy.mybatis.CustomizedRequestMapping;

public interface DemoDao {

    @CustomizedRequestMapping(url="http://localhost:8080/query")
    String query();

}
