package com.ibk.epmo.guide;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//가이드 타입
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "guide_info")
public class GuideInfo {

    @Id
    @Field(type = FieldType.Long)
	private Integer guideId;		//번호
	private String step;			//단계

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
	private String guideContents; 	//가이드 내용
    private String relatedProject;

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


}
