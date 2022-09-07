package com.ibk.epmo.common.repository;

import com.ibk.epmo.common.model.CompanyInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyInfoRepository extends ElasticsearchRepository<CompanyInfo,String> {
	//	public StepInfo fin(String );
	public List<CompanyInfo> findCompanyInfoByRelatedProjectId(Integer relatedProjectId);

}
