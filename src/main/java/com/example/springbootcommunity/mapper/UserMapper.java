package com.example.springbootcommunity.mapper;

import com.example.springbootcommunity.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,gmt_create,gmt_modified,avatar_url) values (#{name},#{gmt_create},#{gmt_modified},#{avatar_url})")
    public void inset(User user);
    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Integer id);
}
