package com.example.myspring.controller;

import com.example.myspring.dto.UserInfo;
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
  public int register(@RequestParam("UserName") String userName,
					  @RequestParam("Password") String password) {
    try {
      return userService.register(userName, password);
	} catch (Exception e) {
      e.printStackTrace();
      return -1;
	}
  }

  @RequestMapping("/login")
  public String login(@RequestParam("phoneNumber") String phoneNumber,
					  @RequestParam("password") String password) {
    try {
      return userService.login(phoneNumber, password);
	} catch (Exception e) {
      e.printStackTrace();
      return "error";
	}
  }

  @RequestMapping("/info")
  public UserInfo info(@RequestParam("userID") String userID) {
    try {
      return userService.info(userID);
	} catch (Exception e) {
      e.printStackTrace();
      return null;
	}
  }

  @RequestMapping("/changeTelephone")
  public int changeTelephone(@RequestParam("userID") String userID,
							 @RequestParam("oldPhone") String oldPhone,
							 @RequestParam("newPhone") String newPhone) {
    try {
      return userService.changeTelephone(userID, oldPhone, newPhone);
	} catch (Exception e) {
	  e.printStackTrace();
	  return -1;
	}
  }

  @RequestMapping("/telephoneIsExist")
  public UserInfo telephone(@RequestParam("phoneNumber") String phoneNumber) {
    try {
      return userService.telephoneIsExist(phoneNumber);
	} catch (Exception e) {
      e.printStackTrace();
      return null;
	}
  }
}
