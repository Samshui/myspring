package com.example.myspring.mapper;

import com.example.myspring.dto.UserInfo;
import com.example.myspring.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  // 添加用户
  int addUser(User user);

  // 查询重名情况
  String checkUserName(String userName);

  // 用户登录 - 返回UserID
  String login(String phoneNumber, String password);

  // 用户信息
  UserInfo info(String userID);

  // 修改联系方式
  int changeTelephone(String userID, String oldPhone, String newPhone);

  // 查看联系方式是否已被使用
  UserInfo telephoneIsExist(String phoneNumber);
}
