package com.example.springbootcommunity.mapper;

import com.example.springbootcommunity.entity.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{tag})")
    public void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param("offset") Integer offset,@Param("size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator=#{i} limit #{offset},#{size}")
    List<Question> list2(@Param("i") Integer i, @Param("offset") Integer offset,@Param("size") Integer size);

    @Select("select * from question where id=#{id} ")
    Question getbyId(@Param("id") Integer id);

    @Update("update question set view_count=#{view_count} where id=#{id}")
    void update(@Param("view_count") Integer view_count,@Param("id") Integer id);
}
