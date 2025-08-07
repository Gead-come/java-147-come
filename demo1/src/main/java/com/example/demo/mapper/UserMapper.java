package com.example.demo.mapper;

import com.example.demo.entiyt.User11;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper  // 告诉MyBatis这是一个操作数据库的Mapper
public interface UserMapper {

  //  @Select("select * from user") // 告诉MyBatis这是一个查询语句
  //  @Delete()  // 告诉MyBatis这是一个删除语句

    public List<User11>list();
}
