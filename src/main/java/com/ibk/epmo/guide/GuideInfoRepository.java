package com.ibk.epmo.guide;

import com.ibk.epmo.guide.GuideInfo;
import com.ibk.epmo.question.QuestionInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideInfoRepository extends ElasticsearchRepository<GuideInfo,String> {
	//	public StepInfo fin(String );
	public List<GuideInfo> findByStep(String step);
	public List<GuideInfo> findByGuideType(String guideType);

	//findTop10By
	public GuideInfo findStepInfoByGuideId(Integer id);
	public List<GuideInfo> findTop5ByOrderByRecommendCountDesc();

	public List<GuideInfo> findAll();



}
