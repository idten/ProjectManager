package com.ibk.epmo.common.repository;

import com.ibk.epmo.common.model.CheckInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckInfoRepository extends ElasticsearchRepository<CheckInfo,String> {
	//	public StepInfo fin(String );
	//public CheckInfo findCheckInfoByRelatedProjectId(Integer );
	public List<CheckInfo> findCheckInfoByRelatedProjectId(Integer relatedProjectId);

}
