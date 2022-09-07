package com.ibk.epmo.question;

import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionInfoService {
	
	@Autowired
	QuestionInfoRepository questionInfoRepository;

	private Logger logger = LoggerFactory.getLogger(QuestionInfoService.class);
	
	public List<QuestionInfo> getQuestionInfoList(){
		List<QuestionInfo> questionInfoList = ImmutableList.copyOf(questionInfoRepository.findAll());
		return questionInfoList;
	}
	public List<QuestionInfo> getFAQList(){
		List<QuestionInfo> questionInfoList = questionInfoRepository.findTop5ByOrderByRecommendCountDesc();//.findAll();
		return questionInfoList;
	}


	public void saveQuestionInfo(QuestionInfo questionInfo) {
		logger.info("save QuestionInfo["+questionInfo.toString());
		//stepInfoRepository.save(apiInfo);
	}
	public void addQuestionInfo(QuestionInfo questionInfo) {
		logger.info("add QuestionInfo["+questionInfo.toString());
		//stepInfoRepository.insert(apiInfo);
	}
	public void deleteQuestionInfo(QuestionInfo questionInfo) {
		logger.info("delete QuestionInfo["+questionInfo.toString());
		//stepInfoRepository.deleteByApiId(apiInfo.getApiId());
	}	
}
