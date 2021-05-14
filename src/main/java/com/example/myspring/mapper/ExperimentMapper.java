package com.example.myspring.mapper;

import com.example.myspring.dto.ExperimentInfo;
import com.example.myspring.pojo.Experiment;
import org.apache.ibatis.annotations.Mapper;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Mapper
public interface ExperimentMapper {
  // 新增实验
  int addExperiment(Experiment experiment);

  // 根据Eid查找相关实验
  ExperimentInfo getInfoByEID(String Eid);

  // 删除实验
  int deleteExperiment(String Eid);

  // 获取栏目实验
  ArrayList<ExperimentInfo> getByLabel(int label);

  // 获取所有实验
  ArrayList<ExperimentInfo> getAllExperiments();
}
