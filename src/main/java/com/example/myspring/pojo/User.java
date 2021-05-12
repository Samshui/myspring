package com.example.myspring.pojo;

import lombok.Data;

@Data
public class User {
  String UserID;
  String UserName;
  int age;
  String phoneNumber;
  String emailAddress;
  String password;

  public User() {
  }

  public User(String userID, String userName, String password, String phoneNumber) {
    UserID = userID;
    UserName = userName;
    this.age = 0;
    this.phoneNumber = phoneNumber;
    this.emailAddress = "";
    this.password = password;
  }
}
