package com.ibk.epmo.step;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//가이드 타입
@Getter
@Setter
@Document(indexName = "step_info")
public class StepInfo {

    @Id
    @Field(type = FieldType.Long)
	private Integer guideId;		//번호
	private String step;			//단계

    @Field(type = FieldType.Keyword)
    private String title;

    @Field(type = FieldType.Text)
	private String guideContents; 	//가이드 내용
	private String guideType; 		//가이드 타입

    //추천 숫자
	private Integer recommendCount;
    private String conditions;

    private String recommender;

    private String publisher;
    //승인 여부
    private boolean approval;

    @Field(type = FieldType.Date)
    private String updatedDate;

    public StepInfo(){

    }

    public StepInfo(Integer guideId, String step, String title, String guideContents, String guideType, Integer recommendCount, String conditions, String recommender, String publisher, boolean approval,String updatedDate) {
        this.guideId = guideId;
        this.step = step;
        this.title = title;
        this.guideContents = guideContents;
        this.guideType = guideType;
        this.recommendCount = recommendCount;
        this.conditions = conditions;
        this.recommender = recommender;
        this.publisher = publisher;
        this.approval = approval;
        this.updatedDate = updatedDate;
    }

}
