package com.ghx.springboot.springbootsecurity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ghx.springboot.springbootsecurity.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository extends BaseMapper<User> {
}
