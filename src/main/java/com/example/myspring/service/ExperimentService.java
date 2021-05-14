package com.example.myspring.service;

import com.example.myspring.dto.ExperimentInfo;
import com.example.myspring.mapper.ExperimentMapper;
import com.example.myspring.pojo.Experiment;
import com.example.myspring.pojo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExperimentService {
  @Autowired
  private ExperimentMapper experimentMapper;

  /**
   * @param Eid
   * @param ELabel
   * @param Lab
   * @param EName
   * @param TimeMorning
   * @param TimeNoon
   * @param TimeEvening
   * @param SiteSize
   * @return
   * @throws Exception
   */
  public ResponseData addExperiment(String Eid, int ELabel, String Lab, String EName, int TimeMorning, int TimeNoon, int TimeEvening, int SiteSize) {
	// 判断EID是否重复
	if (experimentMapper.getInfoByEID(Eid) != null)
	  return ResponseData.Success("当前实验ID已被使用", null, 1);

	// 新增实验
	Experiment experiment = new Experiment(Eid, Lab, EName, ELabel, TimeMorning, TimeNoon, TimeEvening, SiteSize);

	if (experimentMapper.addExperiment(experiment) == 1)
	  return ResponseData.Success("新增实验成功", null, 0);

	// 错误
	return ResponseData.Error("错误", null, -1);
  }

  /**
   *
   * @param Eid
   * @return
   */
  public ResponseData getInfoByEID(String Eid) {
	ExperimentInfo experimentInfo = experimentMapper.getInfoByEID(Eid);
	return ResponseData.Success("返回Eid对应的实验信息", experimentInfo, 0);
  }

  /**
   *
   * @param Eid
   * @return
   */
  public ResponseData deleteExperiment(String Eid) {
    // 查找是否有相关实验
	ExperimentInfo experimentInfo = experimentMapper.getInfoByEID(Eid);
	if (experimentInfo == null)
	  return ResponseData.Success("不存在当前实验", null, 2);

    if (experimentMapper.deleteExperiment(Eid) == 1)
      return ResponseData.Success("删除成功", null, 0);
    return ResponseData.Success("删除失败", null, 1);
  }

  /**
   *
   * @param label
   * @return
   */
  public ResponseData getExperimentsByLabel(int label) {
	ArrayList<ExperimentInfo> experimentInfos = experimentMapper.getByLabel(label);

	if (experimentInfos.size() == 0)
	  return ResponseData.Success("列表为0", null, 1);
	return ResponseData.Success("获取成功", experimentInfos, 0);
  }

  /**
   *
   * @return
   */
  public ResponseData getAllExperiments() {
    ArrayList<ExperimentInfo> experimentInfos = experimentMapper.getAllExperiments();

    if (experimentInfos.size() == 0)
	  return ResponseData.Success("列表为0", null, 1);
	return ResponseData.Success("获取成功", experimentInfos, 0);
  }
}
