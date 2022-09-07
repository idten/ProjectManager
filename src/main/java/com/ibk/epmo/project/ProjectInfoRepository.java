package com.ibk.epmo.project;

import com.ibk.epmo.project.ProjectInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectInfoRepository extends ElasticsearchRepository<ProjectInfo,String> {
	//	public StepInfo fin(String );
	public ProjectInfo findProjectInfoByProposer(String Proposer);
	public ProjectInfo findProjectInfoByProjectId(Integer projectId);

}
