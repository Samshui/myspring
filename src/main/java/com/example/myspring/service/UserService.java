package com.example.myspring.service;

import com.example.myspring.Utils.UserIDGenerator;
import com.example.myspring.mapper.UserMapper;
import com.example.myspring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserMapper userMapper;

  public int register(String userName, String password) throws Exception {
    // 重名返回1
    if (userMapper.checkUserName(userName) != null) return 1;

    String userID = UserIDGenerator.generateUserID();
    User user = new User(userID, userName, password);

    userMapper.addUser(user);
    return 0;
  }
}
