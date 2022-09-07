package com.ibk.epmo.common.search;

import com.ibk.epmo.common.model.CheckInfo;
import com.ibk.epmo.common.search.SearchProjectResult;
import com.ibk.epmo.common.service.CheckInfoService;
import com.ibk.epmo.guide.GuideInfo;
import com.ibk.epmo.guide.GuideInfoService;
import com.ibk.epmo.issue.IssueInfo;
import com.ibk.epmo.issue.IssueInfoService;
import com.ibk.epmo.project.ProjectInfoService;
import com.ibk.epmo.question.QuestionInfoService;
import com.ibk.epmo.common.search.SearchService;
import com.ibk.epmo.project.ProjectInfo;
import com.ibk.epmo.question.QuestionInfo;
import com.ibk.epmo.step.StepInfo;
import com.ibk.epmo.step.StepInfoController;
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
public class SearchController {
    private Logger logger = LoggerFactory.getLogger(StepInfoController.class);

    @Autowired QuestionInfoService questionInfoService;
    @Autowired ProjectInfoService projectInfoService;

    @Autowired
    IssueInfoService issueInfoService;

    @Autowired
    CheckInfoService checkInfoService;


    @Autowired
    GuideInfoService guideInfoService;

    @Autowired
    SearchService searchService;

    //main 화면 호출시 요약 목록 표시
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(ModelAndView mav, HttpServletRequest request) {
        logger.info("검색 수행");
        String keyword = request.getParameter("keyword");
        SearchService searchService = new SearchService();
        List<SearchProjectResult> searchProjectResultList = searchService.searchProject(keyword);
        mav.addObject(searchProjectResultList);
        mav.setViewName("search-results");

        return "redirect:/search-results";

    }
    @RequestMapping(value = "/search-results", method = RequestMethod.GET)
    public ModelAndView searchResult(ModelAndView mav, HttpServletRequest request) {
        logger.info("검색 수행");
        String keyword = request.getParameter("keyword");


        List<SearchProjectResult> searchProjectResultList = searchService.searchProject(keyword);

        List<SearchGuideResult> searchGuideResultList = searchService.searchGuide(keyword);

        mav.addObject("searchProjectResultList",searchProjectResultList);
        mav.addObject("searchGuideResultList",searchGuideResultList);

        List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();

        mav.addObject("faqInfoList", faqInfoList);

        mav.setViewName("search-results");

        return mav;

    }
   // http://localhost:8080/search-results?keyword=%EA%B0%90%EC%82%AC
   // http://localhost:8080/result-projectDetail?id=1
                              // result-projectDetail?id=1
  //  @RequestMapping(value = "/single-article", method = RequestMethod.GET)
    @RequestMapping(value = "/result-projectDetail", method = RequestMethod.GET)
    public ModelAndView searchProjectResult(ModelAndView mav,  HttpServletRequest request) {
        logger.info("검색 수행 결과(프로젝트)");
        //Integer id = request.getParameter("id");
        Integer id = Integer.parseInt(request.getParameter("id"));
        //Float score = Float.parseFloat(request.getParameter("score"));

        ProjectInfo projectInfo = projectInfoService.getProjectInfoByProjectId(id);
        logger.info("출력:"+projectInfo.getBackgroundContents());
        //List<SearchProjectResult> searchProjectResultList = searchService.search(keyword);
        mav.addObject("projectInfo",projectInfo);
 //       mav.addObject("score",score);

        List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();
        mav.addObject("faqInfoList", faqInfoList);
        mav.addObject("newLineChar",'\n');
        mav.setViewName("result-projectDetail");
        logger.info("처리 끝:"+projectInfo.getProjectName());
        return mav;

    }

    @RequestMapping(value = "/search2", method = RequestMethod.POST)
    public String search2(ModelAndView mav, HttpServletRequest request) {
        logger.info("검색 수행");
        String keyword = request.getParameter("keyword");
        SearchService searchService = new SearchService();
        List<SearchProjectResult> searchProjectResultList = searchService.searchProject(keyword);
        mav.addObject(searchProjectResultList);
        mav.setViewName("html/search");

        return "redirect:/search-results2";

    }
    @RequestMapping(value = "/search-results2", method = RequestMethod.GET)
    public ModelAndView searchResult2(ModelAndView mav, HttpServletRequest request) {
        logger.info("검색 수행2");
        String keyword = request.getParameter("keyword");


        List<SearchProjectResult> searchProjectResultList = searchService.searchProject(keyword);

        List<SearchGuideResult> searchGuideResultList = searchService.searchGuide(keyword);

        mav.addObject("searchProjectResultList",searchProjectResultList);
        mav.addObject("searchGuideResultList",searchGuideResultList);

        List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();

        mav.addObject("faqInfoList", faqInfoList);

        mav.setViewName("html/search-results2");

        return mav;

    }

    @RequestMapping(value = "/result-projectDetail2", method = RequestMethod.GET)
    public ModelAndView searchProjectResult2(ModelAndView mav,  HttpServletRequest request) {
        logger.info("검색 수행 결과(프로젝트)");
        //Integer id = request.getParameter("id");
        Integer id = Integer.parseInt(request.getParameter("id"));
        //Float score = Float.parseFloat(request.getParameter("score"));

        ProjectInfo projectInfo = projectInfoService.getProjectInfoByProjectId(id);
        logger.info("출력:"+projectInfo.getBackgroundContents());
        //List<SearchProjectResult> searchProjectResultList = searchService.search(keyword);
        mav.addObject("projectInfo",projectInfo);
        //       mav.addObject("score",score);

        List<CheckInfo> checkInfoList = checkInfoService.getCheckInfoByRelatedProjectId(id);

        List<IssueInfo> issueInfoList = issueInfoService.getCheckInfoByRelatedProjectId(id);


        List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();
        mav.addObject("faqInfoList", faqInfoList);
        mav.addObject("newLineChar",'\n');
        mav.setViewName("html/result-projectDetail2");


        logger.info("처리 끝:"+projectInfo.getProjectName());
        return mav;

    }

    @RequestMapping(value = "/search-product", method = RequestMethod.GET)
    public ModelAndView searchProduct(ModelAndView mav, HttpServletRequest request) {
        logger.info("검색 수행 Product");
        String keyword = request.getParameter("keyword");
        if(keyword==null){
            keyword = "스토리지";
        }

        List<SearchProjectResult> searchProjectResultList = searchService.searchProject(keyword);

        List<SearchGuideResult> searchGuideResultList = searchService.searchGuide(keyword);

        mav.addObject("searchProjectResultList",searchProjectResultList);
        mav.addObject("searchGuideResultList",searchGuideResultList);

        List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();

        mav.addObject("faqInfoList", faqInfoList);

        mav.setViewName("html/search-product");

        return mav;

    }
    //사전협의/타당성검토 - 합의/발주및계약/수행/일반항목/법령,내규

    @RequestMapping(value = "/search-guide", method = RequestMethod.GET)
    public ModelAndView searchGuide(ModelAndView mav, HttpServletRequest request) {
        logger.info("검색 수행 Guide");
        String keyword = request.getParameter("keyword");

        List<GuideInfo> guideInfoAllList = guideInfoService.getGuideInfoList();

        List<GuideInfo> guideInfoAllS001 = new ArrayList<GuideInfo>();
        List<GuideInfo> guideInfoAllS002 = new ArrayList<GuideInfo>();
        List<GuideInfo> guideInfoAllS003 = new ArrayList<GuideInfo>();
        List<GuideInfo> guideInfoAllS004 = new ArrayList<GuideInfo>();
        List<GuideInfo> guideInfoAllS005 = new ArrayList<GuideInfo>();
        List<GuideInfo> guideInfoAllS006 = new ArrayList<GuideInfo>();

        List<GuideInfo> guideInfoAllT001 = new ArrayList<GuideInfo>();
        List<GuideInfo> guideInfoAllT002 = new ArrayList<GuideInfo>();

        List<SearchGuideResult> guideInfoS001 = new ArrayList<SearchGuideResult>();
        List<SearchGuideResult> guideInfoS002 = new ArrayList<SearchGuideResult>();
        List<SearchGuideResult> guideInfoS003 = new ArrayList<SearchGuideResult>();
        List<SearchGuideResult> guideInfoS004 = new ArrayList<SearchGuideResult>();
        List<SearchGuideResult> guideInfoS005 = new ArrayList<SearchGuideResult>();
        List<SearchGuideResult> guideInfoS006 = new ArrayList<SearchGuideResult>();

        List<SearchGuideResult> guideInfoT001 = new ArrayList<SearchGuideResult>();
        List<SearchGuideResult> guideInfoT002 = new ArrayList<SearchGuideResult>();

        GuideInfo guideInfo = null;
        for(int i=0;i<guideInfoAllList.size();i++){
            guideInfo = guideInfoAllList.get(i);
//
            logger.info(guideInfo.getStep() + ":" + guideInfo.getTitle());
//            //stepInfo = stepInfoList.get(i);
//
            if (guideInfo.getStep().equals("S001")) {
                guideInfoAllS001.add(guideInfo);
            }else if (guideInfo.getStep().equals("S002")) {
                guideInfoAllS002.add(guideInfo);
            }else if (guideInfo.getStep().equals("S003")) {
                guideInfoAllS003.add(guideInfo);
            }else if (guideInfo.getStep().equals("S004")) {
                guideInfoAllS004.add(guideInfo);
            }else if (guideInfo.getStep().equals("S005")) {
                guideInfoAllS005.add(guideInfo);
            }else if (guideInfo.getStep().equals("S006")) {
                guideInfoAllS006.add(guideInfo);
            }

            if (guideInfo.getGuideType().equals("T001")) {
                guideInfoAllT001.add(guideInfo);
            }else if (guideInfo.getGuideType().equals("T002")) {
                guideInfoAllT002.add(guideInfo);
            }

        }


        List<SearchProjectResult> searchProjectResultList = searchService.searchProject(keyword);
        if(keyword==null){
            keyword = "스토리지";
        }
        List<SearchGuideResult> searchGuideResultList = searchService.searchGuide(keyword);
        SearchGuideResult searchGuideResult = null;

        for(int i=0;i<searchGuideResultList.size();i++){
            searchGuideResult = searchGuideResultList.get(i);

            logger.info(":" + searchGuideResult.getTitle());

            if (searchGuideResult.getStep().equals("S001")) {
                guideInfoS001.add(searchGuideResult);
            }else if (searchGuideResult.getStep().equals("S002")) {
                guideInfoS002.add(searchGuideResult);
            }else if (searchGuideResult.getStep().equals("S003")) {
                guideInfoS003.add(searchGuideResult);
            }else if (searchGuideResult.getStep().equals("S004")) {
                guideInfoS004.add(searchGuideResult);
            }else if (searchGuideResult.getStep().equals("S005")) {
                guideInfoS005.add(searchGuideResult);
            }else if (searchGuideResult.getStep().equals("S006")) {
                guideInfoS006.add(searchGuideResult);
            }

            if (searchGuideResult.getGuideType().equals("T001")) {
                guideInfoT001.add(searchGuideResult);
            }else if (searchGuideResult.getGuideType().equals("T002")) {
                guideInfoT002.add(searchGuideResult);
            }
        }
        mav.addObject("searchProjectResultList",searchProjectResultList);
        mav.addObject("searchGuideResultList",searchGuideResultList);

        List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();

        mav.addObject("faqInfoList", faqInfoList);
        mav.addObject("guideInfoAllS001", guideInfoAllS001);
        mav.addObject("guideInfoAllS002", guideInfoAllS002);
        mav.addObject("guideInfoAllS003", guideInfoAllS003);
        mav.addObject("guideInfoAllS004", guideInfoAllS004);
        mav.addObject("guideInfoAllS005", guideInfoAllS005);
        mav.addObject("guideInfoAllS006", guideInfoAllS006);
        mav.addObject("guideInfoAllT001", guideInfoAllT001);
        mav.addObject("guideInfoAllT002", guideInfoAllT002);

        mav.addObject("guideInfoS001", guideInfoS001);
        mav.addObject("guideInfoS002", guideInfoS002);
        mav.addObject("guideInfoS003", guideInfoS003);
        mav.addObject("guideInfoS004", guideInfoS004);
        mav.addObject("guideInfoS005", guideInfoS005);
        mav.addObject("guideInfoS006", guideInfoS006);
        mav.addObject("guideInfoT001", guideInfoT001);
        mav.addObject("guideInfoT002", guideInfoT002);


        mav.setViewName("html/search-guide");

        return mav;

    }

    @RequestMapping(value = "/search-question", method = RequestMethod.GET)
    public ModelAndView searchQuestion(ModelAndView mav, HttpServletRequest request) {
        logger.info("검색 수행 Question");
        String keyword = request.getParameter("keyword");


        List<SearchProjectResult> searchProjectResultList = searchService.searchProject(keyword);

        List<SearchGuideResult> searchGuideResultList = searchService.searchGuide(keyword);

        mav.addObject("searchProjectResultList",searchProjectResultList);
        mav.addObject("searchGuideResultList",searchGuideResultList);

        List<QuestionInfo> faqInfoList = questionInfoService.getFAQList();

        mav.addObject("faqInfoList", faqInfoList);

        mav.setViewName("html/search-question");

        return mav;

    }

}
