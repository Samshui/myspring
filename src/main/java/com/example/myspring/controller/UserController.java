package com.example.myspring.controller;

import com.example.myspring.dto.UserInfo;
import com.example.myspring.pojo.ResponseData;
import com.example.myspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping("/register")
  public ResponseData register(@RequestParam("UserID") String userID,
							   @RequestParam("UserName") String userName,
							   @RequestParam("Password") String password,
							   @RequestParam("PhoneNumber") String phoneNumber) {
    try {
      return userService.register(userID, userName, password, phoneNumber);
	} catch (Exception e) {
      e.printStackTrace();
	  return ResponseData.Error("错误", null, -1);
	}
  }

  @RequestMapping("/login")
  public ResponseData login(@RequestParam("PhoneNumber") String phoneNumber,
					  @RequestParam("Password") String password) {
    try {
      return userService.login(phoneNumber, password);
	} catch (Exception e) {
      e.printStackTrace();
	  return ResponseData.Error("错误", null, -1);
	}
  }

  @RequestMapping("/info")
  public ResponseData info(@RequestParam("UserID") String userID) {
    try {
      return userService.info(userID);
	} catch (Exception e) {
      e.printStackTrace();
	  return ResponseData.Error("错误", null, -1);
	}
  }

  @RequestMapping("/changeTelephone")
  public ResponseData changeTelephone(@RequestParam("oldPhone") String oldPhone,
							 @RequestParam("newPhone") String newPhone) {
    try {
      return userService.changeTelephone(oldPhone, newPhone);
	} catch (Exception e) {
	  e.printStackTrace();
	  return ResponseData.Error("错误", null, -1);
	}
  }

  @RequestMapping("/telephoneIsExist")
  public ResponseData telephone(@RequestParam("phoneNumber") String phoneNumber) {
    try {
      return userService.telephoneIsExist(phoneNumber);
	} catch (Exception e) {
      e.printStackTrace();
	  return ResponseData.Error("错误", null, -1);
	}
  }
}
