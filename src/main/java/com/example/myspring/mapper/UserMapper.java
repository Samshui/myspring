package com.example.myspring.mapper;

import com.example.myspring.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  // 添加用户
  int addUser(User user);

  // 查询重名情况
  String checkUserName(String userName);
}
