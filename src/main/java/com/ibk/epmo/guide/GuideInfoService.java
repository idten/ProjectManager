package com.ibk.epmo.guide;

import com.ibk.epmo.project.ProjectInfoRepository;
import com.ibk.epmo.project.ProjectInfoService;
import com.ibk.epmo.question.QuestionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideInfoService {
    @Autowired
    GuideInfoRepository guideInfoRepository;

    private Logger logger = LoggerFactory.getLogger(GuideInfoService.class);


    public List<GuideInfo> getGuideInfoList(){
    //    List<GuideInfo> guideInfoList = guideInfoRepository.findTop5ByOrderByRecommendCountDesc();//.findAll();
        List<GuideInfo> guideInfoList = guideInfoRepository.findAll();//.findAll();
        return guideInfoList;
    }

    public List<GuideInfo> getGuideInfoListByStep(String step){
        List<GuideInfo> guideInfoList = guideInfoRepository.findByStep(step);
        return guideInfoList;
    }
    public List<GuideInfo> getGuideInfoListByGuideType(String guideType){
        List<GuideInfo> guideInfoList = guideInfoRepository.findByGuideType(guideType);//.findByStep(step);
        return guideInfoList;
    }





}
