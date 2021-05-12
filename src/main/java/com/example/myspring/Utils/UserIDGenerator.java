package com.example.myspring.Utils;

import java.util.UUID;

public class UserIDGenerator {
  public static String generateUserID() {
	return UUID.randomUUID().toString()
			.replace("-","")
			.substring(0,8).toUpperCase();
  }
}
