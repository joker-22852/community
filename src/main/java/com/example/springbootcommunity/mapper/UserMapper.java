package com.example.springbootcommunity.mapper;

import com.example.springbootcommunity.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,gmt_create,gmt_modified) values (#{name},#{gmt_create},#{gmt_modified})")
    public void inset(User user);
}
