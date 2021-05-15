package com.example.myspring.controller;

import com.example.myspring.pojo.ResponseData;
import com.example.myspring.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RecordController {
  @Autowired
  private RecordService recordService;

  @RequestMapping("/addRecord")
  public ResponseData addRecord(@RequestParam("UserID") String UserID,
								@RequestParam("EID") String EID,
								@RequestParam("Date") String Date,
								@RequestParam("Site") int Site,
								@RequestParam("Time") int Time,
								@RequestParam("EName") String EName,
								@RequestParam("Lab") String Lab) {
	try {
	  return recordService.addRecord(UserID, EID, Date, Site, Time, EName, Lab);
	} catch (Exception e) {
	  e.printStackTrace();
	  return ResponseData.Error("错误", null, -1);
	}
  }

  @RequestMapping("/deleteRecord")
  public ResponseData deleteRecord(@RequestParam("UserID") String UserID,
								   @RequestParam("EID") String EID,
								   @RequestParam("Date") String Date,
								   @RequestParam("Site") int Site,
								   @RequestParam("Time") int Time) {
    try {
      return recordService.deleteRecord(UserID, EID, Date, Site, Time);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }

  @RequestMapping("/getAllRecordsByEID")
  public ResponseData getAllRecordsByEID(@RequestParam("EID") String EID) {
    try {
      return recordService.getAllRecordsByEID(EID);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }

  @RequestMapping("/getAllSiteSelected")
  public ResponseData getAllSiteSelected(@RequestParam("EID") String EID,
                                         @RequestParam("Date") String Date,
                                         @RequestParam("Time") int Time) {
    try {
      return recordService.getAllSiteSelected(EID, Date, Time);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }

  @RequestMapping("/getAllRecordsByStudentID")
  public ResponseData getAllRecordsByStudentID(@RequestParam("UserID") String UserID) {
    try {
      return recordService.getAllRecordsByStudentID(UserID);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }
}
