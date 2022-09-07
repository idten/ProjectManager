package com.ibk.epmo.common.service;

import com.ibk.epmo.common.model.SimProjectInfo;
import com.ibk.epmo.common.repository.SimProjectInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimProjectInfoService {
	
	@Autowired
	SimProjectInfoRepository simProjectInfoRepository;
	private Logger logger = LoggerFactory.getLogger(SimProjectInfoService.class);

	//프로젝트명 기준에서 유사한 프로젝트 목록 표시
	public List<SimProjectInfo> getProjectInfoByProjectId(Integer projectId){
		List<SimProjectInfo> simProjectInfoList = simProjectInfoRepository.findProjectInfoByProjectId(projectId);
		//.findProjectInfoByProjectId(projectId);
		return simProjectInfoList;
	}
	public List<SimProjectInfo> getProjectInfoByOrgProjectId(Integer orgProjectId){
		List<SimProjectInfo> simProjectInfoList = simProjectInfoRepository.findProjectInfoByOrgprojectId(orgProjectId);
		//.findProjectInfoByProjectId(projectId);
		return simProjectInfoList;
	}


}
