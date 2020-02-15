package com.example.springbootcommunity.mapper;

import com.example.springbootcommunity.dto.CommentDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    @Insert("insert into comment(parent_id,type,commentat})")
    void insert(CommentDTO commentDTO);
}
