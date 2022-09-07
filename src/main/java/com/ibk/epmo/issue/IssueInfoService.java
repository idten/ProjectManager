package com.ibk.epmo.issue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueInfoService {

	@Autowired
	IssueInfoRepository issueInfoRepository;

	private Logger logger = LoggerFactory.getLogger(IssueInfoService.class);

	public List<IssueInfo> getCheckInfoByRelatedProjectId(Integer relatedProjectId){
		List<IssueInfo> issueInfoList = issueInfoRepository.findIssueInfoByRelatedProjectId(relatedProjectId);
		return issueInfoList;
	}
}
