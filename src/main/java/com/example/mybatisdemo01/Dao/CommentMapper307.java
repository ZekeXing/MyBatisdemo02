package com.example.mybatisdemo01.Dao;

import com.example.mybatisdemo01.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentMapper307 {
    @Select("select * from comment where cid=#{cid}")
    public Comment getCom(int cid);
    @Insert("insert into comment(content,author,aid)"+" values(#{content},#{author},#{aid})")
    public int insertCom(Comment comment);
}
