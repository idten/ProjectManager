package com.ibk.epmo.common.service;

import com.google.common.collect.Lists;
import com.ibk.epmo.common.model.CompanyInfo;
import com.ibk.epmo.common.model.CompanyNewsInfo;
import com.ibk.epmo.common.repository.CompanyInfoRepository;
import com.ibk.epmo.common.repository.CompanyNewsInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyNewsInfoService {
	
	@Autowired
	CompanyNewsInfoRepository companyNewsInfoRepository;

	private Logger logger = LoggerFactory.getLogger(CompanyNewsInfoService.class);

//	public ProjectInfo getProjectInfoByproposer(String proposer){
//		ProjectInfo projectInfo = projectInfoRepository.findProjectInfoByProposer(proposer);
//		return projectInfo;
//	}

	public List<CompanyNewsInfo> getCompanyNewsInfoList(Integer companyId){
		List<CompanyNewsInfo>  companyNewsInfoList = companyNewsInfoRepository.findCompanyInfoByCompanyId(companyId);
		return companyNewsInfoList;
	}
	public List<CompanyNewsInfo> getCompanyNewsInfoList(){
		List<CompanyNewsInfo>  companyNewsInfoList = Lists.newArrayList(companyNewsInfoRepository.findAll());
		return companyNewsInfoList;
	}

}
