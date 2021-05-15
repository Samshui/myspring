package com.example.myspring.service;

import com.example.myspring.dto.RecordInfo;
import com.example.myspring.mapper.ExperimentMapper;
import com.example.myspring.mapper.RecordMapper;
import com.example.myspring.pojo.Record;
import com.example.myspring.pojo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class RecordService {
  @Autowired
  private RecordMapper recordMapper;

  /**
   *
   * @param record
   * @return
   */
  public ResponseData addRecord(String UserID, String EID, String Date, int Site, int Time, String EName, String Lab) {
    Record record = new Record(UserID, EID, Date, Site, Time, EName, Lab);
    if (recordMapper.addRecord(record) == 1)
      return ResponseData.Success("新增预约成功", null, 0);
    return ResponseData.Success("新增预约失败", null, 1);
  }

  /**
   *
   * @param UserID
   * @param EID
   * @param Lab
   * @param Date
   * @param Site
   * @param Time
   * @return
   */
  public ResponseData deleteRecord(String UserID, String EID, String Date, int Site, int Time) {
    if (recordMapper.deleteRecord(UserID, EID, Date, Site, Time) == 1)
      return ResponseData.Success("删除预约成功", null, 0);
    return ResponseData.Success("删除预约失败", null, 1);
  }

  /**
   *
   * @param EID
   * @return
   */
  public ResponseData getAllRecordsByEID(String EID) {
    ArrayList<RecordInfo> recordInfos = recordMapper.getAllRecordsByEID(EID);

    if (recordInfos == null)
      return ResponseData.Success("获取预约失败", null, 1);

    if (recordInfos.size() == 0)
      return ResponseData.Success("当前无预约", null, 2);

    return ResponseData.Success("预约获取成功", recordInfos, 0);
  }

  /**
   *
   * @param EID
   * @param Lab
   * @param Date
   * @param Time
   * @return
   */
  public ResponseData getAllSiteSelected(String EID, String Date, int Time) {
    ArrayList<Integer> sites = recordMapper.getAllSiteSelected(EID, Date, Time);

    if (sites == null)
      return ResponseData.Success("获取失败", null, 1);

    if (sites.size() == 0)
      return ResponseData.Success("当前无预约位置", null, 2);

    return ResponseData.Success("预约位置获取成功", sites, 0);
  }

  /**
   *
   * @param UserID
   * @return
   */
  public ResponseData getAllRecordsByStudentID(String UserID) {
    ArrayList<RecordInfo> recordInfos = recordMapper.getAllRecordsByStudentID(UserID);

    if (recordInfos == null)
      return ResponseData.Success("获取预约失败", null, 1);

    if (recordInfos.size() == 0)
      return ResponseData.Success("当前无预约", null, 2);

    return ResponseData.Success("预约获取成功", recordInfos, 0);
  }
}
