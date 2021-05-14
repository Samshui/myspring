package com.example.myspring.dto;

import lombok.Data;

@Data
public class ExperimentInfo {
  String EID;
  String Lab;
  String EName;
  int ELabel;
  int TimeMorning;
  int TimeNoon;
  int TimeEvening;
  int SiteSize;
}
