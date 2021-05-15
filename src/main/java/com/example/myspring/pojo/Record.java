package com.example.myspring.pojo;

import lombok.Data;

@Data
public class Record {
  String UserID;
  String EID;
  String Date;
  int Site;
  int Time;
  String EName;
  String Lab;

  public Record() {
  }

  public Record(String userID, String EID, String date, int site, int time, String EName, String Lab) {
	this.UserID = userID;
	this.EID = EID;
	this.Date = date;
	this.Site = site;
	this.Time = time;
	this.EName = EName;
	this.Lab = Lab;
  }
}
