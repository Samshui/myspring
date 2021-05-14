package com.example.myspring.controller;

import com.example.myspring.pojo.ResponseData;
import com.example.myspring.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ExperimentController {
  @Autowired
  private ExperimentService experimentService;

  @RequestMapping("/addExperiment")
  public ResponseData addExperiment(@RequestParam("Eid") String Eid,
                                    @RequestParam("ELabel") int ELabel,
                                    @RequestParam("Lab") String Lab,
                                    @RequestParam("EName") String EName,
                                    @RequestParam("TimeMorning") int TimeMorning,
                                    @RequestParam("TimeNoon") int TimeNoon,
                                    @RequestParam("TimeEvening") int TimeEvening,
                                    @RequestParam("SiteSize") int SiteSize) {
    try {
      return experimentService.addExperiment(Eid, ELabel, Lab, EName, TimeMorning, TimeNoon, TimeEvening, SiteSize);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }

  @RequestMapping("/getInfoByEID")
  public ResponseData getInfoByEID(@RequestParam("Eid") String Eid) {
    try {
      return experimentService.getInfoByEID(Eid);
    } catch (Exception e) {

      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }

  @RequestMapping("/deleteExperiment")
  public ResponseData deleteExperiment(@RequestParam("Eid") String Eid) {
    try {
      return experimentService.deleteExperiment(Eid);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }

  @RequestMapping("/getExperimentsByLabel")
  public ResponseData getExperimentsByLabel(@RequestParam("ELabel") int ELabel) {
    try {
      return experimentService.getExperimentsByLabel(ELabel);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }

  @RequestMapping("getAllExperiments")
  public ResponseData getAllExperiments() {
    try {
      return experimentService.getAllExperiments();
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseData.Error("错误", null, -1);
    }
  }
}

