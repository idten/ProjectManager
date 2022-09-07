package com.ibk.epmo.common.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "simproject_info")
public class SimProjectInfo {

    @Id
    @Field(type = FieldType.Long)
    private Integer simprojectId;
    private Integer orgprojectId;

    private Integer projectId;		//번호

    @Field(type = FieldType.Keyword)
    private String projectName;

    @Field(type = FieldType.Keyword)
    private String items;
    //예산
    private Long budget;

    //유사도  파이썬 분석
    private String similarity;

    public SimProjectInfo(Integer simprojectId, Integer orgprojectId, Integer projectId, String projectName, String items, Long budget, String similarity) {
        this.simprojectId = simprojectId;
        this.orgprojectId = orgprojectId;
        this.projectId = projectId;
        this.projectName = projectName;
        this.items = items;
        this.budget = budget;
        this.similarity = similarity;
    }
}
