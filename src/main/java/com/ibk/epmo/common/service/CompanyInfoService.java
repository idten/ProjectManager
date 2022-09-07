package com.ibk.epmo.common.service;

import com.google.common.collect.Lists;
import com.ibk.epmo.common.model.CompanyInfo;
import com.ibk.epmo.common.repository.CompanyInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyInfoService {
	
	@Autowired
	CompanyInfoRepository companyInfoRepository;

	private Logger logger = LoggerFactory.getLogger(CompanyInfoService.class);

//	public ProjectInfo getProjectInfoByproposer(String proposer){
//		ProjectInfo projectInfo = projectInfoRepository.findProjectInfoByProposer(proposer);
//		return projectInfo;
//	}

	public List<CompanyInfo> getCompanyInfoList(){
		List<CompanyInfo>  companyInfoList = Lists.newArrayList(companyInfoRepository.findAll());
		return companyInfoList;
	}

}
