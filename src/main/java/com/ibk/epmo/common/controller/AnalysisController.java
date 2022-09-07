package com.ibk.epmo.common.controller;

import com.ibk.epmo.common.model.*;
import com.ibk.epmo.common.service.*;
import com.ibk.epmo.issue.IssueInfo;
import com.ibk.epmo.issue.IssueInfoService;
import com.ibk.epmo.project.ProjectInfo;
import com.ibk.epmo.project.ProjectInfoService;
import com.ibk.epmo.question.QuestionInfo;
import com.ibk.epmo.question.QuestionInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AnalysisController {
	@Autowired
	ProjectInfoService projectInfoService;

	@Autowired
	SimProjectInfoService simProjectInfoService;;


	@Autowired
	QuestionInfoService questionInfoService;
	@Autowired CheckInfoService checkInfoService;

	@Autowired
	IssueInfoService issueInfoService;

	private Logger logger = LoggerFactory.getLogger(AnalysisController.class);

	public void readStepInfo(){

	}
		//main 화면 호출시 요약 목록 표시
	@RequestMapping(value = "/analysis", method = RequestMethod.GET)
	public ModelAndView start(ModelAndView mav) {
		logger.info("analysis 화면");
		ProjectInfo projectInfo = projectInfoService.getProjectInfoByproposer("김용주");
		List<SimProjectInfo> simProjectInfoList = simProjectInfoService.getProjectInfoByOrgProjectId(2);//.getProjectInfoByProjectId(2);
		List<QuestionInfo> questionInfoList = questionInfoService.getQuestionInfoList();
		List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();

		List<CheckInfo> checkInfoList = checkInfoService.getCheckInfoByRelatedProjectId(1);
		List<IssueInfo> issueInfoList = issueInfoService.getCheckInfoByRelatedProjectId(1);
		mav.addObject("checkInfoList",checkInfoList);
		mav.addObject("issueInfoList",issueInfoList);

		mav.addObject("projectInfo",projectInfo);
		//stepA000.getT
		mav.addObject("questionInfoList", questionInfoList);
		mav.addObject("faqInfoList", faqInfoList);


		mav.addObject("projectInfo",projectInfo);
		mav.addObject("simProjectInfoList",simProjectInfoList);

		mav.setViewName("analysis");
		return mav;
	}

}

