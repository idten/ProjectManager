package com.ibk.epmo.common.controller;

import com.ibk.epmo.common.model.*;
import com.ibk.epmo.common.service.*;
import com.ibk.epmo.question.QuestionInfo;
import com.ibk.epmo.question.QuestionInfoService;
import com.ibk.epmo.step.StepInfoController;
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
public class SupportController {

    @Autowired
    CompanyInfoService companyInfoService;

    @Autowired
    CompanyNewsInfoService companyNewsInfoService;

    @Autowired
    QuestionInfoService questionInfoService;

    private Logger logger = LoggerFactory.getLogger(StepInfoController.class);

    @RequestMapping(value = "/support", method = RequestMethod.GET)
    //public ModelAndView singleArticle(ModelAndView mav) {
    public ModelAndView functionPoint(ModelAndView mav, HttpServletRequest request) {

        List<CompanyInfo> companyInfoList = companyInfoService.getCompanyInfoList();
       List<CompanyNewsInfo> companyNewsInfoList = companyNewsInfoService.getCompanyNewsInfoList();
       // List<CompanyNewsInfo> companyNewsInfoList1 = companyNewsInfoService.getCompanyInfoList();
        List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();
        mav.addObject("faqInfoList", faqInfoList);

        mav.addObject("companyInfoList", companyInfoList);
        mav.addObject("companyNewsInfoList",companyNewsInfoList);
        mav.setViewName("support");
        return mav;
    }


}
