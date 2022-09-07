package com.ibk.epmo.common.controller;

import com.ibk.epmo.step.StepInfoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EduController {

    private Logger logger = LoggerFactory.getLogger(StepInfoController.class);
    @RequestMapping(value = "/edu", method = RequestMethod.GET)
    //public ModelAndView singleArticle(ModelAndView mav) {
    public ModelAndView edu(ModelAndView mav, HttpServletRequest request) {
        //Integer id = Integer.parseInt(request.getParameter("id"));

        logger.info("교육 화면");

        mav.setViewName("edu");
        return mav;
    }
}
