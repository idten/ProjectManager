package com.ibk.epmo.functionpoint;

import com.ibk.epmo.functionpoint.FunctionPointInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FunctionPointInfoRepository extends ElasticsearchRepository<FunctionPointInfo,String> {
	//	public StepInfo fin(String );
	public List<FunctionPointInfo> findByProjectId(Integer projectId);
	//findTop10By
	//public StepInfo findStepInfoByGuideId(Integer id);


}
