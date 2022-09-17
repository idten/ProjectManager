package com.ibk.epmo.project;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "project_info")
public class ProjectInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  @GeneratedValue(generator="generator")
    private Integer projectId;		//번호

    private String projectName;

    private String projectType;

    private String epmo;
    //발의자
    private String proposer;

    private String keywords;

    private String fullDescription;

    // 실제 품의문 배경
    private String backgroundContents;
    
    // 현황
    private String currentSituation;
    
    //실제 품의문 내용
    private String contents;
    //실제 품의문 기대효과
    private String effectContents;

    private String contractMethodContents;

    //발의부서
    private String department;

    //전결권
    private String approvalRight;

    //////3. 사업 내용 ///////
    //추진배경(객관식)
    private String background;

    // 자본 총합
    private String capitalTotalAmount;

    // 경비 총합
    private String expenseTotalAmount;

    private String allTotalAmount;


    //////////4. 사업추진방법
    //업체선정 방법
    private String selectionMethod;

    private String emergency;

    private String emergencyBackground;

    private String products;
    //소요시간
    private String duration;

    private String manager;

    private String cooperations;

    private String etc;

    private String attach;

  //  @OneToMany
  //  private Set<Cooperation> cooperations;


//    //
    private String step;

    private String munsu;
    
    //    //도입 물품
//    @Field(type = FieldType.Keyword)
//    private String items;
//    //부서
//    private String division;
//    //발의자
//   // private String proposer;
//    //private String epmo;
//    //예산
//    private Long budget;
//
//    private boolean functionPointYN;
//    private boolean siYN;
//    private boolean hwYN;
//    private boolean swYN;

 //   public ProjectInfo(Integer projectId, String projectName, String step, String items, String division, String proposer, String epmo, Long budget, boolean functionPointYN, boolean siYN, boolean hwYN, boolean swYN) {
//        this.projectId = projectId;
//        this.projectName = projectName;
//        this.step = step;
//        this.items = items;
//        this.division = division;
//        this.proposer = proposer;
//        this.epmo = epmo;
//        this.budget = budget;
//        this.functionPointYN = functionPointYN;
//        this.siYN = siYN;
//        this.hwYN = hwYN;
//        this.swYN = swYN;
//    }
}
