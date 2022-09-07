package com.ibk.epmo.functionpoint;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionPointInfoService {
	
	@Autowired
	FunctionPointInfoRepository functionPointInfoRepository;

	private Logger logger = LoggerFactory.getLogger(FunctionPointInfoService.class);
	
	public List<FunctionPointInfo> getFunctionPointInfoList(){
		List<FunctionPointInfo>  functionPointInfoList = Lists.newArrayList(functionPointInfoRepository.findAll());
		return functionPointInfoList;
	}
	public  List<FunctionPointInfo>  getFunctionPointInfoByProjectId(Integer projectId){

		List<FunctionPointInfo> functionPointInfoList = functionPointInfoRepository.findByProjectId(projectId);
		return functionPointInfoList;
	}

	//public List<StepInfo> getStepInfoAll(){
	//	int page = 0 , pageSize= 1000;
	//	Pageable of = PageRequest.of(page,pageSize);
	//	//List<StepInfo> stepInfoList = stepInfoRepository.findAll(of);

	//}
}
