package com.example.myspring.controller;

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
}
