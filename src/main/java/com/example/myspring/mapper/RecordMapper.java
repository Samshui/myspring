package com.example.myspring.mapper;

import com.example.myspring.dto.RecordInfo;
import org.apache.ibatis.annotations.Mapper;
import com.example.myspring.pojo.Record;

import java.util.ArrayList;

@Mapper
public interface RecordMapper {
  // 新增预约
  int addRecord(Record record);

  // 删除预约
  int deleteRecord(String UserID, String EID, String Date, int Site, int Time);

  // 获取当前实验的所有预约
  ArrayList<RecordInfo> getAllRecordsByEID(String EID);

  // 获取实验的所有预约位置
  ArrayList<Integer> getAllSiteSelected(String EID, String Date, int Time);

  // 获取用户的所有预约
  ArrayList<RecordInfo> getAllRecordsByStudentID(String UserID);
}
