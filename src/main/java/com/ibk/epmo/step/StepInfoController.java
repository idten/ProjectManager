package com.ibk.epmo.step;

import com.ibk.epmo.common.model.*;
import com.ibk.epmo.common.service.*;
import com.ibk.epmo.functionpoint.FunctionPointInfoService;
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

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StepInfoController {
	@Autowired
	StepInfoService stepInfoService;

	@Autowired
	QuestionInfoService questionInfoService;

	@Autowired
	ProjectInfoService projectInfoService;

	@Autowired
	IssueInfoService issueInfoService;

	@Autowired
	CheckInfoService checkInfoService;

	@Autowired
	FunctionPointInfoService functionPointInfoService;

	private Logger logger = LoggerFactory.getLogger(StepInfoController.class);

	public void readStepInfo(){

	}
		//main 화면 호출시 요약 목록 표시
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView start(ModelAndView mav, HttpServletRequest request)  {
		logger.info("main 화면");


		List<StepInfo> stepInfoList = stepInfoService.getStepInfoList();

		List<StepInfo> stepA000 = new ArrayList<StepInfo>();
		List<StepInfo> stepA001 = new ArrayList<StepInfo>();
		List<StepInfo> stepA002 = new ArrayList<StepInfo>();
		List<StepInfo> stepA003 = new ArrayList<StepInfo>();
		List<StepInfo> stepA004 = new ArrayList<StepInfo>();
		List<StepInfo> stepA005 = new ArrayList<StepInfo>();
		List<StepInfo> stepA006 = new ArrayList<StepInfo>();
		List<StepInfo> stepA007 = new ArrayList<StepInfo>();
		List<StepInfo> stepA008 = new ArrayList<StepInfo>();
		List<StepInfo> stepA009 = new ArrayList<StepInfo>();
		List<StepInfo> stepA010 = new ArrayList<StepInfo>();
		List<StepInfo> stepA011 = new ArrayList<StepInfo>();
		List<StepInfo> stepA012 = new ArrayList<StepInfo>();


		StepInfo stepInfo = null;
		int len = stepInfoList.size();
		readStepInfo();
		logger.info("size:" + len);
		for (int i = 0; i < len; i++) {
			stepInfo = stepInfoList.get(i);

			logger.info(stepInfo.getStep() + ":" + stepInfo.toString());
			stepInfo = stepInfoList.get(i);

			if (stepInfo.getStep().equals("A000")) {
				stepA000.add(stepInfo);
			} else if (stepInfo.getStep().equals("A001")) {
				stepA001.add(stepInfo);
			} else if (stepInfo.getStep().equals("A002")) {
				stepA002.add(stepInfo);
			} else if (stepInfo.getStep().equals("A003")) {
				stepA003.add(stepInfo);
			} else if (stepInfo.getStep().equals("A004")) {
				stepA004.add(stepInfo);
			} else if (stepInfo.getStep().equals("A005")) {
				stepA005.add(stepInfo);
			} else if (stepInfo.getStep().equals("A006")) {
				stepA006.add(stepInfo);
			} else if (stepInfo.getStep().equals("A007")) {
				stepA007.add(stepInfo);
			} else if (stepInfo.getStep().equals("A008")) {
				stepA008.add(stepInfo);
			} else if (stepInfo.getStep().equals("A009")) {
				stepA009.add(stepInfo);
			} else if (stepInfo.getStep().equals("A010")) {
				stepA010.add(stepInfo);
			} else if (stepInfo.getStep().equals("A011")) {
				stepA011.add(stepInfo);
			} else if (stepInfo.getStep().equals("A012")) {
				stepA012.add(stepInfo);
			}
		}
		logger.info("StepInfo");


		QuestionInfo questionInfo = null;
		List<QuestionInfo> questionInfoList = questionInfoService.getQuestionInfoList();
		List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();

		List<CheckInfo> checkInfoList = checkInfoService.getCheckInfoByRelatedProjectId(1);
		List<IssueInfo> issueInfoList = issueInfoService.getCheckInfoByRelatedProjectId(1);

		String temp = request.getParameter("id");

		ProjectInfo projectInfo;
		if(temp==null) {
			projectInfo = projectInfoService.getProjectInfoByproposer("우한승");
		}else{
			Integer id = Integer.parseInt(request.getParameter("id"));

			projectInfo = projectInfoService.getProjectInfoByProjectId(id);
		}
		int qLen = questionInfoList.size();
		logger.info("Question size:" + qLen);
		logger.info("Question size:" + projectInfo.getProjectName());

		mav.addObject("checkInfoList",checkInfoList);
		mav.addObject("issueInfoList",issueInfoList);

		mav.addObject("projectInfo",projectInfo);
		//stepA000.getT
		mav.addObject("questionInfoList", questionInfoList);
		mav.addObject("faqInfoList", faqInfoList);

		mav.addObject("stepInfoList", stepInfoList);

		mav.addObject("stepA001", stepA001);
		mav.addObject("stepA002", stepA002);
		mav.addObject("stepA003", stepA003);
		mav.addObject("stepA004", stepA004);
		mav.addObject("stepA005", stepA005);
		mav.addObject("stepA006", stepA006);
		mav.addObject("stepA007", stepA007);
		mav.addObject("stepA008", stepA008);
		mav.addObject("stepA009", stepA009);
		mav.addObject("stepA010", stepA010);
		mav.addObject("stepA011", stepA011);
		mav.addObject("stepA012", stepA012);

		logger.info("STEP001개수:" + stepA001.size());
		mav.setViewName("index");
		logger.info("StepInfo Test End");
		return mav;
	}

	//main 화면 호출시 요약 목록 표시
	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public ModelAndView articles(ModelAndView mav) {
		logger.info("article 화면");
		mav.setViewName("articles");
		return mav;
	}

	//main 화면 호출시 요약 목록 표시
	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public ModelAndView faq(ModelAndView mav) {
		logger.info("faq 화면");
		List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();
		mav.addObject("faqInfoList", faqInfoList);
		mav.setViewName("faq");
		return mav;
	}
	//main 화면 호출시 요약 목록 표시
	@RequestMapping(value = "/knowledge-base", method = RequestMethod.GET)
	public ModelAndView knowledge(ModelAndView mav) {

		List<StepInfo> stepInfoList = stepInfoService.getStepInfoList();
		logger.info("Knowledge-base 화면");
		List<StepInfo> stepA000 = new ArrayList<StepInfo>();
		List<StepInfo> stepA001 = new ArrayList<StepInfo>();
		List<StepInfo> stepA002 = new ArrayList<StepInfo>();
		List<StepInfo> stepA003 = new ArrayList<StepInfo>();
		List<StepInfo> stepA004 = new ArrayList<StepInfo>();
		List<StepInfo> stepA005 = new ArrayList<StepInfo>();
		List<StepInfo> stepA006 = new ArrayList<StepInfo>();
		List<StepInfo> stepA007 = new ArrayList<StepInfo>();
		List<StepInfo> stepA008 = new ArrayList<StepInfo>();
		List<StepInfo> stepA009 = new ArrayList<StepInfo>();
		List<StepInfo> stepA010 = new ArrayList<StepInfo>();
		List<StepInfo> stepA011 = new ArrayList<StepInfo>();
		List<StepInfo> stepA012 = new ArrayList<StepInfo>();


		StepInfo stepInfo = null;
		int len = stepInfoList.size();
		readStepInfo();
		logger.info("size:" + len);
		for (int i = 0; i < len; i++) {
			stepInfo = stepInfoList.get(i);

			logger.info(stepInfo.getStep() + ":" + stepInfo.toString());
			stepInfo = stepInfoList.get(i);

			if (stepInfo.getStep().equals("A000")) {
				stepA000.add(stepInfo);
			} else if (stepInfo.getStep().equals("A001")) {
				stepA001.add(stepInfo);
			} else if (stepInfo.getStep().equals("A002")) {
				stepA002.add(stepInfo);
			} else if (stepInfo.getStep().equals("A003")) {
				stepA003.add(stepInfo);
			} else if (stepInfo.getStep().equals("A004")) {
				stepA004.add(stepInfo);
			} else if (stepInfo.getStep().equals("A005")) {
				stepA005.add(stepInfo);
			} else if (stepInfo.getStep().equals("A006")) {
				stepA006.add(stepInfo);
			} else if (stepInfo.getStep().equals("A007")) {
				stepA007.add(stepInfo);
			} else if (stepInfo.getStep().equals("A008")) {
				stepA008.add(stepInfo);
			} else if (stepInfo.getStep().equals("A009")) {
				stepA009.add(stepInfo);
			} else if (stepInfo.getStep().equals("A010")) {
				stepA010.add(stepInfo);
			} else if (stepInfo.getStep().equals("A011")) {
				stepA011.add(stepInfo);
			} else if (stepInfo.getStep().equals("A012")) {
				stepA012.add(stepInfo);
			}
		}
		logger.info("StepInfo");


		mav.addObject("stepInfoList", stepInfoList);

		mav.addObject("stepA001", stepA001);
		mav.addObject("stepA002", stepA002);
		mav.addObject("stepA003", stepA003);
		mav.addObject("stepA004", stepA004);
		mav.addObject("stepA005", stepA005);
		mav.addObject("stepA006", stepA006);
		mav.addObject("stepA007", stepA007);
		mav.addObject("stepA008", stepA008);
		mav.addObject("stepA009", stepA009);
		mav.addObject("stepA010", stepA010);
		mav.addObject("stepA011", stepA011);
		mav.addObject("stepA012", stepA012);

		List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();
		mav.addObject("faqInfoList", faqInfoList);


		mav.setViewName("knowledge-base");
		return mav;
	}
	//main 화면 호출시 요약 목록 표시
	@RequestMapping(value = "/wizard", method = RequestMethod.GET)
	public ModelAndView wizard(ModelAndView mav) {
		logger.info("wizard 화면");
		//mav.setViewName("html/index");
		mav.setViewName("wizard");
		return mav;
	}
	@RequestMapping(value = "/single-article", method = RequestMethod.GET)
	//public ModelAndView singleArticle(ModelAndView mav) {
	public ModelAndView singleArticle(ModelAndView mav, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));

		logger.info("single Articles 화면[id="+id+"]");
		StepInfo stepInfo = stepInfoService.getStepInfoById(id);
		mav.addObject("stepInfo", stepInfo);

		mav.setViewName("single-article");
		return mav;
	}


	@RequestMapping(value = "/index01", method = RequestMethod.GET)
	//public ModelAndView singleArticle(ModelAndView mav) {
	public ModelAndView test001(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("index01");
		return mav;
	}


}

