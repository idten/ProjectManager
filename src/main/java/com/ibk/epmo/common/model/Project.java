package com.ibk.epmo.common.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "project")
public class Project {


    private Integer id;
    private String title;
    // 개발, 물품
    private String projectType;
    //담당 epmo
    private String epmo;
    //담당자
    private String manager;

    private String keywords;

    private String fullDescription;
}
