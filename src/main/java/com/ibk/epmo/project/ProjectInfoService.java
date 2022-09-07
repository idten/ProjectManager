package com.ibk.epmo.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectInfoService {
	
	@Autowired
	ProjectInfoRepository projectInfoRepository;

	private Logger logger = LoggerFactory.getLogger(ProjectInfoService.class);

	public ProjectInfo getProjectInfoByproposer(String proposer){
		ProjectInfo projectInfo = projectInfoRepository.findProjectInfoByProposer(proposer);
		return projectInfo;
	}

	public ProjectInfo getProjectInfoByProjectId(Integer projectId){
		ProjectInfo projectInfo = projectInfoRepository.findProjectInfoByProjectId(projectId);
		return projectInfo;
	}
}
