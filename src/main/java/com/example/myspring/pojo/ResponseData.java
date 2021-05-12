package com.example.myspring.pojo;

import lombok.Data;

/**
 * 统一即定相应返回格式：ResponseData
 * code：返回码（200|403|404|500）
 * statue：状态码（常用：成功-0，异常-1、2、3...）
 * message：返回信息/值
 * data：返回信息（对象）
 */
@Data
public class ResponseData {
  int code;
  int status;
  String message;
  Object data;

  public ResponseData() {
  }

  public ResponseData(int code, int status, String message, Object data) {
	this.code = code;
	this.status = status;
	this.message = message;
	this.data = data;
  }

  public static ResponseData Success(String message, Object data, int statue) {
    return new ResponseData(200, statue, message, data);
  }

  public static ResponseData Error(String message, Object data, int statue) {
    return new ResponseData(403, statue, message, data);
  }

  public int getCode() {
	return code;
  }

  public void setCode(int code) {
	this.code = code;
  }

  public int getStatus() {
	return status;
  }

  public void setStatus(int status) {
	this.status = status;
  }

  public String getMessage() {
	return message;
  }

  public void setMessage(String message) {
	this.message = message;
  }

  public Object getData() {
	return data;
  }

  public void setData(Object data) {
	this.data = data;
  }
}
