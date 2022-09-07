package com.ibk.epmo.common.service;

import com.ibk.epmo.common.model.CheckInfo;
import com.ibk.epmo.common.repository.CheckInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInfoService {
	
	@Autowired
	CheckInfoRepository checkInfoRepository;
			//projectInfoRepository;

	private Logger logger = LoggerFactory.getLogger(CheckInfoService.class);


	public List<CheckInfo> getCheckInfoByRelatedProjectId(Integer relatedProjectId){
		List<CheckInfo> checkInfoList = checkInfoRepository.findCheckInfoByRelatedProjectId(relatedProjectId);
		return checkInfoList;
	}


}
