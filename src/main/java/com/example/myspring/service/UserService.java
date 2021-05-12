package com.example.myspring.service;

import com.example.myspring.Utils.UserIDGenerator;
import com.example.myspring.dto.UserInfo;
import com.example.myspring.mapper.UserMapper;
import com.example.myspring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserMapper userMapper;

  /**
   *
   * @param userName
   * @param password
   * @return
   * @throws Exception
   */
  public int register(String userName, String password) throws Exception {
    try {
      // 重名返回 2
      if (userMapper.checkUserName(userName) != null) return 2;

      String userID = UserIDGenerator.generateUserID();
      User user = new User(userID, userName, password);

      return userMapper.addUser(user);
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }
  }

  /**
   *
   * @param phoneNumber
   * @param password
   * @return
   * @throws Exception
   */
  public String login(String phoneNumber, String password) throws Exception{
    try {
      return userMapper.login(phoneNumber, password);
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }
  }

  /**
   *
   * @param userID
   * @return
   * @throws Exception
   */
  public UserInfo info(String userID) throws Exception {
    try {
      return userMapper.info(userID);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   *
   * @param userID
   * @param oldPhone
   * @param newPhone
   * @return
   * @throws Exception
   */
  public int changeTelephone(String userID, String oldPhone, String newPhone) throws Exception {
    try {
      return userMapper.changeTelephone(userID, oldPhone, newPhone);
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }
  }

  /**
   *
   * @param phoneNumber
   * @return
   * @throws Exception
   */
  public UserInfo telephoneIsExist(String phoneNumber) throws Exception {
    try {
      return userMapper.telephoneIsExist(phoneNumber);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
