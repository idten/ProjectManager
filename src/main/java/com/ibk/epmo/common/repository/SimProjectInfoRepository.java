package com.ibk.epmo.common.repository;

import com.ibk.epmo.common.model.SimProjectInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimProjectInfoRepository extends ElasticsearchRepository<SimProjectInfo,String> {
	//	public StepInfo fin(String );
	public List<SimProjectInfo> findProjectInfoByProjectId(Integer projectId);
	public List<SimProjectInfo> findProjectInfoByOrgprojectId(Integer OrgprojectId);

}
