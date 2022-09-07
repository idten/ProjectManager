package com.ibk.epmo.functionpoint;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "fp_info")
public class FunctionPointInfo {
    @Id
    Integer functionPointId;

    String projectName;
    Integer projectId;

    @Field(type = FieldType.Keyword)
    String fpName;
    String fpType; //EI, EO
    String depth1;
    String depth2;
//    String depth3;
    String etc;//비고


    String updatedDate;

    public FunctionPointInfo(Integer functionPointId, String projectName, Integer projectId, String fpName, String fpType, String depth1, String depth2, String etc,String updatedDate) {
        this.functionPointId = functionPointId;
        this.projectName = projectName;
        this.projectId = projectId;
        this.fpName = fpName;
        this.fpType = fpType;
        this.depth1 = depth1;
        this.depth2 = depth2;
        this.etc = etc;
        this.updatedDate = updatedDate;
    }
}
