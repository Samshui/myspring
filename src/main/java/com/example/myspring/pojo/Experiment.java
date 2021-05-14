package com.example.myspring.pojo;

import lombok.Data;

@Data
public class Experiment {
  String Eid;
  String Lab;
  String EName;
  int ELabel;
  int TimeMorning;
  int TimeNoon;
  int TimeEvening;
  int SiteSize;

  public Experiment() {
  }

  public Experiment(String EID, String lab, String EName, int ELabel, int timeMorning, int timeNoon, int timeEvening, int SiteSize) {
	this.Eid = EID;
	this.Lab = lab;
	this.EName = EName;
	this.ELabel = ELabel;
	this.TimeMorning = timeMorning;
	this.TimeNoon = timeNoon;
	this.TimeEvening = timeEvening;
	this.SiteSize = SiteSize;
  }
}
