package com.example.myspring.service;

import com.example.myspring.Utils.UserIDGenerator;
import com.example.myspring.dto.UserInfo;
import com.example.myspring.mapper.UserMapper;
import com.example.myspring.pojo.ResponseData;
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
  public ResponseData register(String userID, String userName, String password, String phoneNumber) throws Exception {
    try {
      // 重名
      if (userMapper.info(userID) != null)
        return ResponseData.Success("学号已被使用", null, 1);

      // 联系方式被使用
      if (userMapper.telephoneIsExist(phoneNumber) != null)
        return ResponseData.Success("当前联系方式已被使用", null, 2);

      User user = new User(userID, userName, password, phoneNumber);
      userMapper.addUser(user);

      return ResponseData.Success("注册成功", user, 0);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }

  /**
   *
   * @param phoneNumber
   * @param password
   * @return
   * @throws Exception
   */
  public ResponseData login(String phoneNumber, String password) throws Exception{
    try {
      String userID = userMapper.login(phoneNumber, password);
      if (userID.length() == 0)
        return ResponseData.Success("不存在该账号或密码错误", null, 1);
      else {
        UserInfo userInfo = userMapper.infoByPhoneNumber(phoneNumber);
        return ResponseData.Success("登录成功", userInfo, 0);
      }
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }

  /**
   *
   * @param userID
   * @return
   * @throws Exception
   */
  public ResponseData info(String userID) throws Exception {
    try {
      UserInfo userInfo = userMapper.info(userID);
      if (userInfo != null) return ResponseData.Success("获取用户信息成功", userInfo, 0);
      else return ResponseData.Success("未获取到用户信息", null, 1);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
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
  public ResponseData changeTelephone(String oldPhone, String newPhone) throws Exception {
    try {
      if (telephoneIsExist(oldPhone).getData() == null) return ResponseData.Success("不存在该联系方式", null, 1);
      else if (userMapper.changeTelephone(oldPhone, newPhone) == 1) {
        UserInfo userInfo = userMapper.infoByPhoneNumber(newPhone);
        return ResponseData.Success("联系方式修改成功", userInfo, 0);
      } else return ResponseData.Success("联系方式未修改成功", null, 2);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }

  /**
   *
   * @param phoneNumber
   * @return
   * @throws Exception
   */
  public ResponseData telephoneIsExist(String phoneNumber) throws Exception {
    try {
      UserInfo userInfo = userMapper.telephoneIsExist(phoneNumber);
      if (userInfo != null) return ResponseData.Success("联系方式已存在", userInfo, 0);
      else return ResponseData.Success("联系方式不存在", null, 1);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }
}
