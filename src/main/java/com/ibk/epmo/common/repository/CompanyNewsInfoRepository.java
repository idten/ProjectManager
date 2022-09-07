package com.ibk.epmo.common.repository;

import com.ibk.epmo.common.model.CompanyInfo;
import com.ibk.epmo.common.model.CompanyNewsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyNewsInfoRepository extends ElasticsearchRepository<CompanyNewsInfo,String> {
	//	public StepInfo fin(String );
	public List<CompanyNewsInfo> findCompanyInfoByCompanyId(Integer companyId);

}
