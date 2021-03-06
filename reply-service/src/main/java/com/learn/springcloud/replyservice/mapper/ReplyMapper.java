package com.learn.springcloud.replyservice.mapper;

import com.learn.springcloud.replyservice.pojo.Reply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplyMapper {
    @Insert("insert into reply (rid,content,postId,userId,time) values (#{rid}, #{content}, #{postId}, #{userId}, #{time})")
    void add(Reply reply);

    @Select("select * from reply where rid = #{rid}")
    Reply get(int rid);

    @Delete("delete from reply where rid= #{rid}")
    void delete(int rid);

    @Select("select * from reply where postId = #{postId} order by time asc")
    List<Reply> findReplies(int postId);

    @Select("select COUNT(*) from reply where postId = #{postId}")
    int getReplyCount(int postId);
}