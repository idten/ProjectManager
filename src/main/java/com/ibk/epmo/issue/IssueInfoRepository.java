package com.ibk.epmo.issue;

import com.ibk.epmo.issue.IssueInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueInfoRepository extends ElasticsearchRepository<IssueInfo,String> {
	//	public StepInfo fin(String );
	//public IssueInfo findIssueInfoByProposer(String Proposer);
	public List<IssueInfo> findIssueInfoByRelatedProjectId(Integer relatedProjectId);

}
