package com.ibk.epmo.functionpoint;

import com.ibk.epmo.functionpoint.FunctionPointInfo;
import com.ibk.epmo.functionpoint.FunctionPointInfoService;
import com.ibk.epmo.issue.IssueInfoService;
import com.ibk.epmo.project.ProjectInfo;
import com.ibk.epmo.question.QuestionInfo;
import com.ibk.epmo.common.service.*;
import com.ibk.epmo.project.ProjectInfoService;
import com.ibk.epmo.question.QuestionInfoService;
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
import java.util.List;

@Controller
public class FunctionPointController {
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

    @RequestMapping(value = "/functionPoint", method = RequestMethod.GET)
    //public ModelAndView singleArticle(ModelAndView mav) {
    public ModelAndView functionPoint(ModelAndView mav, HttpServletRequest request) {
        //Integer id = Integer.parseInt(request.getParameter("id"));
        //functionPointInfoRepository.
        List<FunctionPointInfo> functionPointInfoList = functionPointInfoService.getFunctionPointInfoList();
        ProjectInfo projectInfo = projectInfoService.getProjectInfoByproposer("김용주");


        logger.info("기능점수 화면");
        //StepInfo stepInfo = stepInfoService.getStepInfoById(id);
        //mav.addObject("stepInfo", stepInfo);

        mav.addObject("functionPointInfoList",functionPointInfoList);
        mav.addObject("projectInfo",projectInfo);
        List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();

        //stepA000.getT
        mav.addObject("faqInfoList", faqInfoList);

        mav.setViewName("functionPoint");
        return mav;
    }


}
