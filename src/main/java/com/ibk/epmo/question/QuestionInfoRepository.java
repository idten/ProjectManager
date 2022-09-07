package com.ibk.epmo.question;

import com.ibk.epmo.question.QuestionInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionInfoRepository extends ElasticsearchRepository<QuestionInfo,String> {
	//	public StepInfo fin(String );
	public List<QuestionInfo> findByStep(String step);
	public List<QuestionInfo> findTop5ByOrderByRecommendCountDesc();

}
