package com.ibk.epmo.common.test;

import com.ibk.epmo.common.model.CheckInfo;
import com.ibk.epmo.common.service.CheckInfoService;
import com.ibk.epmo.functionpoint.FunctionPointInfoService;
import com.ibk.epmo.issue.IssueInfo;
import com.ibk.epmo.issue.IssueInfoService;
import com.ibk.epmo.project.ProjectInfo;
import com.ibk.epmo.project.ProjectInfoService;
import com.ibk.epmo.question.QuestionInfo;
import com.ibk.epmo.question.QuestionInfoService;
import com.ibk.epmo.step.StepInfo;
import com.ibk.epmo.step.StepInfoController;
import com.ibk.epmo.step.StepInfoService;
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
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);
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

    @RequestMapping(value = "/projectRegister", method = RequestMethod.GET)
    public ModelAndView projectRegister(ModelAndView mav, HttpServletRequest request)  {
        mav.setViewName("html/projectRegister");

        logger.info("ProjectRegister  End");
        return mav;
    }

    @RequestMapping(value = "/guide2", method = RequestMethod.GET)
    public ModelAndView guide2(ModelAndView mav, HttpServletRequest request)  {
        mav.setViewName("html/guide");
        logger.info("Guide  End");
        return mav;
    }

    @RequestMapping(value = "/question2", method = RequestMethod.GET)
    public ModelAndView question2(ModelAndView mav, HttpServletRequest request)  {
        mav.setViewName("html/question");
        logger.info("Question  End");
        return mav;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView product2(ModelAndView mav, HttpServletRequest request)  {
        mav.setViewName("html/product");
        logger.info("제품별  End");
        return mav;
    }

    

    @RequestMapping(value = "/productRegister", method = RequestMethod.GET)
    public ModelAndView productRegister(ModelAndView mav, HttpServletRequest request)  {
        mav.setViewName("html/productRegister");
        logger.info("ProjectRegister  End");
        return mav;
    }


    //main 화면 호출시 요약 목록 표시
    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public ModelAndView index2(ModelAndView mav, HttpServletRequest request)  {
        logger.info("index2 화면");

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
        //readStepInfo();
        logger.info("size:" + len);
        for (int i = 0; i < len; i++) {
            stepInfo = stepInfoList.get(i);

            logger.info(stepInfo.getStep() + ":" + stepInfo.toString());
            //stepInfo = stepInfoList.get(i);

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
        mav.setViewName("html/index");
        logger.info("StepInfo Test End");
        return mav;
    }
}