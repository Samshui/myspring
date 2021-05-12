package com.example.myspring.dto;

import lombok.Data;

@Data
public class UserInfo {
  String UserID;
  String UserName;
  int age;
  String phoneNumber;
  String emailAddress;
  String password;
}
