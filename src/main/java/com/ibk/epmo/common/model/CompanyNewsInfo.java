package com.ibk.epmo.common.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "companynews_info")
public class CompanyNewsInfo {

    @Id
    @Field(type = FieldType.Long)
    private Integer companyNewsId;

    private Integer companyId;		//번호
    private String companyName;
    @Field(type = FieldType.Keyword)
    private String title;
    private String description;  //중소 중견,대기업 등

    public CompanyNewsInfo(Integer companyNewsId, Integer companyId, String companyName , String title, String description) {
        this.companyNewsId = companyNewsId;
        this.companyId = companyId;
        this.companyName = companyName;
        this.title = title;
        this.description = description;
    }
}
