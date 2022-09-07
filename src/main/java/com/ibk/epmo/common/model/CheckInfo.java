package com.ibk.epmo.common.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//가이드 타입
@Getter
@Setter
@Document(indexName = "check_info")
public class CheckInfo {

    @Id
    @Field(type = FieldType.Long)
	private Integer checkId;		//번호
    private String checker;             //체크한 사람: epmo,

    @Field(type = FieldType.Keyword)
    private String checkName;

    @Field(type = FieldType.Keyword)
    private String checkContents;
    private Integer relatedProjectId;

    @Field(type = FieldType.Date)
    private String updatedDate;
    private String register;        //등록한 사람
    private String relatedPersons;  //관련자

    private String status; //상태

    public CheckInfo(Integer checkId, String checker, String checkName, String checkContents, Integer relatedProjectId, String updatedDate, String register, String relatedPersons,String status) {
        this.checkId = checkId;
        this.checker = checker;
        this.checkName = checkName;
        this.checkContents = checkContents;
        this.relatedProjectId = relatedProjectId;
        this.updatedDate = updatedDate;
        this.register = register;
        this.relatedPersons = relatedPersons;
        this.status = status;
    }
}
