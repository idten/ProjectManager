package com.ibk.epmo.common.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "company_info")
public class CompanyInfo {

    @Id
    @Field(type = FieldType.Long)
    private Integer companyId;		//번호
    @Field(type = FieldType.Keyword)
    private String companyName;
    private String companyType;  //중소 중견,대기업 등

    private String owner;//대표

    private String birthDate;// 설립일

    private String businessType;// 업종 ex>시스템 소프트웨어 개발 및 공급업

    private String sales;//매출
    private String memberCount;//

    private Integer relatedProjectId;

    public CompanyInfo(Integer companyId, String companyName, String companyType, String owner, String birthDate, String businessType, String sales, String memberCount,Integer relatedProjectId) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyType = companyType;
        this.owner = owner;
        this.birthDate = birthDate;
        this.businessType = businessType;
        this.sales = sales;
        this.memberCount = memberCount;
        this.relatedProjectId = relatedProjectId;
    }
}
