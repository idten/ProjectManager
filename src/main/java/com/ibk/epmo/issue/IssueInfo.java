package com.ibk.epmo.issue;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//가이드 타입
@Getter
@Setter
@Document(indexName = "issue_info")
public class IssueInfo {

    @Id
    @Field(type = FieldType.Long)
	private Integer issueId;		//번호
    private Integer relatedProjectId;
    @Field(type = FieldType.Keyword)
    private String issueName;
    @Field(type = FieldType.Keyword)
    private String issueContents;

    private String register;        //등록한 사람
    private String relatedPersons;  //관련자
    private String type; //회의, 등등
    @Field(type = FieldType.Date)
    private String updatedDate;

    private String status ;//진행사항

    public IssueInfo(Integer issueId, Integer relatedProjectId, String issueName, String issueContents, String register, String relatedPersons, String type, String updatedDate,String status) {
        this.issueId = issueId;
        this.relatedProjectId = relatedProjectId;
        this.issueName = issueName;
        this.issueContents = issueContents;
        this.register = register;
        this.relatedPersons = relatedPersons;
        this.type = type;
        this.updatedDate = updatedDate;
        this.status = status;
    }

}
