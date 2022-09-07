package com.ibk.epmo.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import java.util.List;

@Service
public class StepInfoService {
	
	@Autowired
	StepInfoRepository stepInfoRepository;

	private Logger logger = LoggerFactory.getLogger(StepInfoService.class);
	
	public List<StepInfo> getStepInfoList(){
		List<StepInfo> stepInfoList = Lists.newArrayList(stepInfoRepository.findAll());
		return stepInfoList;
	}
	public StepInfo getStepInfoById(Integer id){
		StepInfo stepInfo = stepInfoRepository.findStepInfoByGuideId(id);
		return stepInfo;
	}

	//public List<StepInfo> getStepInfoAll(){
	//	int page = 0 , pageSize= 1000;
	//	Pageable of = PageRequest.of(page,pageSize);
	//	//List<StepInfo> stepInfoList = stepInfoRepository.findAll(of);

	//}
	public void saveStepInfo(StepInfo stepInfo) {
		logger.info("save StepInfo["+stepInfo.toString());
		//stepInfoRepository.save(apiInfo);
	}
	public void addStepInfo(StepInfo stepInfo) {
		logger.info("add StepInfo["+stepInfo.toString());
		//stepInfoRepository.insert(apiInfo);
	}
	public void deleteStepInfo(StepInfo stepInfo) {
		logger.info("delete StepInfo["+stepInfo.toString());
		//stepInfoRepository.deleteByApiId(apiInfo.getApiId());
	}	
}
