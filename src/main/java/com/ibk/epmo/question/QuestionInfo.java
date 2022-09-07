package com.ibk.epmo.question;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//가이드 타입
@Getter
@Setter
@Document(indexName = "question_info")
public class QuestionInfo {

    @Id
    @Field(type = FieldType.Long)
	private Integer questionId;		//번호
	private String step;			//단계

    @Field(type = FieldType.Keyword)
    private String title;

    @Field(type = FieldType.Keyword)
	private String questionContents; 	//가이드 내용
	private String questionType; 		//가이드 타입

    //추천 숫자
	private Integer recommendCount;


    private String conditions;

    private String recommender;


    private String register;
    private String respondent;
    private String updatedDate;

    private String status ;


    public QuestionInfo(Integer questionId, String step, String title,
                        String questionContents, String questionType,
                        Integer recommendCount, String conditions,
                        String recommender, String register,String respondent,
                        String updatedDate,String status
    ) {
        this.questionId = questionId;
        this.step = step;
        this.title = title;
        this.questionContents = questionContents;
        this.questionType = questionType;
        this.recommendCount = recommendCount;
        this.conditions = conditions;
        this.recommender = recommender;
        this.register = register;
        this.respondent = respondent;
        this.updatedDate = updatedDate;
        this.status = status;
    }

}
