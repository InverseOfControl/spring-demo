package com.example.springbootproxy.mybatis.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;

    public String query() {
        return demoDao.query();
    }

}
