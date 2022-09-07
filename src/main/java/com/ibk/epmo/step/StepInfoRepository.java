package com.ibk.epmo.step;

import com.ibk.epmo.step.StepInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface StepInfoRepository extends ElasticsearchRepository<StepInfo,String> {
	//	public StepInfo fin(String );
	public List<StepInfo> findByStep(String step);
	//findTop10By
	public StepInfo findStepInfoByGuideId(Integer id);


}
