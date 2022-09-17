package com.ibk.epmo;

import com.ibk.epmo.account.BlogEsRepository;
import com.ibk.epmo.common.model.*;
import com.ibk.epmo.common.repository.*;
import com.ibk.epmo.common.service.SimProjectInfoService;
import com.ibk.epmo.functionpoint.FunctionPointInfo;
import com.ibk.epmo.functionpoint.FunctionPointInfoRepository;
import com.ibk.epmo.guide.GuideInfo;
import com.ibk.epmo.guide.GuideInfoRepository;
import com.ibk.epmo.issue.IssueInfo;
import com.ibk.epmo.issue.IssueInfoRepository;
import com.ibk.epmo.project.ProjectInfo;
import com.ibk.epmo.project.ProjectInfoRepository;
import com.ibk.epmo.question.QuestionInfo;
import com.ibk.epmo.question.QuestionInfoRepository;
import com.ibk.epmo.step.StepInfo;
import com.ibk.epmo.step.StepInfoRepository;
import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EpmoApplication extends SpringBootServletInitializer {

 //   @Autowired
  //  MongoTemplate mongoTemplate;
     private Logger logger = LoggerFactory.getLogger(EpmoApplication.class);
    @Autowired
    SimProjectInfoRepository simProjectInfoRepository;

    @Autowired
    StepInfoRepository stepInfoRepository;

    @Autowired
    QuestionInfoRepository questionInfoRepository;

    @Autowired
    IssueInfoRepository issueInfoRepository;

    @Autowired
    CheckInfoRepository checkInfoRepository;

    @Autowired
    ProjectInfoRepository projectInfoRepository;

    @Autowired
    BlogEsRepository blogEsRepository;

    @Autowired
    FunctionPointInfoRepository functionPointInfoRepository;

    @Autowired
    CompanyInfoRepository companyInfoRepository;

    @Autowired
    CompanyNewsInfoRepository companyNewsInfoRepository;

    @Autowired
    GuideInfoRepository guideInfoRepository;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(EpmoApplication.class);
    }
    public static void main(String[] args) {

        SpringApplication.run(EpmoApplication.class, args);
    }
    //시작시 데이터 입력
    @Bean
    public ApplicationRunner applicationRunner2(){
        return args->{
//            Blog blog = new Blog();
//            blog.setId("1");
//            blog.setContent("내용입니다.");
//            blog.setTitle("제목입니다.");
//            blogEsRepository.save(blog);blog
//            Blog blog2 = blogEsRepository.findById(1);


//            System.out.println("=="+blog2.getContent());


        };
    }

    //시작시 데이터 입력

    @Bean
    public ApplicationRunner applicationRunner(){
        return args->{
//            번호	단계	name	Type	내용 예시
//            1	번호	guideId	Int	1
//            2	단계	step	String	A001
//            3	가이드 내용	guideContents	String	판로지원법 확인 필요
//            4	가이드 분야	guideType	String	G001
//            5	추천	recommendCount	Int	3
//            6	추천자	recommender	String	박현조, 전예지, 김현수
//            7	등록자	publisher	String	박현조
//
   //         SearchService service = new SearchService();

           // service.search("판로지원법");
//
//            GuideInfo guideInfo1 = GuideInfo.builder()
//                    .guideId(1)
//                    .step("사전협의")
//                    .title("판로지원법 여부 확인 필요")
//                    .guideContents("법:중소기업제품 구매촉진 및 판로지원에 관한 법률(판로지원법)\n" +
//                            "- 공공구매사이트 접속하여 해당내역 조회 중기간 경쟁제품\n" +
//                            "(https://www.smpp.go.kr/prd/prdinfo/smlpzbtwncmptprd/SelectSmlpzBtwnCmptprdListVw.do)"
//                    )
//                    .relatedProject("공통")
//                    .guideType("1.법률, 규정")
//                    .recommendCount(0)
//                    .conditions("대기중")
//                    .publisher("박현조")
//                    .approval(false)
//                    .updatedDate("2022-05-15")
//                    .build();




            StepInfo stepInfo1 = new StepInfo();
            stepInfo1.setGuideId(1);
            //사전협의 A001
            stepInfo1.setStep("A001");
            stepInfo1.setTitle("판로지원법 여부 확인");


            HWPFile hwpFile ;
            String hwpText;
         //   hwpFile = HWPReader.fromFile("C:\\1.hwp");
            hwpFile = HWPReader.fromFile("C:\\1.hwp");

            hwpText = TextExtractor.extract(hwpFile, TextExtractMethod.InsertControlTextBetweenParagraphText);
            System.out.println("한글추출:"+hwpText);

            stepInfo1.setGuideContents("법:중소기업제품 구매촉진 및 판로지원에 관한 법률(판로지원법) <br />"
                 +   "- 공공구매사이트 접속하여 해당내역 조회 중기간 경쟁제품 여부 조회 (https://www.smpp.go.kr/prd/prdinfo/smlpzbtwncmptprd/SelectSmlpzBtwnCmptprdListVw.do)");
            //법률내규 G001
            stepInfo1.setGuideType("G001");

            //추천 Count
            stepInfo1.setRecommendCount(0);
            //승인여부
            stepInfo1.setApproval(true);
            stepInfo1.setPublisher("박현조");
            stepInfo1.setUpdatedDate("2021-10-10");


            StepInfo stepInfo2 = new StepInfo();
            stepInfo2.setGuideId(15);
            //사전협의 A001
            stepInfo2.setStep("A001");
            //단계
            stepInfo2.setTitle("전결권 확인 ");
            stepInfo2.setGuideContents("업무포털에서 전결권 확인 조회, ");

            //법률내규 G001
            stepInfo2.setGuideType("G001");

            //추천 Count
            stepInfo2.setRecommendCount(0);
            //승인여부
            stepInfo2.setApproval(true);
            stepInfo2.setPublisher("박현조");
            stepInfo2.setUpdatedDate("2021-10-10");

            GuideInfo guideInfo1 = GuideInfo.builder()
                    .guideId(1)
                    .step("S001")//사전협의
                    .guideType("T001")
                    .recommendCount(12)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .relatedProject("공통")
                    .title("판로지원법 여부 확인 필요")
                    .guideContents("법:중소기업제품 구매촉진 및 판로지원에 관한 법률(판로지원법)\n" +
                            "- 공공구매사이트 접속하여 해당내역 조회 중기간 경쟁제품\n" +
                            "- 대상: 스토리지 등" +
                            "(https://www.smpp.go.kr/prd/prdinfo/smlpzbtwncmptprd/SelectSmlpzBtwnCmptprdListVw.do)"
                    )
                    .build();

            GuideInfo guideInfo2 = GuideInfo.builder()
                    .guideId(2)
                    .step("S002")  //타당성검토
                    .guideType("T001") //법률
                    .recommendCount(9)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("전결권 확인 방법")
                    .guideContents("위임전결규정(업무포털) 조회")
                    .build();

            GuideInfo guideInfo3 = GuideInfo.builder()
                    .guideId(3)
                    .step("S001")  //사전협의
                    .guideType("T002")
                    .recommendCount(8)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("스토리지 도입시 랙 필요 여부 ")
                    .guideContents("계정성 업무일 때만 랙 필요")
                    .build();

            GuideInfo guideInfo4 = GuideInfo.builder()
                    .guideId(4)
                    .step("S002")  //타당성검토/합의
                    .guideType("T003")
                    .recommendCount(3)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("개발자 자리 확보 ")
                    .guideContents("총무부 담당자와 협의")
                    .build();
            GuideInfo guideInfo5 = GuideInfo.builder()
                    .guideId(5)
                    .step("S002")  //타당성검토/합의
                    .guideType("T001")
                    .recommendCount(7)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("소프트웨어영향평가방법 ")
                    .guideContents("은행장 직인 필요, 첨부파일..")
                    .build();

            GuideInfo guideInfo6 = GuideInfo.builder()
                    .guideId(6)
                    .step("S003")  //발주 및 계약
                    .guideType("T001")
                    .recommendCount(1)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("평가위원수")
                    .guideContents("50억이하 8명, 50억초과 10명(내규)")
                    .build();

            GuideInfo guideInfo7 = GuideInfo.builder()
                    .guideId(7)
                    .step("S003")  //발주 및 계약
                    .guideType("T003")
                    .recommendCount(12)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("제안평가 가능장소")
                    .guideContents("1. 대강당, 2. 본점 4층 세미나실 3. 파이낸스타워 하늘마루(27층)")
                    .build();

            GuideInfo guideInfo8 = GuideInfo.builder()
                    .guideId(8)
                    .step("S003")  //발주 및 계약
                    .guideType("T003")
                    .recommendCount(6)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("제안평가 사전준비")
                    .guideContents("1. 평가위원 섭외 \n" +
                            "2. 평가장소 섭외\n")
                    .build();

            GuideInfo guideInfo9 = GuideInfo.builder()
                    .guideId(9)
                    .step("S004")  //발주 및 계약
                    .guideType("T003")
                    .recommendCount(1)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("WBS 작성방법")
                    .guideContents("WBS\n")
                    .build();

            GuideInfo guideInfo10 = GuideInfo.builder()
                    .guideId(10)
                    .step("S001")
                    .guideType("T003") //일반 사항
                    .recommendCount(5)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("기능점수 작성 예외")
                    .guideContents("UI,UX\n")
                    .build();

            GuideInfo guideInfo11 = GuideInfo.builder()
                    .guideId(11)
                    .step("S001")
                    .guideType("T001") //일반 사항
                    .recommendCount(11)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("긴급공고 사유")
                    .guideContents("UI,UX\n")
                    .build();

            GuideInfo guideInfo12 = GuideInfo.builder()
                    .guideId(12)
                    .step("S001")
                    .guideType("T003") //일반 사항
                    .recommendCount(1)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("랙 도입 필요")
                    .guideContents("대상사업: 스토리지, 서버 \n")
                    .build();

            GuideInfo guideInfo13 = GuideInfo.builder()
                    .guideId(13)
                    .step("S003")
                    .guideType("T003") //일반 사항
                    .recommendCount(4)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("물품 반입 방법")
                    .guideContents("대상사업: 스토리지, 서버 \n")
                    .build();

            GuideInfo guideInfo14 = GuideInfo.builder()
                    .guideId(14)
                    .step("S003")
                    .guideType("T003") //일반 사항
                    .recommendCount(2)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("물품 검수 방법")
                    .guideContents("대상사업: 스토리지, 서버 \n")
                    .build();

            GuideInfo guideInfo15 = GuideInfo.builder()
                    .guideId(15)
                    .step("S001")
                    .guideType("T003") //일반 사항
                    .recommendCount(3)
                    .conditions("대기중")
                    .publisher("박현조")
                    .approval(false)
                    .updatedDate("2022-05-15")
                    .title("단위")
                    .guideContents("대상사업: 스토리지, 서버 \n")
                    .build();



            guideInfoRepository.deleteAll();
            logger.info("start==");
            guideInfoRepository.save(guideInfo1);
            guideInfoRepository.save(guideInfo2);
            guideInfoRepository.save(guideInfo3);
            guideInfoRepository.save(guideInfo4);
            guideInfoRepository.save(guideInfo5);
            guideInfoRepository.save(guideInfo6);
            guideInfoRepository.save(guideInfo7);
            guideInfoRepository.save(guideInfo8);
            guideInfoRepository.save(guideInfo9);
            guideInfoRepository.save(guideInfo10);
            guideInfoRepository.save(guideInfo11);
            guideInfoRepository.save(guideInfo12);
            guideInfoRepository.save(guideInfo13);
            guideInfoRepository.save(guideInfo14);
            guideInfoRepository.save(guideInfo15);

            logger.info("insert 1 ");




            stepInfoRepository.save(stepInfo1);
            stepInfoRepository.save(stepInfo2);
            logger.info("insert 2 ");

           // public StepInfo(Integer guideId, String step, String title, String guideContents, String guideType, Integer recommendCount, String conditions, String recommender, String publisher, boolean approval) {

            //예산 신청
            StepInfo stepInfo3 = new StepInfo(3, "A000", "견적서 징구방법", "기능점수형태로 견적 징구 필요", "G002", 0, "", "", "박현조", true,"2021-10-11") ;

            //예산 사전협의
            StepInfo stepInfo4 = new StepInfo(4, "A002", "수익성분석자료 작성", "유지보수 비용 포함 5년 TCO계산 필요", "G002", 0, "", "", "박현조", true,"2021-10-11") ;
            StepInfo stepInfo5 = new StepInfo(5, "A002", "견적서 징구방법", "기능점수형태로 견적 징구 필요", "G002", 0, "", "", "박현조", true,"2021-10-11") ;

            //타당성 검토(협의회)
            StepInfo stepInfo6 = new StepInfo(6, "A003", "실무협의회 참석자", "계약팀, 자산관리팀은 보통 참석, 그외는 별도 요청", "G002", 0, "", "", "박현조", true,"2021-10-11") ;
            StepInfo stepInfo7 = new StepInfo(7, "A003", "추진협의회 참석자", "부행장님, 유관부서 팀장", "G002", 0, "", "", "박현조", true,"2021-10-11") ;


            Thread.sleep(1000);
            logger.info("insert 3 ");

            //사업 품의
            StepInfo stepInfo8 = new StepInfo(8, "A004", "전결권 기준", "5억미만은 부서장, 20억이상은 부행장, 50억이상은 전무이사, 100억이상은 은행장님", "G002", 0, "", "", "박현조", true,"2021-10-11") ;
            StepInfo stepInfo9 = new StepInfo(9, "A004", "전결권 확인", "내규관리시스템- 위임전결규정 조회", "G002", 0, "", "", "박현조", true,"2021-10-11") ;

            //업체선정 요청
            StepInfo stepInfo10 = new StepInfo(10, "A005", "필요서류목록", "시행문, 품의문 ", "G002", 0, "", "", "박현조", true,"2021-10-11") ;

            //제안평가
            StepInfo stepInfo11 = new StepInfo(11, "A006", "제안평가위원구성", "유관부서 8명 ", "G002", 0, "", "", "박현조", true,"2021-10-11") ;
            StepInfo stepInfo12 = new StepInfo(12, "A006", "평가위원수", "유관부서 8명 ", "G002", 0, "", "", "박현조", true,"2021-10-11") ;

            //계약

            //사업준비
            StepInfo stepInfo13 = new StepInfo(13, "A008", "개발좌석 확보", "총무부 담당자 확인 필요 ", "G002", 0, "", "", "박현조", true,"2021-10-11") ;
            StepInfo stepInfo14 = new StepInfo(14, "A008", "관련법령", "판로지원법 Link:https://www.law.go.kr/%EB%B2%95%EB%A0%B9/%EC%A4%91%EC%86%8C%EA%B8%B0%EC%97%85%EC%A0%9C%ED%92%88%EA%B5%AC%EB%A7%A4%EC%B4%89%EC%A7%84%EB%B0%8F%ED%8C%90%EB%A1%9C%EC%A7%80%EC%9B%90%EC%97%90%EA%B4%80%ED%95%9C%EB%B2%95%EB%A5%A0 ", "G002", 0, "", "", "박현조", true,"2021-10-11") ;
            StepInfo stepInfo15 = new StepInfo(15, "A008", "전결권 기준 ", "50억이상 부행장님", "G002", 0, "", "", "박현조", true,"2021-10-11") ;

         //   StepInfo stepInfo14 = new StepInfo(14, "A008", "관련법령", "판로지원법", "G002", 0, "", "", "박현조", true) ;

//            stepInfoRepository.save(stepInfo1);
//            stepInfoRepository.save(stepInfo2);
//            stepInfoRepository.save(stepInfo3);
//            stepInfoRepository.save(stepInfo4);
//            stepInfoRepository.save(stepInfo5);
//            stepInfoRepository.save(stepInfo6);
//            stepInfoRepository.save(stepInfo7);
//            stepInfoRepository.save(stepInfo8);
//            stepInfoRepository.save(stepInfo9);
//            stepInfoRepository.save(stepInfo10);
//            stepInfoRepository.save(stepInfo11);
//            stepInfoRepository.save(stepInfo12);
//            stepInfoRepository.save(stepInfo13);
////
////
            stepInfoRepository.save(stepInfo14);
            stepInfoRepository.save(stepInfo15);
            System.out.println("====Insert ===1 ");

//        public QuestionInfo(Integer questionId, String step, String title, String questionContents, String questionType, Integer recommendCount, String conditions, String recommender, String publisher) {

            QuestionInfo questionInfo1 = new QuestionInfo(1,"A001","개발좌석은 어디 문의해야하나요?" ,"총무부 담당자에 확인 ", "G002",0,"","","EPMO(AI)","EPMO","2021-10-10","완료");
            QuestionInfo questionInfo2 = new QuestionInfo(2,"A003","실무협의회 참석자는 누구인가요?"   ,"계약팀, 자산관리담당자, IT시스템 담당자 등 유관 업무팀 ", "G002",0,"","","발의자","EPMO(AI)","2021-10-10","검토");
            QuestionInfo questionInfo3 = new QuestionInfo(3,"A001","기능점수 작성대상외는?" ,"디자인, 복잡한 사업등 ", "G002",0,"","","발의자","EPMO","2021-10-10","완료");
            QuestionInfo questionInfo4 = new QuestionInfo(4,"A001","판로지원법 대상은 확인은?" ,"SMPP", "G002",0,"","","발의자","EPMO","2021-10-10","완료");
            QuestionInfo questionInfo5 = new QuestionInfo(5,"A001","정보화사업추진교육은 언제?" ,"상반기, 하반기 1년에 두번", "G002",0,"","","EPMO(AI)","EPMO","2021-10-10","완료");
            QuestionInfo questionInfo6 = new QuestionInfo(6,"A001","전결권을 어디서 확인하나요?" ,"업무포털에서 조회", "G002",0,"","","발의자","EPMO","2021-10-10","완료");

            //public ProjectInfo(Integer projectId, String projectName, String step, String items, String division, String proposer, String epmo, Long budget, boolean functionPointYN, boolean siYN, boolean hwYN, boolean swYN) {

//            ProjectInfo projectInfo = new ProjectInfo(1,"리스크관리시스템 스토리지 교체 및 증설","정보화추진협의회",
//                    "스토리지,샌스위치,면진장비,랙","리스크총괄부","박현조"
//                    ,"박현조",607000L,false,false,true,false);
//
//            ProjectInfo projectInfo2 = new ProjectInfo(2,"공공마이데이터 구축","프로젝트 착수",
//                    "개발비, 서버, 스토리지, API GW","디지털기획부","김용주"
//                    ,"박현조",1207000L,true,true,true,true);
//
//            ProjectInfo projectInfo3 = new ProjectInfo(3,"마이데이터 시스템구축","프로젝트 착수",
//                    "개발비, 서버, 스토리지, WAS, 온튠","디지털기획부","최원호"
//                    ,"박현조",4007000L,true,true,true,true);
//
//            ProjectInfo projectInfo4 = new ProjectInfo(4,"오픈API 시스템 구축","프로젝트 착수",
//                    "개발비, 서버, 스토리지, API GW","디지털기획부","김한용"
//                    ,"박현조",2707000L,true,true,true,true);
//
            ProjectInfo projectInfo1 = ProjectInfo.builder()
                    .projectId(1)
                    .projectName("감사정보시스템 스토리지 증설")
                    .projectType("스토리지")
                    .epmo("전예지")
                    .proposer("정도현")
                    .keywords("감사정보시스템;스토리지;증설")
                    .fullDescription("")
                    .backgroundContents("1. 감사정보시스템의 데이터 마트는 영업점e-감사 업무 등에 주로 활용\n" +
                            "- 고객 및 거래내역 증가 등으로 인하여 저장 공간이 부족\n" +
                            "2. 감사 기초자료인 금융정보의 안정적인 확보 및 활용을 위해 스토리지 증설이 필요")
                    .currentSituation("")
                    .contents("1) (기종) 기존 스토리지(VSP-G200)와 동일 제조사의 제품 증설\n" +
                            " - 타 제품 도입 시 호환성, 유지보수 및 장애 대응 불가\n" +
                            " - 기존 스토리지의 향후 유지보수 중단 가능성을 감안하여 동일제조사 제품 증설\n" +
                            "2) (용량) 과거의 사용량 증가 추세를 고려하여 5TB 증설\n" +
                            " - 제조사는 시스템의 안정성 유지 차원에서 저장 공간 사용률을 최대 75%로 권장\n" +
                            " - 최근 사용량 증가 추이를 고려 시, 연간 약 11% 증가")
                    .effectContents(
                            "1) 저장 공간 증가로 인한 감사정보 시스템의 안정성 향상\n" +
                            " - 저장 공간 사용률 80% 이하일 때 데이터마트의 오류건수 없음\n" +
                            "2) 금융 거래내역의 조회 가능기간을 늘려 충분한 감사자료의 확보 및 감사의 효용성 증대 ")
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("검사부")
                    //.teamLeader("정희철")
                    //.depLeader("이병탁")
                    //.generalLeader("김운영")
                    //.vicePresident("")
                    .approvalRight("부서장")
                    .background("업무증가")
                    .products(
                                    "1) 구분: HW, 품목: 스토리지, VSP-F350(Userble 5TB), 수: 1, 단위: EA, 도입비용: 61,600천원, 유지보수요율: 8%\n"+
                                    "2) 구분: HW, 품목: 면진장비, SP-6000, 수: 2, 단위: EA, 도입비용: 6,600천원")
                    .capitalTotalAmount("68200000")
                    .expenseTotalAmount("0")
                    .allTotalAmount("68200000")
 //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임")
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("2개월")
   //                 .cooperations(cops)
                    .step("완료")
                   // .keywordS("감사정보시스템keywords)
                    .etc("위임전결규정에 의거 부서장 전결")
                    .manager("1) 스토리지 - 설치확인: IT시스템운영팀 서버운영팀, 운영담당: IT시스템운영팀 서버운영팀\n" +
                             "2) 면진장치 - 설치확인: IT시스템운영팀 네트워크팀, 운영담당: IT시스템운영팀 네트워크팀"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결 \n" +
                            "3) IT시스템운영팀 : 디스크 설치 확인 및 운영"
                    )
                    .attach("1) 견적서\n"+
                            "2) 감사정보시스템 운영 현황\n"+
                            "3) 감사정보시스템 디스크 월별 사용량\n")
                    .build();

            ProjectInfo projectInfo2 = ProjectInfo.builder()
                    .projectId(2)
                    .projectName("전자금융통합로그시스템 스토리지 증설교체")
                    .projectType("스토리지")
                    .epmo("전예지")
                    .proposer("우한승")
                    .keywords("전자금융통합로그시스템;스토리지;증설;면진;랙")
                    .fullDescription("")
                    .backgroundContents(
                                    "1) 지속적인 고객수 증가로 인한 스토리지 용량 추가 확보 필요\n" +
                                    " - 가용용량 부족에 대비한 스토리지 증설을 통해 안정적인 시스템을 구축하고자 함\n" +
                                    " - 비대면채널의 지속적인 거래 증가로 인한 데이터 공간 마련 필요\n" +
                                    "2) 현 저장장치(스토리지)에 대한 제조사(IBM) 기술지원 종료(EOS, End Of Service) 및 장애지원 중단으로 교체 필요\n" +
                                    "3) 관련 법규\n"+
                                    " - 전자금융거래법에 의거 거래로그를 5년 간 보관하며, 로그의 신뢰성 확보를 위하여 위변조가 불가능한 매체에 보관함\n"
                    )
                    .currentSituation("1) 디스크 활용 현황\n"
                            +" - 디스크, N6210, 38.5TB, 도입년도 : 2013년, 사용량 81.8%, 비고: EOS\n" +
                            "2) 디스크 예상 적재량\n" +
                            " - 향후 5년간 안젇ㅇ적 운영을 위해 20TB 추가 증설 필요"
                    )
                    .contents("1) 스토리지 저장공간 확대 및 노후 장비 증설 교체 추진\n"+
                            " - 기존 스토리지(N6210)가 단종됨에 따라 추가 증설 불가\n"+
                            "2) 현재 적재된 데이터에 대한 이관작업 진행\n" +
                            " - 신규 스토리지 구입하여 교체 및 데이터이관 작업 필요함\n" +
                            " - 저장 데이터 보존기간 및 Worm 속성 재설정 없이 그대로 유지\n" +
                            "3) 기존 자산은 IT자산총괄 관리자와 협의하여 처분 예정"
                            )
                    .effectContents("1) 스토리지 증설 교체를 통해 용량 부족으로 인한 장애를 근본적으로 해소하고, 데이터 증가에 대비한 적정 스토리지 용량 확보로 가용성 향상\n" +
                            "2) 시스템 가용성 확보로 해당 시스템 사용자에게 안정적인 금융정보 제공")
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("IT채널부")
                    .approvalRight("부서장")
                    .background("업무증가")
                    .capitalTotalAmount("187000000")
                    .expenseTotalAmount("0")
                    .allTotalAmount("187000000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임\n"+
                            "당행 요구사항에 충족하는 업체에 한해 가격입찰방식으로 추진하고자함"
                            )
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("3개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                                "1) 구분: HW, 품목: 스토리지 Userble 60TB, 수: 1, 단위: EA, 도입비용: 177,100천원, 유지보수요율: 8%\n"+
                                        "2) 구분: HW, 품목: 면진장비, SP-6000, 수: 2, 단위: EA, 도입비용: 7,200천원\n" +
                                        "3) 구분: HW, 품목: RACK, 수 1, 단위: EA, 도입비용: 2,200천원, 유지보수요율: 8%"
                    )
                    .etc("위임전결규정에 의거 부서장 전결")
                    .manager("1) 저장장치 - 설치확인: IT시스템운영팀 주전산운영팀, 운영담당: IT시스템운영팀 주전산운영팀\n" +
                             "2) RACK,면진장치 - 설치확인: IT시스템운영팀 주전산운영팀, 운영담당: IT시스템운영팀 주전산운영팀"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결 \n" +
                            "3) IT시스템운영팀 : 디스크 설치 확인 및 운영, 노후 스토리지 폐기 지원"
                    )
                    .attach("1) 월별 AP거래량 추이 및 비대면채널 이용자 증가현황\n" +
                            "2) 로그수집추이 및 향후 5년간 예상 수집량\n" +
                            "3) 스토리지 적재량 추이 및 향후 5년간 예상 적재량\n" +
                            "4) 시스템 구성도\n" +
                            "5) 스토리지 사양 및 공금조건\n" +
                            "6) 견적 비교표 및 견적서\n" +
                            "7) 제조사 기술지원 종료 안내 공문")
                    // .keywordS("감사정보시스템keywords)
                    .build();

            ProjectInfo projectInfo3 = ProjectInfo.builder()
                    .projectId(3)
                    .projectName("서류관리시스템 NAS스토리지 데이터 이관 및 증설")
                    .projectType("스토리지")
                    .epmo("박현조")
                    .proposer("김동현")
                    .keywords("서류관리시스템;NAS;스토리지;증설;이관;면진;랙")
                    .fullDescription("")
                    .backgroundContents(
                                    "1) 서류관리시스템 NAS스토리지 여유용량 부족\n" +
                                    " - 규정상 금융거래정보 요청 및 제공내역을 5년간 보관 필요\n" +
                                    " - 금융실명거래 및 비밀보장에 관한 법률 제 4조의 3\n"
                    )
                    .currentSituation(
                            "1) 금융정보제공 용량이 지속적으로 증가하여 5년 경과한 데이터를 삭제함에도 불구하고 사용량이 지속적으로 증가함\n" +
                            " - 19년 상반기: 1,095, 19년 하반기 사용량: 1,318,+\n"+
                            " - 20년 상반기: 1,587, 20년 하반기: 1,759, 21년 상반기: 2,034 \n"+
                            "2) 기존에 여유용량 부족할 때마다 IT시스템운영팀에서 용량을 할당받아 긴급대응하였으나 금융거래정보 용량 지속 증가\n"
                    )
                    .contents(
                            "1) 서류관리시스템 NAS스토리지 데이터 이관 및 증설 \n"+
                            " - 비용 절감을 위해 여유용량을 보유한 전자약정서 NAS스토리지(4TB)로 데이터 이관 및 스토리지 내 폴더분할을 통한 용량 개별 관리\n"+
                            " - 모델명: NetApp FAS2750, s/n:852106002826\n" +
                            "2) 데이터 이관 후 안정적인 운영을 위해 NAS스토리지 추가(4.9TB) 증설\n"+
                            " - 기종 : 현 운영중인 전자약정서 단독NAS스토리지에 대한 디스크 증설이며, 기존 제품 도입 시 호환성 및 유지보수, 장애 대응 불가에 따라 제조사 제품 증설" +
                            " - 증설 후 전자약정서 2.9TB, 서류관리시스템 6TB에 할당하여 운용예정"
                    )
                    .effectContents("1) 금융거래정보 제공내역 등의 안정적인 보관으로 당행 평판리스크 방지\n"+
                            " - 데이터 이관 및 증설 후 여유용량 확보로 안정적인 운용가능\n" +
                            " - 전자약정서 증설 후 할당량: 2,900GB, 데이터 이관 후 사용량: 604GB\n" +
                            " - 서류관리시스템 데이터 증설 후 할당량: 6,000GB, 데이터 이관 후 사용량:  2,130GB"
                    )
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("프로세스혁신부")
                    .approvalRight("부서장")
                    .background("여유공간 부족")
                    .capitalTotalAmount("13200000")
                    .expenseTotalAmount("0")
                    .allTotalAmount("13200000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임\n"+
                            "당행 요구사항에 충족하는 업체에 한해 가격입찰방식으로 추진하고자함"
                    )
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("2개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: 스토리지 증설 NetApp FAS2750 Storage 증설(SSD 960GB*6EA, Userble 4.9TB), 수: 1, 단위: EA, 도입비용: 13200천원, 유지보수요율: 10%\n"
                    )
                    .etc("금번 NAS스토리지 증설 후 기존 할당용량을 IT시스템운영팀에 반납예정")
                    .manager("1) NAS스토리지증설 - 설치확인: IT시스템운영팀 서버운영팀, 운영담당: IT시스템운영팀 서버운영팀\n"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결 \n" +
                            "3) IT시스템운영팀 : NAS스토리지 증설확인 및 관리 \n" +
                            "4) IT금융개발부 : 데이터 이관 및 정합성 검증 \n" +
                            "5) 기업디지털채널부 : 전자약정서 NAS스토리지 공동사용 동의"
                    )
                    .attach("1) 서류관리시스템 NAS 사용량 추이\n" +
                            "2) 업체별 견적서\n"
                    )
                    // .keywordS("감사정보시스템keywords)
                    .build();

            ProjectInfo projectInfo4 = ProjectInfo.builder()
                    .projectId(4)
                    .projectName("금리 유동성리스크 시스템 스토리지 증설")
                    .projectType("스토리지")
                    .epmo("김현수")
                    .proposer("김어진")
                    .keywords("금리유동성리스크;스토리지;증설")
                    .fullDescription("금리·유동성리스크 시스템의 안정적인 운영을 위하여 디스크 용량을 증설")
                    .backgroundContents(
                            "1) 금리·유동성리스크 산출 데이터 증가에 대비하여 안정적인 시스템  운영을 위한 스토리지 증설 필요\n" +
                                    "2) 대출, 예금 등 은행의 자산·부채 및 연결 자회사(인도네시아 및 미얀마 법인) 데이터 입수에 따른 리스크 산출대상 데이터 증가량 반영 필요\n" +
                                    "3) 감독당국의 규제 대응(차액결제이행담보증권 미사용분 LCR 반영)을 위한 데이터 공간 확보\n"
                    )
                    .currentSituation(
                            "1) 21.11월 금리․유동성리스크 시스템의 디스크 사용률은 94.5%, 월 평균 사용량 감안 시 ’21년도 말 예상 사용률 약 95.3% 예상\n" +
                                    " - 주 데이터 적재 디스크(VSP-F350)는 약 96% 사용 중(’21.12.6), 보조 스토리지(VSP-G800, 압축 데이터 보관)도 약 93% 사용 중\n"
                    )
                    .contents(
                            "1) 과거 추이 및 데이터 순증, 규제대응 등을 고려하여 10TB(B x 1.2) 증설 필요 \n"+
                                    " - 과거 추이 고려(A)+자회사 증가분 : 7894GB + 18GB, 월별 데이터 자연 증가량 반영\n"+
                                    " - 데이터 자연 순증 대비(B) : 8351GB, 자회사 신규 데이터 입수 추가\n"
                    )
                    .effectContents("1) 향후 안정적인 규제대응 가능\n"+
                            " - 여유 디스크 공간 확보로 안정적인 전산 작업 및 원활한 규제 대응 가능\n" +
                            " - 자회사 여·수신 데이터 확보로 LCR 및 NSFR 등 유동성리스크 지표 산출 정교화\n"
                    )
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("리스크총괄부")
                    .approvalRight("부서장")
                    .background("여유공간 부족")
                    .capitalTotalAmount("130900000")
                    .expenseTotalAmount("0")
                    .allTotalAmount("130900000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임\n"+
                            "동일기종(제품)을 납품할 수 있는 업체 간 가격입찰방식으로 추진하고자함"
                    )
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("2개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: 스토리지 VSP-F350(Usable 10.3TB), 수: 1, 단위: EA, 도입비용: 130900천원, 유지보수요율: 8%\n"
                    )
                    .etc("")
                    .manager("1) 스토리지 - 설치확인: IT시스템운영팀 기획품질팀, 운영담당: IT시스템운영팀 기획품질팀\n"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결 \n" +
                            "3) IT시스템운영팀 : 디스크 설치 확인 및 운영 \n"
                    )
                    .attach("1) 견적서 3부\n" +
                            "2) 금리 유동성리스크 시스템 운영 현황 1부\n" +
                            "3) 디스크 월별 사용량 1부\n" +
                            "4) 디스크 용량증설 산출 세부 근기 1부\n"
                    )
                    // .keywordS("금리유동성리스크keywords)
                    .build();

            ProjectInfo projectInfo5 = ProjectInfo.builder()
                    .projectId(5)
                    .projectName("종합수익관리 및 성과관리시스템 스토리지 교체 및 신규 증설")
                    .projectType("스토리지")
                    .epmo("전예지")
                    .proposer("박성진")
                    .keywords("종합수익관리;성과관리;스토리지;교체;증설")
                    .fullDescription("수익성 및 성과 분석체계 기반 마련을 위한 저장장치 구입 및 종합수익관리시스템과 성과관리시스템 안정적 운영을 위한 시스템 업그레이드")
                    .backgroundContents(
                            "1) 旣사용 저장장치(Hitachi HUS150) 기술지원 종료(End Of Service)로 인한 교체 및 종합수익관리시스템 및 성과관리시스템 지속적인 데이터 사용량 증가로 인한 증설 필요\n" +
                                    "2) 저장장치 교체 및 증설과 동시에 내부 자원을 활용한 서버OS 및 DBMS(Oracle) 업그레이드로 안정적인 시스템 운영 도모\n"
                    )
                    .currentSituation(
                            "1) 종합수익관리시스템(HUS150) : 용량(60TB), 잔여공간(4TB), 사용률 92.3%\n" +
                                    "2) 성과관리시스템(HUS150) : 용량(31TB), 잔여공간(2.6TB), 사용률 91.6%\n"
                    )
                    .contents(
                            "1) 기술지원 종료된 旣사용 저장장치 약 91TB 교체 \n"+
                                    "2) 종합수익관리시스템(30TB) 및 성과관리시스템(10TB) 총 40TB 신규 구입 \n"+
                                    " - (종합수익관리) 성과관리 체계의 안정적인 구축을 위해 5개년(’19년~’23년) 병행결산, 산출근기 : 월 평균 사용량(600GB) x 병행결산 기간(60개월)\n"+
                                    "                      과거 결산추이(39.2TB) - 데이터 정비(6TB) = 33.2TB\n"+
                                    " - (성과관리) 영업점 등 사용자 편의에 맞춘 시각화된 통계정보 및 다양한 성과분석 Tool 개발·제공에 필요한 저장공간 약 10TB 구입\n" +
                                    "                      과거 결산추이(10.5TB) + 미래 데이터 순증 고려(4.3TB) - 데이터 정비(3.6TB) = 11.2TB\n"
                    )
                    .effectContents(
                            "1) 저장장치 교체 및 증설에 따른 안정적인 데이터 관리 도모\n"+
                                    " - 기술지원 종료된 저장장치 교체를 통한 안정적인 데이터 관리\n" +
                                    " - 디지털 고객 수익성 분석체계 마련, 다양한 성과분석 Tool 제공 등 사용자 중심의 경영 의사결정 지원에 대비한 적정 저장용량 확보\n" +
                            "1) 시스템 업그레이드를 통한 정보보안체계 확립\n"+
                                    " - 서버OS 및 DBMS 최신화로 시스템 보안취약점(뉴욕지점 관련 등) 선제적 대응\n"
                    )
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("경영관리부")
                    .approvalRight("그룹장")
                    .background("기술지원종료")
                    .capitalTotalAmount("828300000")
                    .expenseTotalAmount("")
                    .allTotalAmount("828300000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임\n"+
                            "동일기종(제품)을 납품할 수 있는 업체 간 가격입찰방식으로 추진하고자함"
                    )
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("6개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: 스토리지 Hitachi VSP 5100(Usable 144TB), 수: 1, 단위: EA, 도입비용: 820600천원, 유지보수요율: 8%\n" +
                                    "2) 구분: HW, 품목: 면진테이블 SP-6000, 수: 2, 단위: EA, 도입비용: 7700천원\n"
                    )
                    .etc(
                            "1) 旣사용 저장장치는 DBMS 업그레이드 시 백업디스크로 활용하여 안정적인 데이터 이전 완료 후 폐기 예정(약 1년간 병행운영 예정)\n" +
                                    "2) 교체 장비(Hitachi HUS150)는 잔존가치 1천원으로 매각익 보다 비용이 더 소요될 것으로 판단되어 설치 업체를 통해 폐기 처분 예정\n"
                    )
                    .manager(
                            "1) 스토리지 - 설치확인: IT시스템운영팀 서버운용팀, 운영담당: IT시스템운영팀 서버운용팀\n" +
                                    "2) 면진 - 설치확인: IT시스템운영팀 네트워크팀, 운영담당: IT시스템운영팀 네트워크팀\n"
                    )
                    .cooperations("1) 전략기획부 : 사업예산 합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결 \n" +
                            "3) IT시스템운영팀 : 디스크 설치 및 운영지원, 서버 OS 및 DBMS 업그레이드 업무 지원\n"
                    )
                    .attach(
                            "1) 시스템 구성도 1부\n" +
                                    "2) 시스템별 저장장치 사용현황 1부\n" +
                                    "3) 旣사용 저장장치 EOS 공문 1부\n" +
                                    "4) 저장장치 구입 견적비교표 및 견적서 1부\n"
                    )
                    // .keywordS("종합수익관리시스템,성과관리시스템keywords)
                    .build();
            ProjectInfo projectInfo6 = ProjectInfo.builder()
                    .projectId(6)
                    .projectName("서브업무용 NAS 스토리지 증설")
                    .projectType("스토리지")
                    .epmo("전예지")
                    .proposer("조은별")
                    .keywords("서브업무용;NAS;스토리지;증설")
                    .fullDescription("감정평가서 등 담보파일의 증가량을 감안하여 서브업무용 NAS 스토리지 증설")
                    .backgroundContents(
                            "1) 감정평가서/시가조사서 등 담보파일 저장을 위한 스토리지 부족\n"

                    )
                    .currentSituation(
                            "1) NAS 스토리지 총 용량 2.5TB 중 현재 약 2.2TB 사용 중(잔여용량 300GB)이며, 매년 약 0.86TB씩 증가하는 추세\n"
                    )
                    .contents(
                            "1) 감정평가서/시가조사표 등 담보파일의 보관기간을 5년으로 결정 \n"+
                                    "2) 서브업무용 NAS 스토리지 4TB(Usable) 증설 후 여신지원시스템에 필요용량 2.5TB(Usable) 할당 \n"+
                                    " - HDD 12EA가 최소 증설 단위로 Usable 4TB가 최소 증설 용량\n"+
                                    " - 매년 약 0.8TB씩 저장 공간이 필요한 점을 감안하여 현행 2.5TB에서 5TB(+ 2.5TB)로 스토리지 증설\n"
                    )
                    .effectContents(
                            "1) 저장장치 증설에 따른 안정적인 데이터 관리 도모\n"
                    )
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("여신기획부")
                    .approvalRight("부서장")
                    .background("여유공간부족")
                    .capitalTotalAmount("14850000")
                    .expenseTotalAmount("")
                    .allTotalAmount("14850000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임\n"+
                            "동일기종(제품)을 납품할 수 있는 업체 간 가격입찰방식으로 추진하고자함"
                    )
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("1개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: 스토리지 DS4243(12*600GB,15k rpm, Usable 4TB), 수: 1, 단위: EA, 도입비용: 14850천원, 유지보수요율: 8%\n"
                    )
                    .etc(
                            ""
                    )
                    .manager(
                            "1) NAS - 설치확인: IT시스템운영팀 주전산운영팀, 운영담당: IT시스템운영팀 주전산운영팀\n"
                    )
                    .cooperations("1) 전략기획부 : 사업예산 합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결 \n" +
                            "3) IT시스템운영팀 : NAS스토리지 증설 및 할당 지원\n"
                    )
                    .attach(
                            "1) 시스템 구성도 1부\n" +
                                    "2) 견적서 3부\n" +
                                    "3) 월별 증가추이 1부\n"
                    )
                    // .keywordS("서브업무용시스템keywords)
                    .build();
            ProjectInfo projectInfo7 = ProjectInfo.builder()
                    .projectId(7)
                    .projectName("2022 서브업무 노후 스토리지 교체")
                    .projectType("스토리지")
                    .epmo("김정완")
                    .proposer("노진규")
                    .keywords("서브업무;스토리지;교체")
                    .fullDescription("서브업무통합용 및 재해복구용 스토리지의 노후화로 인한 장애예방 및 안정운영을 위해 교체를 추진")
                    .backgroundContents(
                            "1) 서브업무 및 재해복구용* 스토리지의 노후화로 인한 장애위험 증가\n" +
                                    "2) 現 스토리지에 대한 제조사 기술지원 종료(EOS*) 및 장애지원 중단으로 장비 교체 필요\n"
                    )
                    .currentSituation(
                            "1) 전체 스토리지 운영현황(주전산: 13대 1561TB, 서브업무: 97대 3342TB, 재해복구: 31대 1761TB)\n" +
                                    "2) 금차 교체대상 스토리지(서브업무: 2대, 재해복구: 4대)\n" +
                                    " - 서브업무(거래추적, 배치성 과거데이터관리) : Hitachi VSP 50TB, EOS : 2021.06 \n"+
                                    " - 서브업무(新신탁, 재정기금, ATMS 등) : HP V800 34TB, EOS : 2021.05 \n"+
                                    " - 재해복구(新신탁, 재정기금) : HP 7400 16TB, EOS : 2022.10 \n"+
                                    " - 재해복구(통합인터넷뱅킹) : Hitachi VSP 23TB, EOS : 2021.06 \n"+
                                    " - 재해복구(주전산 OS용) : IBM DS8870 9TB, EOS : 2020.12 \n"+
                                    " - 재해복구(서브업무 OS용) : IBM XIV 27TB, EOS : 2020.12 \n"
                    )
                    .contents(
                            "1) 전체 용량 : (교체 前) 159TB ⇨ (교체 後) 151TB (▼8TB 감소) \n"+
                                    " - 서브업무(거래추적, 배치성 과거데이터관리) : 도입용량 50TB \n"+
                                    " - 서브업무(新신탁, 재정기금, ATMS 등) : 도입용량 34TB \n"+
                                    " - 재해복구(新신탁, 재정기금) : 도입용량 14TB \n"+
                                    " - 재해복구(통합인터넷뱅킹) : 도입용량 10TB \n"+
                                    " - 재해복구(주전산 OS용) : 도입용량 17TB \n"+
                                    " - 재해복구(서브업무 OS용) : 도입용량 26TB \n" +
                                    "2) 교체장비의 성능향상을 위해 All Flash 장비로 도입 \n"
                    )
                    .effectContents(
                            "1) 現 운영업무에 적합한 최적의 제품도입을 검토하여 도입비용 절감\n"+
                                    "2) 신형 디스크타입(All-Flash) 도입에 따른 성능 개선 및 전력사용량 감소\n"
                    )
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("IT시스템운영팀")
                    .approvalRight("그룹장")
                    .background("기술지원종료")
                    .capitalTotalAmount("1786987000")
                    .expenseTotalAmount("")
                    .allTotalAmount("1786987000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임\n"+
                            "동일기종(제품)을 납품할 수 있는 업체 간 가격입찰방식으로 추진하고자함"
                    )
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("6개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: 스토리지 서브업무용(거래추적 外) Usable 50TB이상, 수: 1, 단위: EA, 도입비용: 306934천원, 유지보수요율: 8%\n"+
                            "2) 구분: HW, 품목: 스토리지 서브업무용(新신탁 外) Usable 34TB이상, 수: 1, 단위: EA, 도입비용: 366761천원, 유지보수요율: 8%\n"+
                            "3) 구분: HW, 품목: 스토리지 재해복구용(新신탁 外) Usable 14TB이상, 수: 1, 단위: EA, 도입비용: 14850천원, 유지보수요율: 8%\n"+
                            "4) 구분: HW, 품목: SAN스위치 48포트 이상, 인터페이스 16Gbps이상, 수: 2, 단위: EA, 도입비용: 151929천원, 유지보수요율: 8%\n"+
                            "5) 구분: HW, 품목: 면진테이블(SP-6000), 수: 4, 단위: EA, 도입비용: 25280천원\n"+
                            "6) 구분: HW, 품목: 스토리지 VSP 5200 Usable 10TB, 수: 1, 단위: EA, 도입비용: 269500천원, 유지보수요율: 8%\n"+
                            "7) 구분: HW, 품목: 스토리지 FS7200 Usable 17TB, 수: 1, 단위: EA, 도입비용: 167432천원, 유지보수요율: 8%\n"+
                            "8) 구분: HW, 품목: 스토리지 FS7200 Usable 26TB, 수: 1, 단위: EA, 도입비용: 199129천원, 유지보수요율: 8%\n"+
                            "9) 구분: HW, 품목: SAN스위치 SAN64B-6 36포트, 수: 2, 단위: EA, 도입비용: 113873천원, 유지보수요율: 8%\n"+
                            "10) 구분: HW, 품목: 면진테이블(SP-6000), 수: 2, 단위: EA, 도입비용: 12640천원\n"
                    )
                    .etc(
                            "1) 노후장비 폐기는 설치 업체를 통해 회수 및 폐기 추진 예정\n" +
                                    "2) 매각을 통해 진행 시 매각이익(0원)보다 비용(폐기비 발생)이 더 소요될것으로 판단되어 설치 업체를 통해 처분 예정\n"
                    )
                    .manager(
                            "1) 스토리지 - 설치확인: IT시스템운영팀 서버운영팀, 운영담당: IT시스템운영팀 서버운영팀\n" +
                                    "2) SAN스위치 - 설치확인: IT시스템운영팀 서버운영팀, 운영담당: IT시스템운영팀 서버운영팀\n" +
                                    "3) 면진테이블 - 설치확인: IT시스템운영팀 네트워크팀, 운영담당: IT시스템운영팀 네트워크팀\n"
                    )
                    .cooperations("1) 전략기획부 : 사업예산 합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결 \n"
                    )
                    .attach(
                            "1) 제조사 기술지원 종료 안내 공문 1부\n" +
                                    "2) 스토리지 사용업무시스템 현황 1부\n" +
                                    "3) IT장비 교체기준 및 기존 저장장치 도입내역 1부\n" +
                                    "4) 제품 사양 및 공급 조건 1부\n" +
                                    "5) 기존장비 대비 교체장비 성능 비교표 1부\n" +
                                    "6) 견적 비교표 및 견적서 1부\n" +
                                    "7) 노후 전산장비 매각 견적서 1부\n"
                    )
                    // .keywordS("서브업무keywords)
                    .build();
            ProjectInfo projectInfo8 = ProjectInfo.builder()
                    .projectId(8)
                    .projectName("ADW시스템 메모리 증설 및 OS 스토리지 교체")
                    .projectType("스토리지")
                    .epmo("김정완")
                    .proposer("이현웅")
                    .keywords("ADW시스템;메모리;OS;스토리지;교체")
                    .fullDescription("ADW시스템의 성능개선을 통한 장애예방 및 안정적 운영을 위해 메모리 증설과 서버 OS 스토리지 교체를 추진")
                    .backgroundContents(
                            "1) 지속적인 사용량과 데이터 증가에 대비하고 안정적인 시스템 운영을 위한 메모리 증설\n" +
                                    "2) 메모리 부족으로 인한 배치작업 지연 방지\n" +
                                    "3) 기술지원 종료 (2021.12.31.)에 따른 노후 저장장치의 교체 필요\n"
                    )
                    .currentSituation(
                            "1) ADW시스템 메모리 현황\n" +
                                    " - ADW DB1호기 : CPU (40core), 메모리(608GB)\n"+
                                    " - ADW DB2호기 : CPU (32core), 메모리(416GB)\n"+
                                    "2) ADW시스템 서버 OS 스토리지 HP P2000(7TB)\n"
                    )
                    .contents(
                            "1) ADW시스템 메모리 320GB 증설 \n"+
                                    " - 現 사용량 기준 공급사 권장 사양 : CPU 1core당 18GB 메모리\n"+
                                    " - 권장사양기준 기존대비 DB1호기 112GB, DB2호기 160GB 증설 필요하나 증설 최저단위 64GB로 각각, 128GB, 192GB 증설\n" +
                                    " - DB 1호기 : 40core × 18GB = 720GB, 720GB – 608GB = 112GB  →  64GB × 2 = 128GB\n" +
                                    " - DB 2호기 : 32core × 18GB = 576GB, 576GB – 416GB = 160GB  →  64GB × 3 = 192GB\n" +
                                    "2) ADW시스템 서버 OS 스토리지 HP MSA2060(9.2TB)\n"+
                                    " - 기존 스토리지 6대 구성에서 2대로 변경\n"+
                                    " - 안전성을 위한 RAID-6 구성으로 전체 용량은 증가\n" +
                                    " - 서버 6대와 스토리지 2대를 연결하기 위한 SAN스위치 추가\n"
                    )
                    .effectContents(
                            "1) 장애위험 감소 및 시스템 운영 안정성 제고\n"+
                                    "2) 시스템 성능 개선 및 가용성 확보\n"+
                                    "3) ADW시스템을 사용하는 100개 단위시스템에 원활한 데이터 제공\n"
                    )
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("IT정보부")
                    .approvalRight("부서장")
                    .background("기술지원종료")
                    .capitalTotalAmount("224400000")
                    .expenseTotalAmount("")
                    .allTotalAmount("224400000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임\n"+
                            "동일기종(제품)을 납품할 수 있는 업체 간 가격입찰방식으로 추진하고자함"
                    )
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("6개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: 메모리증설 ADW1호기 HPE SD2 Memory 128GB, 수: 1, 단위: EA, 도입비용: 56210천원, 유지보수요율: 6%\n" +
                                    "2) 구분: HW, 품목: 메모리증설 ADW2호기 HPE SD2 Memory 192GB, 수: 1, 단위: EA, 도입비용: 84150천원, 유지보수요율: 6%\n" +
                                    "3) 구분: HW, 품목: 스토리지 HPE MSA 2060 Storage (Raid6, Usable 4.6TiB), 수: 2, 단위: EA, 도입비용: 34760천원, 유지보수요율: 6%\n" +
                                    "4) 구분: HW, 품목: 스토리지 기술지원 HPE Technical SVC (데이터 이관 및 재배치 작업), 수: 1, 단위: 식, 도입비용: 10890천원\n" +
                                    "5) 구분: HW, 품목: SAN스위치 HPE StoreFabric SN6010C 12port 16G FC Switch, 수: 2, 단위: EA, 도입비용: 38390천원, 유지보수요율: 6%\n"
                    )
                    .etc(
                            "1) 기존 스토리지 장비는 교체 작업 안정화 이후 처분예정"
                    )
                    .manager(
                            "1) 메모리증설 - 설치확인: IT시스템운영팀 서버운영팀, 운영담당: IT시스템운영팀 서버운영팀\n" +
                                    "2) 스토리지 - 설치확인: IT시스템운영팀 서버운영팀, 운영담당: IT시스템운영팀 서버운영팀\n" +
                                    "3) SAN스위치 - 설치확인: IT시스템운영팀 서버운영팀, 운영담당: IT시스템운영팀 서버운영팀\n"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결 \n" +
                            "3) IT시스템운영팀 : 장비 설치지원\n"
                    )
                    .attach(
                            "1) 유지정비서비스 종료 안내 공문\n" +
                                    "2) 시스템 사용현황 및 장애발생 내역\n" +
                                    "3) 주요 성능개선 내역\n" +
                                    "4) 견적서\n" +
                                    "5) 스토리지 기술지원 명세\n"
                    )
                    // .keywordS("ADW시스템keywords)
                    .build();
            ProjectInfo projectInfo9 = ProjectInfo.builder()
                    .projectId(9)
                    .projectName("ADW시스템 노후 저장장치(스토리지) 교체")
                    .projectType("스토리지")
                    .epmo("김욱순")
                    .proposer("김형곤")
                    .keywords("ADW시스템;스토리지;교체")
                    .fullDescription("ADW시스템 저장장치(스토리지)의 노후화(2012년 도입, 2019.9월 제조사 기술지원 종료)로 인한 장애예방 및 안정적 운영을 위해 교체를 추진")
                    .backgroundContents(
                            "1) ADW시스템의 노후 저장장치 사용에 따른 장애위험 증가에 선제적 대응\n" +
                                    "2) 지속적인 데이터 증가에 대비하고 안정적인 정보지원을 위한 저장공간 증설\n" +
                                    "3) 제조사 기술지원 종료 : 2019년 9월 (2020.12월까지 연장)\n"
                    )
                    .currentSituation(
                            "1) 저장장치 운영현황\n" +
                                    " - 운영 저장장치 : EMC VMAX, 용량 : 192TB, 도입년도 : 2012, 업무영역 : DB서버(4대),ETL서버(2대),교체 및 증설\n"+
                                    " - 모니터링 : EMC VMAX, 용량 : 0.7TB, 도입년도 : 2014, 업무영역 : DB모니털이,도입장비 통합\n"
                    )
                    .contents(
                            "1) ADW시스템 저장장치 증설/교체 및 모니터링 장비통합\n"+
                                    " - 기존(AS-IS) : HDD, 192TB, DB모니터링 단독장비\n"+
                                    " - 변경예정(TO-BE) : SSD, 214TB, 도입장비 통합\n" +
                                    " - 현재 저장공간 사용현황 : 전체 70.0TB 중 60.4TB 사용중(86.2% 사용률)" +
                                    " - 2023년까지 저장공간 사용량은 예측(CAGR주1))을 통해 8TB 증가된 68.4TB로 추정되며 권장 사용률(85%이하)고려 시 81.0TB(=68.4TB ÷ 85.0%) 필요\n" +
                                    " - 증설필요 저장공간 : 22TB = 11.0TB(=81.0TB-70.0TB) × 2배\n"+
                                    " - ADW 데이터 복구를 위한 내부복제용 저장공간도 동일규모 증설\n"
                    )
                    .effectContents(
                            "1) 정량적 효과\n"+
                                    " - 입출력성능(IOPS) : 약 200,000번/초당 3.8배 향상\n"+
                                    " - 설치상면 가용성 증가, 시설비용 감소\n"+
                                    " - 전력소비량 43Watt 74%감소\n"+
                                    "2) 정성적 효과\n"+
                                    " - 장애리스크 감소에 따른 안정적인 시스템 운영\n"+
                                    " - 디스크 입출력성능(IOPS) 개선으로 ADW 배치작업 시간 단축\n"+
                                    " - 신규 정보화 사업대비 적정 스토리지 용량 확보로 가용성 향상\n"
                    )
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "당행 요구사항을 충족하는 제품 중 가격경쟁입찰")
                    .department("IT정보부")
                    .approvalRight("그룹장")
                    .background("기술지원종료")
                    .capitalTotalAmount("1243201000")
                    .expenseTotalAmount("")
                    .allTotalAmount("1243201000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임\n"+
                            "당행 요구사항을 충족하는 제품 중 가격입찰방식으로 추진하고자함"
                    )
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("6개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: 스토리지 저장장치  Usable 214TB, 수: 1, 단위: EA, 도입비용: 1095862천원, 유지보수요율: 6%\n" +
                                    "2) 구분: HW, 품목: SAN스위치, 수: 2, 단위: EA, 도입비용: 138539천원, 유지보수요율: 6%\n" +
                                    "3) 구분: HW, 품목: 면진테이블 SP-6000, 수: 2, 단위: EA, 도입비용: 8800천원\n"
                    )
                    .etc(
                            "1) 본 사업관련 세부추진사항은 관련 부서장 전결로 처리하고자 함"
                    )
                    .manager(
                            "1) 스토리지 - 설치확인: IT시스템운영팀 서버운영팀, 운영담당: IT시스템운영팀 서버운영팀\n" +
                                    "2) SAN스위치 - 설치확인: IT시스템운영팀 서버운영팀, 운영담당: IT시스템운영팀 서버운영팀\n" +
                                    "3) 면진테이블 - 설치확인: IT시스템운영팀 서버운영팀, 운영담당: IT시스템운영팀 서버운영팀\n"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결 \n" +
                            "3) IT시스템운영팀 : 장비교체 검토 및 지원\n"
                    )
                    .attach(
                            "1) 유지정비서비스 종료 안내 공문\n" +
                                    "2) 유지정비서비스 연장 안내 공문(1차 연장)\n" +
                                    "3) 유지정비서비스 연장 안내 공문(2차 연장)\n" +
                                    "4) 저장장치(스토리지) 사양 및 공급 조건\n" +
                                    "5) 신규 도입 스토리지 모델 검토\n" +
                                    "6) ADW 디스크 관리 현황\n" +
                                    "7) 견적 비교표 및 견적서\n"
                    )
                    // .keywordS("ADW시스템keywords)
                    .build();
            ProjectInfo projectInfo10 = ProjectInfo.builder()
                    .projectId(10)
                    .projectName("고객상담녹취시스템 NAS 스토리지 교체")
                    .projectType("스토리지")
                    .epmo("송병훈")
                    .proposer("정지원")
                    .keywords("고객상담녹취시스템;NAS;스토리지;교체")
                    .fullDescription("효율적인 시스템운영과 안정적인 대고객 서비스 제공을 위해 고객상담 녹취시스템 NAS 스토리지 교체를 추진")
                    .backgroundContents(
                            "1) 고객상담 녹취시스템 NAS 스토리지 EOS로 인해 신규 구축 필요\n"
                    )
                    .currentSituation(
                            "1) 코로나 등 고객센터를 통한 비대면 상담량 증가(녹취데이터 청취량 증가)에 따른 저장공간 추가증설 및 스토리지 시스템 최신화 필요\n" +
                                    "2) 스토리지 유지보수 미계약에 따른 월 정기점검 미실시 및 운영리스크 상존 \n" +
                                    "3) 현재 18TB Usable Data 중 사용률 79%\n"
                    )
                    .contents(
                            "1) 신규 도입구축으로 향후 5년간 안정적인 운영을 위한 용량 추가증설 필요\n"+
                                    " - 95%기준 잔여용량: 17,759-14,768 = 2,991GB\n"+
                                    " - 일평균 8.6GB를 95%까지 사용시 1주 사용량 = 43.73GB\n" +
                                    " - 260주(5년)*43.73GB = 11.1TB 증설필요 (18.2+11.1=30TB)"
                    )
                    .effectContents(
                            "1) 저장장치 교체 및 증설에 따른 안정적인 데이터 관리 도모\n"
                    )
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("IT채널부")
                    .approvalRight("부서장")
                    .background("기술지원종료")
                    .capitalTotalAmount("45803000")
                    .expenseTotalAmount("")
                    .allTotalAmount("45803000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임\n"+
                            "동일기종(제품)을 납품할 수 있는 업체 간 가격입찰방식으로 추진하고자함"
                    )
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("2개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: NAS 스토리지, 수: 1, 단위: EA, 도입비용: 45803천원, 유지보수요율: 10%\n"
                    )
                    .etc(
                            "1) 필수사양\n" +
                                    " - Usable Data Total : 32TB\n" +
                                    " - 디스크 구성 : RAID 5 또는 6\n" +
                                    " - 용도 : 녹취파일 보관용 NAS 서버\n" +
                                    " - 고가용성 : 스토리지內 서버 및 컨트롤 이중화 구성\n"
                    )
                    .manager(
                            "1) NAS 스토리지 - 설치확인: IT채널부 채널연계팀, 운영담당: IT채널부 채널연계팀\n"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결 \n" +
                            "3) IT시스템운영팀 : 디스크 설치 및 구성의 협조\n"
                    )
                    .attach(
                            "1) 업체별 NAS 스토리지 견적서\n" +
                                    "2)NAS 스토리지 단종관련 공문\n"
                    )
                    // .keywordS("ADW시스템keywords)
                    .build();
            ProjectInfo projectInfo11 = ProjectInfo.builder()
                    .projectId(11)
                    .projectName("인터넷뱅킹 노후 저장장치(스토리지) 교체")
                    .projectType("스토리지")
                    .epmo("김정완")
                    .proposer("김봉관")
                    .keywords("인터넷뱅킹;노후;스토리지;교체")
                    .fullDescription("비대면 채널 거래량이 지속적으로 증가함에 따라 신속하고 안정적인 서비스 제공을 위하여 노후화 된 저장장치(스토리지)를 교체")
                    .backgroundContents(
                            "1) 인터넷뱅킹 In-house* 스토리지 (내부복제用·골드카피用) 노후화로  인한 장애 예방 필요(‘11년 도입, 7년 경과 / 도입비용 769백만원)\n" +
                                    "2) 재해복구 스토리지 EOS(End Of Service) 및 노후화로 인한 장비  교체 필요(‘10년 7월 도입, 8년 경과 / 도입비용 292백만원)\n" +
                                    "3) 비대면 채널 거래량 증가에 따른 운영시스템의 안정성 확보 필요\n"
                    )
                    .currentSituation(
                            "1) 스토리지 장애 발생시 인터넷뱅킹, 스마트뱅킹 등 비대면 채널 전 서비스 지연 및 중단 발생\n" +
                                    "2) 수지IT센터 재해발생시 재해복구센터를 통한 서비스 연속성 유지필요 \n" +
                                    "3) 최근 3년 기준 비대면 채널 거래량은 매년 10%이상 증가%\n"
                    )
                    .contents(
                            "1) In-house 스토리지(내부복제用·골드카피用) 구입\n"+
                                    " - 내부복제용 : VSP G1500, 용량:12TB, Cache Memory:256MB, 디스크정보:15K rpm Disk Drive, Raid-1\n"+
                                    " - 골드카피용 : VSP G1500, 용량:12TB, Cache Memory:256MB, 디스크정보:10K rpm Disk Drive, Raid-5\n"+
                                    "2) In-house 스토리지 ⇨ 재해복구 스토리지 (장비 재활용)\n"+
                                    " - Raid 구성 변경을 통한 스토리지 성능 향상(기존 Raid 5 → Raid 1+0)\n" +
                                    "3) 운영 스토리지 업그레이드(VSP G1000 ⇨ VSP G1500)\n"+
                                    " - VSP G1500 CPU Controller(H/W) 추가 도입을 통하여 기존 운영 스토리지 업그레이드 추진(VSP G1000 ⇨ VSP G1500)\n" +
                                    " - Controller 이중화 구성으로 업무 중단 없이 업그레이드 가능\n" +
                                    " - 스토리지 업그레이드를 통한 기술지원 기간(EOS) 연장 추진\n"
                    )
                    .effectContents(
                            "1) 재활용 대상 장비 대비 IOPS 35%, 폐기 대상 대비 85% 향상\n" +
                                    "2) 재활용 대상 장비 대비 응답속도 2.34배, 폐기 대상 대비 2.24배 향상\n" +
                                    "3) 노후시스템 적기 교체를 통한 사전 장애예방 및 시스템 안정화\n"
                    )
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("IT시스템운영팀")
                    .approvalRight("부서장")
                    .background("노후화")
                    .capitalTotalAmount("495000000")
                    .expenseTotalAmount("")
                    .allTotalAmount("495000000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임\n"+
                            "동일기종(제품)을 납품할 수 있는 업체 간 가격입찰방식으로 추진하고자함"
                    )
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("3개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: 스토리지 VSP G1500 내부복제용 12TB (R-1), 수: 1, 단위: EA, 도입비용: 247500천원, 유지보수요율: 8%\n"+
                            "2) 구분: HW, 품목: 스토리지 VSP G1500 골드카피용 12TB (R-5), 수: 1, 단위: EA, 도입비용: 247500천원, 유지보수요율: 8%\n"+
                            "3) 구분: HW, 품목: 스토리지 G1500 CPU Controller 수: 1, 단위: EA, 도입비용: 무상\n"
                    )
                    .etc(
                            ""
                    )
                    .manager(
                            "1) 스토리지 VSP G1500 내부복제용 12TB (R-1) - 설치확인: IT시스템운영팀 주전산운영팀, 운영담당: IT시스템운영팀 주전산운영팀\n" +
                                    "2) 스토리지 VSP G1500 골드카피용 12TB (R-1) - 설치확인: IT시스템운영팀 주전산운영팀, 운영담당: IT시스템운영팀 주전산운영팀\n" +
                                    "3) 스토리지 G1500 CPU Controller - 설치확인: IT시스템운영팀 주전산운영팀, 운영담당: IT시스템운영팀 주전산운영팀\n"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결 \n" +
                            "3) 정보보호부 : 보안성 검토 및 심의\n"
                    )
                    .attach(
                            "1) IT장비 교체기준 및 기존 저장장치 도입내역\n" +
                                    "2) 기술지원 종료(EOS) 공문\n" +
                                    "3) 재해복구用 스토리지 장애 내역\n" +
                                    "4) 비대면 채널 월별(2015.01~2017.12) 거래량\n" +
                                    "5) 도입모델 지정사유\n" +
                                    "6) RAID 정의\n" +
                                    "7) VSP G1000 모델 업그레이드 공문\n" +
                                    "8) 향후 스토리지 구성 계획(2020년 이후)\n" +
                                    "9) 스토리지 장비 성능 비교표\n" +
                                    "10) 장비 견적 및 유지보수료 비교표\n"
                    )
                    // .keywordS("인터넷뱅킹keywords)
                    .build();
            ProjectInfo projectInfo20 = ProjectInfo.builder()
                    .projectId(20)
                    .projectName("IBK글로벌시스템 디스크 증설")
                    .projectType("디스크")
                    .epmo("송병훈")
                    .proposer("손춘수")
                    .keywords("IBK글로벌시스템;디스크;증설")
                    .fullDescription("")
                    .backgroundContents("1. 국외전산시스템의 정보성 데이터량 증가 및 신규업무 추가 개발로現 디스크 사용율 대비 가용 공간이 부족\n" +
                            "2. 미얀마 법인시스템 신규 구축을 위한 추가 디스크 필요")
                    .currentSituation("1) 디스크 활용 현황\n" +
                            "IBK글로벌시스템 정보계, 보유량 6.5TB, 사용량 5.98TB, 사용율 92%(`20.9월 기준)\n" +
                            "2) 정보계DB 디스크 사용 현황 및 개선 조치 결과(’20.10월말 기준)\n" +
                            " (현 황) 舊 국외전산(ICONS) 대비 현저히 높은 증가량에 따른 디스크 사용량 분석 수행\n" +
                            "(조 치) 과거 및 미사용 데이터 삭제, 테이블 재편성 작업 등 데이터 저장공간 일부 확보\n" +
                            "(결 과) 일평균 DB 증가량은 13GB 수준으로 약 3개월의 가용기간 남음(~’21.1월)\n" +
                            "(개선방안) 업무 프로세스 최적화를 통해 데이터 과다 사용의 근본적인 원인 제거 필요")
                    .contents("1) 물품도입 : 디스크 총 6.3TB\n" +
                            " - 향후 1년간 국외전산 운영에 필요한 디스크 용량 산정(4.0TB)\n" +
                            " - 미얀마 해외법인 별도 데이터베이스 구축(2.3TB)\n" +
                            "2) 도입기종근기 : 現운영중인 스토리지(HPE 3PAR 8450)에 대한 디스크증설이며, 他 기종 호환불가")
                    .effectContents("")
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("IT글로벌개발팀")
                    //.teamLeader("최홍석")
                    //.depLeader("김일두")
                    //.generalLeader("")
                    //.vicePresident("")
                    .approvalRight("부서장")
                    .background("업무증가, 용량부족")
                    .products(
                            "1) 구분: HW, 품목: 디스크증설, [운영] HPE 3PAR 8450 증설[Usable 6.54TB(R-10),3y PC ADV DMR], 수: 1, 단위: EA, 도입비용: 41,140천원, 유지보수요율: 6%")
                    .capitalTotalAmount("41140000")
                    .expenseTotalAmount("0")
                    .allTotalAmount("41140000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임")
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("2개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    // .keywordS("IBK글로벌시스템keywords)
                    .etc("위임전결규정에 의거 부서장 전결")
                    .manager("1) H/W(디스크 증설) - 설치확인:IT글로벌개발팀, 운영담당:IT시스템운영팀(기획품질팀)"
                    )
                    .cooperations("1) 전략기획부 : - 예산합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결 \n" +
                            "3) IT시스템운영팀 : - 시스템 운영"
                    )
                    .attach("1) 시스템 별 증설용량 산정 근기\n"+
                            "2) 비교 견적서	\n"+
                            "3) 단위업무시스템 증설 기준\n")
                    .build();

            ProjectInfo projectInfo21 = ProjectInfo.builder()
                    .projectId(21)
                    .projectName("한국교통대학교 연구비종합관리시스템 디스크 증설")
                    .projectType("디스크")
                    .epmo("권현환")
                    .proposer("정찬욱")
                    .keywords("연구비종합관리시스템;디스크;증설")
                    .fullDescription("")
                    .backgroundContents(
                            "1) 한국교통대학교 산학협력단 연구비종합관리시스템 업무서버(WEB, WAS, DB)의 디스크 가용량 부족으로 증설 필요"
                    )
                    .currentSituation(
                            "업무서버 디스크 사용 현황\n" +
                                    " - C: 드라이브, 용도(OS, DBMS, WEB, WAS, DB백업파일), 총용량(836GB), 사용량(477GB), 사용률(57%), 비고(900GB × 2 RAID 1 구성)\n"+
                                    " - D: 드라이브, 용도(DB운영파일,증빙파일), 총용량(837GB), 사용량(765GB), 사용률(91%), 비고(상동)"
                    )
                    .contents(
                            "디스크 증설(900GB × 2ea, Riad 1)에 따른 증빙파일 전용드라이브(E:) 추가로 가용량 확보\n"+
                                    " - C: 드라이브, 용도(OS, DBMS, WEB, WAS, DB백업파일), 총용량(836GB), 증설前(-), 증설後(-), 비고(재활용)\n"+
                                    " - D: 드라이브, 용도(DB운영파일,증빙파일), 총용량(837GB), 증설前(-), 증설後(-), 비고(재활용)\n" +
                                    " - E: 드라이브, 용도(증빙파일), 총용량(837GB), 증설前(없음), 증설後(836), 비고(신규)"
                    )
                    .effectContents("데이터 저장 여유 공간 확보로 효율적이고 안정적인 시스템 운영")
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("기관고객부")
                    .approvalRight("부서장")
                    .background("여유공간 부족")
                    .capitalTotalAmount("1595000")
                    .expenseTotalAmount("0")
                    .allTotalAmount("1595000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임\n"+
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰"
                    )
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("2개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: Disk, 900GB 15K SAS 12Gb Hot Swap 512e HDD, 수: 2, 단위: EA, 도입비용: 1595천원, 유지보수요율: 대상외"
                    )
                    .etc("※ 증설 대상 서버 : Lenovo SR650\n"+
                            "※ 구축·운영 장소 : 한국교통대학교 산학협력단(충청북도 충주시 대학로 50)")
                    .manager("1) DISK - 설치확인: 기관고객부 기관CMS팀, 한국교통대학교 산학협력단, 운영담당: 기관고객부 기관CMS팀, 한국교통대학교 산학협력단"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의, 기술검토, 계약체결"
                    )
                    .attach("1) 견적서"
                    )
                    // .keywordS("감사정보시스템keywords)
                    .build();

            ProjectInfo projectInfo22 = ProjectInfo.builder()
                    .projectId(22)
                    .projectName("업무포탈 저장장치 증설 및 웹디스크 서비스 업그레이드")
                    .projectType("디스크")
                    .epmo("권현환")
                    .proposer("조연정")
                    .keywords("업무포탈시스템;디스크;웹디스크서비스;대용량파일전송SW;증설")
                    .fullDescription("")
                    .backgroundContents(
                            "1) `20.2분기 업무포탈 저장장치 사용률이 90%를 초과할 것으로 예상되어 안정적인 시스템 운영을 위한 저장장치 증설 필요\n"+
                                    "2)  업무포탈 內 웹디스크 사용증가에 따른 서비스 개선 필요\n"+
                                    " - 업무 공유 및 보관을 위한 웹디스크 용량 증설 요청 증가\n"+
                                    " - 폴더단위 업로드 기능 및 업로드 최대용량 증대 등 사용자 요구사항 대응"
                    )
                    .currentSituation(
                            "업무포탈 저장장치 사용량 추이(Ontune기준, 단위: GB)\n" +
                                    " `18상반기, 총용량(5,637), 사용량(3,734), 잔량(1,903), 증가량(434), 사용률(66%)\n" +
                                    " `18하반기, 총용량(5,637), 사용량(4,174), 잔량(1,463), 증가량(440), 사용률(74%)\n" +
                                    " `19상반기, 총용량(5,637), 사용량(4,409), 잔량(1,228), 증가량(235), 사용률(78%)\n" +
                                    " `19하반기, 총용량(5,981*), 사용량(5,155), 잔량(826), 증가량(746), 사용률(87%)\n" +
                                    " `20.1분기, 총용량(6,196), 사용량(5,485), 잔량(711), 증가량(330), 사용률(89%)\n" +
                                    " `20.2분기(예상), 총용량(6,196), 사용량(5,723), 잔량(473), 증가량(238), 사용률(92%)" +
                                    " * 통합 스토리지 가용량에서 350GB (2019.11), 200GB (2020.02) 증설"
                    )
                    .contents(
                            "1) 업무포탈 저장장치 용량 증설\n"+
                                    " - 운영, VSP G400(SerialNo. 414119), 증설용량(Usable 3.1TB), 증설前(6TB), 증설後(9TB), 비고(Raid-1)\n"+
                                    " - 재해복구(DR), VSP G400(SerialNo. 414118), 증설용량(Usable 3.1TB), 증설前(6TB), 증설後(9TB), 비고(Raid-5)\n" +
                                    "2) 웹디스크 대용량 파일전송 SW 버전 업그레이드(Innorix 7.2→9.2)\n" +
                                    " - 폴더단위 업로드, 첨부순서 변경 등 신규 기능 제공\n"+
                                    " - 파일 전송현황 실시간 모니터링 가능"
                    )
                    .effectContents("")
                    .contractMethodContents("IBK시스템에 계약위임\n" +
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰")
                    .department("IT정보부")
                    .approvalRight("부서장")
                    .background("업무증가")
                    .capitalTotalAmount("76120000")
                    .expenseTotalAmount("0")
                    .allTotalAmount("76120000")
                    //                   .products(products1)
                    .selectionMethod("IBK시스템에 위임\n"+
                            "동일기종을 납품할수 있는 업체간 가격경쟁입찰"
                    )
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("2개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: 저장장치, [업무포탈 운영]VSP G400 증설용 DISK Usable 3.1TB, 수: 1, 단위: EA, 도입비용: 35,420천원, 유지보수요율: 8%\n"+
                                    "2) 구분: HW, 품목: 저장장치, [업무포탈 재해복구(DR)]VSP G400 증설용 DISK Usable 3.1TB, 수: 1, 단위: EA, 도입비용: 14,300천원, 유지보수요율: 8%\n"+
                                    "3) 구분: SW, 품목: 대용량파일전송,INNORIX WP Standard License v9.2, 수: 1, 단위: COPY, 도입비용: 21,120천원, 유지보수요율: -\n"+
                                    "4) 구분: SW, 품목: 대용량파일전송,INNORIX MRT Standard License, 수: 1, 단위: COPY, 도입비용: 5,280천원, 유지보수요율: -"
                    )
                    .etc("")
                    .manager("1) HW 저장장치 - 설치확인: IT시스템운영팀 주전산운영팀, 운영담당: IT시스템운영팀 주전산운영팀\n"+
                            "2) SW 대용량파일전송, - 설치확인 : IT정보부 경영정보팀, 운영담당: IT정보부 경영정보팀"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결\n"+
                            "3) IT시스템운영팀 : 저장장치 증설 지원"
                    )
                    .attach("1) 단위업무시스템 용량 증설 기준\n"+
                            "2) 업무포탈 저장장치 사용량 및 증설 근기\n"+
                            "3) 견적 비교표 "
                    )
                    // .keywordS("감사정보시스템keywords)
                    .build();

            ProjectInfo projectInfo23 = ProjectInfo.builder()
                    .projectId(23)
                    .projectName("패치관리시스템 디스크 증설")
                    .projectType("디스크")
                    .epmo("박현조")
                    .proposer("김태우")
                    .keywords("패치관리시스템;디스크;증설")
                    .fullDescription("")
                    .backgroundContents(
                            "1) 패치관리시스템 디스크 용량 부족으로 보안업데이트 업무 장애위험\n"+
                                    " - ’19.10월 디스크 사용량 임계치 초과 예상되어 가용성 확보 필요\n"+
                                    "<패치관리시스템 디스크 사용현황>(`19년 9월기준)\n"+
                                    " 총용량(849GB), 사용용량(754GB), 사용비율(89%), 월평균 증가량(20~25GB)\n"+
                                    "2)  Windows 운영체제 전환에 따라 보안업데이트 추가 적재 필요\n"+
                                    " - Windows 7→10 전환, Windows Server 2008→2016 전환 등\n"+
                                    "3)  패치관리시스템 디스크 증설을 통해 보안업데이트 업무 안정성 확보\n"+
                                    " - 악성코드 등 보안리스크 대응"
                    )
                    .currentSituation(
                            "최근 6개월간 패치관리시스템 디스크 사용 현황\n" +
                                    " - 패치관리시스템 디스크 총용량 : 849GB\n" +
                                    " - IT시스템운영팀 권고 디스크 사용량 임계치 : 90%\n" +
                                    " - 월평균 사용량 : 20 GB (약 2%↑)\n" +
                                    " `19하반기, 총용량(5,981*), 사용량(5,155), 잔량(826), 증가량(746), 사용률(87%)\n" +
                                    " `20.1분기, 총용량(6,196), 사용량(5,485), 잔량(711), 증가량(330), 사용률(89%)\n" +
                                    " `20.2분기(예상), 총용량(6,196), 사용량(5,723), 잔량(473), 증가량(238), 사용률(92%)" +
                                    " * 통합 스토리지 가용량에서 350GB (2019.11), 200GB (2020.02) 증설"
                    )
                    .contents(
                            "1) 패치관리시스템 디스크 2TB 증설\n"+
                                    " - 향후 3년간 패치관리시스템 운영 시 필요한 디스크 용량 산정)\n"+
                                    " - 스토리지 구성 최소단위에 따라 증설용량 산정\n" +
                                    "2) 현재 운영 중인 기종의 스토리지의 증설\n" +
                                    " - 통합서버에서 사용하는 스토리지는 해당제품이 유일\n"+
                                    " - 제조사 : EMC, 모델명 : VNX5800(CKM00142101241), 도입년도 : 2014.10., AS-IS : 849GB, To-Be : 2.8TB, 비고 : EOS미정\n" +
                                    "3) 디스크 증설 용량 산출근기\n" +
                                    " - 매월 적재되는 보안업데이트별 패치내용이 달라 누적하여 보관 필요\n"+
                                    " - 운영체제 전환 작업이 완전히 이루어진 후 기술지원 종료된 운영체제의 보안업데이트는 삭제 예정\n" +
                                    " 기존) `19년 9월까지 누적 보안 업데이트,주기(-), 사용량(754GB)\n" +
                                    " 기존) 정기 보안 업데이트,주기(매월), 사용량(900GB=25*36개월)\n" +
                                    " 신규*) 초기 적재 보안 업데이트,주기(최초1회), 사용량(754GB)\n" +
                                    " 신규) 정기 보안 업데이트,주기(매월), 사용량(360GB=10*36개월)\n" +
                                    " 합계, 사용량(2,514GB)\n" +
                                    " * 운영체제 전환(Win10, Server 2016)으로 보안업데이트 추가"
                    )
                    .effectContents("")
                    .contractMethodContents("(주)IBK시스템에 업체선정 및 계약위임\n" +
                            "동일기종(제품) 간 가격입찰")
                    .department("IT채널부")
                    .approvalRight("부서장")
                    .background("용량부족")
                    .capitalTotalAmount("13684000")
                    .expenseTotalAmount("0")
                    .allTotalAmount("13684000")
                    //                   .products(products1)
                    .selectionMethod("(주)IBK시스템에 업체선정 및 계약위임\n" +
                            "동일기종(제품) 간 가격입찰")
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("3개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: 스토리지 부속, VNX5800 U2TB UPG, 수: 1, 단위: EA, 도입비용: 13,684천원, 유지보수요율: 8%"
                    )
                    .etc("")
                    .manager("1) HW 스토리지부속 - 설치확인:IT채널부 채널연계팀, 운영담당: IT시스템운영팀 주전산운영팀"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결\n"+
                            "3) IT시스템운영팀 : 디스크 설치 지원 및 운영"
                    )
                    .attach("1) 패치관리시스템 디스크 사용 현황\n"+
                            "2) 보안업데이트 파일 목록\n"+
                            "3) 비교 견적서\n"+
                            "4) 단위업무시스템 증설 기준"
                    )
                    // .keywordS("감사정보시스템keywords)
                    .build();

            ProjectInfo projectInfo24 = ProjectInfo.builder()
                    .projectId(24)
                    .projectName("고객상담녹취시스템 NAS서버 디스크 교체")
                    .projectType("디스크")
                    .epmo("송병훈")
                    .proposer("정지원")
                    .keywords("고객상담녹취시스템; 디스크; 증설")
                    .fullDescription("")
                    .backgroundContents(
                            "1) 고객상담 녹취시스템 NAS서버에 디스크(2EA) 폴트가 발생하여 디스크 교체가 필요한 상황임."
                    )
                    .currentSituation(
                            "고객상담 녹취시스템 NAS서버에 디스크(2EA) 폴트가 발생"
                    )
                    .contents(
                            "녹취 시스템 전체 구성도"
                    )
                    .effectContents("")
                    .contractMethodContents("(주)IBK시스템에 업체선정 및 계약위임")
                    .department("IT채널부")
                    .approvalRight("부서장")
                    .background("디스크폴트")
                    .capitalTotalAmount("1980000")
                    .expenseTotalAmount("0")
                    .allTotalAmount("1980000")
                    //                   .products(products1)
                    .selectionMethod("(주)IBK시스템에 업체선정 및 계약위임")
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("2개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: 디스크(씨게이트 600G SAS), 수: 2, 단위: EA, 도입비용: 1,980천원, 유지보수요율: -"
                    )
                    .etc("")
                    .manager("1) HW 디스크 씨게이트 600G SAS - 설치확인:IT채널부 채널연계팀, 운영담당:IT채널부 채널연계팀"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결"
                    )
                    .attach("1) 견적서 1부"
                    )
                    // .keywordS("감사정보시스템keywords)
                    .build();

            ProjectInfo projectInfo25 = ProjectInfo.builder()
                    .projectId(25)
                    .projectName("신용카드수익관리 시스템 디스크 증설")
                    .projectType("디스크")
                    .epmo("송병훈")
                    .proposer("정재웅")
                    .keywords("신용카드수익관리시스템;디스크;증설")
                    .fullDescription("")
                    .backgroundContents(
                            "1) ’19년 재구축한 카드수익관리시스템 디스크 소진율이 당초 예상보다 높아 향후 15개월 내 디스크 저장 공간 소진 예상\n"+
                                    "    - 디스크 사용은 월평균 880GB로 향후 15개월 내 모두 소진 예상"
                    )
                    .currentSituation(
                            "월별 데이터 사용 현황\n" +
                                    " 총할당량(33,371GB)\n" +
                                    " 사용량 : 3월(1,597GB), 4월(2,891GB), 5월(△943GB), 6월(2,229GB), 7월(△753GB), 8월(1,081GB), 9월(31GB)\n" +
                                    " 사용량 : 3월(47.88%), 4월(55.07%), 5월(52.24%), 6월(58.93%), 7월(56.67%), 8월(59.91%), 9월(59.99%)"
                    )
                    .contents(
                            "(도입내역) 향후 2년간 안정적 운영을 위해 약 10TB* 증설 필요\n"+
                                    "- 기종: 現운영 중인 스토리지(Hitachi VSP-F400)로 他제품 도입 시   호환성 및 유지보수, 장애 대응 불가에 따라 동일 제조사 제품 증설\n" +
                                    "-  용량: 과거 추이 및 데이터 순증 고려하여 약 10TB 증설"
                    )
                    .effectContents("디스크 여유 공간 확보로 안정적인 시스템 운영 가능\n"+
                            "-  배치 작업 적시 수행으로 종합수익관리시스템, ADW시스템 등 데이터 적기 제공\n" +
                            "- 최근 5년 데이터 보관에 따른 업무 보고서 제공용이"
                    )
                    .contractMethodContents("(주)IBK시스템에 업체선정 및 계약위임\n" +
                            "동일기종(제품)을 납품할 수 있는 업체 간 가격 경쟁 입찰")
                    .department("카드사업부")
                    .approvalRight("부서장")
                    .background("용량부족")
                    .capitalTotalAmount("126500000")
                    .expenseTotalAmount("0")
                    .allTotalAmount("126500000")
                    //                   .products(products1)
                    .selectionMethod("(주)IBK시스템에 업체선정 및 계약위임\n" +
                            "동일기종(제품)을 납품할 수 있는 업체 간 가격 경쟁 입찰")
                    .emergency("N")
                    .emergencyBackground("대상외")
                    .duration("2개월")
                    //                 .cooperations(cops)
                    .step("완료")
                    .products(
                            "1) 구분: HW, 품목: Hitachi VSP-F400 증설용 DISK (U10TB)*, 수: 1, 단위: EA, 도입비용: 126,500천원, 유지보수요율: 6%\n"+
                                    "* 기종은 기존에 사용 중인 Hitachi VSP-F400(SSD)으로 선택하였으며, 동일 서버內      다른 기종의 디스크를 사용하는 것은 장애발생 요인으로 비권장 사항임"
                    )
                    .etc("")
                    .manager("1) HW 스토리지 Hitachi VSP-F400, - 설치확인:IT시스템운영팀(기획품질팀), 운영담당:IT시스템운영팀(기획품질팀)"
                    )
                    .cooperations("1) 전략기획부 : 예산합의 및 배정 \n"+
                            "2) IT기획부 : IT예산합의 및 계약체결\n"+
                            "3) IT시스템운영팀 : 디스크 설치 확인 및 운영"
                    )
                    .attach("1) 카드수익관리시스템 구성도\n"+
                            "2) 추가 디스크 필요수량 산출 근거\n"+
                            "3) 도입자원 견적서 각 3부"
                    )
                    // .keywordS("감사정보시스템keywords)
                    .build();
            Thread.sleep(1000);
            logger.info("insert 5 ");

            projectInfoRepository.deleteAll();
            projectInfoRepository.save(projectInfo1);
            projectInfoRepository.save(projectInfo2);
            projectInfoRepository.save(projectInfo3);
            projectInfoRepository.save(projectInfo4);
            projectInfoRepository.save(projectInfo5);
            projectInfoRepository.save(projectInfo6);
            projectInfoRepository.save(projectInfo7);
            projectInfoRepository.save(projectInfo8);
            projectInfoRepository.save(projectInfo9);
            projectInfoRepository.save(projectInfo10);
            projectInfoRepository.save(projectInfo11);

            projectInfoRepository.save(projectInfo20);
            projectInfoRepository.save(projectInfo21);
            projectInfoRepository.save(projectInfo22);
            projectInfoRepository.save(projectInfo23);
            projectInfoRepository.save(projectInfo24);
            projectInfoRepository.save(projectInfo25);

            //  projectInfoRepository.save(projectInfo3);
         //   projectInfoRepository.save(projectInfo4);


//            SimProjectInfo simprojectInfo1 = new SimProjectInfo(1,2,3,"마이데이터 시스템구축","개발비, 서버, 스토리지, WAS, 온튠",4007000L,"60%");
//            SimProjectInfo simprojectInfo2 = new SimProjectInfo(2,2,4,"오픈API 시스템 구축","개발비, 서버, 스토리지, API GW",2707000L,"50%");
            Thread.sleep(1000);
            logger.info("insert 6 ");

 //           simProjectInfoRepository.save(simprojectInfo1);
 //           simProjectInfoRepository.save(simprojectInfo2);


            IssueInfo issueInfo1 = new IssueInfo(1,1,"회선설치비 확인","회선 설치비 관련해서 별도 견적을 포함하거나 견적내 에 포함 필요","EPMO(AI)","김동수","비용","2021-10-04","완료");
            IssueInfo issueInfo2 = new IssueInfo(2,1,"운영관련 협의","통합스토리지 관련 운영협의: 스토리지팀에서 운영(김동수)","추천","김동수","운영","2021-10-04","완료");
            IssueInfo issueInfo3 = new IssueInfo(3,1,"랙 도입 검토","랙 도입 검토: 금차 도입","EPMO(AI)","김동수","비용","2021-10-04","진행중");
            IssueInfo issueInfo4 = new IssueInfo(3,1,"기능점수 작성","기능점수 작성가이드 참조 ","EPMO(AI)","김동수","비용","2021-10-04","진행중");

            CheckInfo checkInfo1 = new CheckInfo(1,"박현조","판로지원법 검토","판로지원법 적용여부 검토",1,"2021-09-29","EPMO(AI)","EPMO(AI)","완료");
            CheckInfo checkInfo2 = new CheckInfo(2,"박현조","용량 산정","용량산정근거",1,"2021-09-30","EPMO(AI)","정보부","완료");

            CompanyInfo companyInfo1 = new CompanyInfo(1,"디리아","중소기업","배현기","2000년 5월 20일","시스템 소프트웨어 개발 및 공급 업체","50억~100억","40명~70명",2);
            CompanyInfo companyInfo2 = new CompanyInfo(2,"모코엠시스","중소기업","고재현,조천희","2007년 9월 14일","응용 소프트웨어 개발 및 공급업","282억","124명",2);
            CompanyInfo companyInfo3 = new CompanyInfo(3,"베스핀글로벌","중소기업","이해민,이존한주","2015년 10월 19일","컴퓨터시스템 통합자문 및 구축서비스","1600억","557명",2);

            CompanyNewsInfo companyNewsInfo1_1 = new CompanyNewsInfo(1,1,"디리아","디리아, 글로벌 금융IT시장 강화…동남아사업 순항, CI 개편","전문기업인 디리아(대표 배현기)가 글로벌 금융IT 시장 진출을 본격화한다. 특히 디리아는 올해 베트남 우리은행 펌뱅킹 시스템 구축 프로젝트 및 캄보디아 지급결제시스템 ");
            CompanyNewsInfo companyNewsInfo1_2 = new CompanyNewsInfo(2,1,"디리아","디리아, 2014 우수벤처기업 채용박람회 참가","[아이티데일리] 디리아(대표 배현기)는 지난 6월 26일 세텍(SETEC)에서 열린 '2014 우수벤처기업 채용박람회'에... 중소기업청이 주최하고 벤처기업협회에서 주관한 이번 행사에 디리아는 선도벤처기업으로 참가해...");
            CompanyNewsInfo companyNewsInfo1_3 = new CompanyNewsInfo(3,1,"디리아","디리아, 부산은행 차세대에 대내/외 채널솔루션 공급","금융권 대외계ㆍ 채널솔루션 전문 업체인 디리아는 제 1금융권의 마지막 남은 차세대 프로젝트로 관심을... 디리아는 부산은행 내부 통합단말, 자동화기기, 전자금융, 폰뱅킹 ");

            CompanyNewsInfo companyNewsInfo2_1 = new CompanyNewsInfo(4,2,"모코엠시스",
                    "모코엠시스, 개인정보 검출 솔루션 국내 금융지주 계열사 구축 완료",
                    "모코엠시스 직원들이 보안솔루션 엠파워를 소개하고 있다. 박지호기자 jihopress@etnews.com 모코엠시스(대표 김인수)는 서버용 개인정보 검출 솔루션 엠파워 에스-필터(Mpower S-Filter)`를 국내 금융지주 계열사 2곳에...");
            CompanyNewsInfo companyNewsInfo2_2 = new CompanyNewsInfo(5,2,"모코엠시스","브랜드우수-모코엠시스, 문서중앙화 솔루션 ‘엠파워이지스-씨...",
                    "모코엠시스(대표 김인수) 문서중앙화 솔루션 ‘엠파워이지스-씨(MpowerEZis-C)’가 하반기 브랜드우수 상품으로 선정됐다. 이 솔루션은 기업 보안을 극대화하고 동시에 효율적 협업 체계 구축을 지원한다. 모코엠시스...");
            CompanyNewsInfo companyNewsInfo2_3 = new CompanyNewsInfo(6,2,"모코엠시스","모코엠시스, ‘엠파워 클라우드’ GS인증 1등급 획득",
                    "TTA 소프트웨어 시험인증연구소로부터 GS인증 1등급 획득클라우드 저장소에 자료 저장·통합·보안·협업 가능한 솔루션[보안뉴스 원병철 기자] 보안솔루션 전문기업 모코엠시스(대표 김인수)는 클라우드 저장소 솔루션...");

            CompanyNewsInfo companyNewsInfo3_1 = new CompanyNewsInfo(7,3,"베스핀글로벌","[인터뷰] 베스핀글로벌, \"한국 넘어 글로벌 SaaS 시장 노린다",
                    "정부의 SOS 요청을 받고 모인 베스핀글로벌을 비롯한 네이버·카카오·LG CNS 등의 민간기업들은 7월 22일 과학기술정보통신부 차관 주재로 열린 민관 합동 회의에 참여해 백신 접종 사전 예약 시스템 정상화에 나섰다....");
            CompanyNewsInfo companyNewsInfo3_2 = new CompanyNewsInfo(8,3,"베스핀글로벌","베스핀글로벌, 日 클라우드 시장 공략 시동… 현지 합작사 설립"
                    ,"클라우드 MSP(관리형서비스제공사) 베스핀글로벌이 일본 클라우드 시장 공략에 나선다. 20일 베스핀글로벌은 일본 클라우드통합(CI)기업 서버웍스와 구글 클라우드 플랫폼(GCP) 전문사 ‘지젠(G-gen)’을 합작 설립했다고...");
            CompanyNewsInfo companyNewsInfo3_3 = new CompanyNewsInfo(9,3,"베스핀글로벌","백신예약시스템, 베스핀글로벌이 클라우드로 구축",
                    "베스핀글로벌은 2주 만에 코로나19 예방접종 사전예약시스템의 핵심문제 구간을 민간클라우드로 전환하고 안정적으로 운영하는데 성공했다고 12일 밝혔다. TF팀은 백신사전예약시스템의 원활한 운영을 위해 기존... ");
            companyNewsInfoRepository.save(companyNewsInfo1_1);
            companyNewsInfoRepository.save(companyNewsInfo1_2);
            companyNewsInfoRepository.save(companyNewsInfo1_3);
            companyNewsInfoRepository.save(companyNewsInfo2_1);
            companyNewsInfoRepository.save(companyNewsInfo2_2);
            companyNewsInfoRepository.save(companyNewsInfo2_3);
            companyNewsInfoRepository.save(companyNewsInfo3_1);
            companyNewsInfoRepository.save(companyNewsInfo3_2);
            companyNewsInfoRepository.save(companyNewsInfo3_3);

            issueInfoRepository.save(issueInfo1);
            issueInfoRepository.save(issueInfo2);
            issueInfoRepository.save(issueInfo3);
            issueInfoRepository.save(issueInfo4);


            checkInfoRepository.save(checkInfo1);
            checkInfoRepository.save(checkInfo2);




            FunctionPointInfo functionPointInfo1 = new FunctionPointInfo(1,"공공마이데이터 구축",2,"사용자 정보","ILF","공공마이데이터"," 사용자 관리","","2021-10-11");
            FunctionPointInfo functionPointInfo2 = new FunctionPointInfo(2,"공공마이데이터 구축",2,"사용자 정보 입력","EI","공공마이데이터","사용자 관리","","2021-10-11");
            FunctionPointInfo functionPointInfo3 = new FunctionPointInfo(3,"공공마이데이터 구축",2,"사용자 정보 수정/삭제","EI","공공마이데이터","사용자 관리","","2021-10-11");
            FunctionPointInfo functionPointInfo4 = new FunctionPointInfo(4,"공공마이데이터 구축",2,"사용자 조회","EQ","공공마이데이터","사용자 관리","","2021-10-11");
            FunctionPointInfo functionPointInfo5 = new FunctionPointInfo(5,"공공마이데이터 구축",2,"사용자 출력","EO","공공마이데이터","사용자 관리","","2021-10-11");

            companyInfoRepository.save(companyInfo1);
            companyInfoRepository.save(companyInfo2);
            companyInfoRepository.save(companyInfo3);


            functionPointInfoRepository.save(functionPointInfo1);
            functionPointInfoRepository.save(functionPointInfo2);
            functionPointInfoRepository.save(functionPointInfo3);
            functionPointInfoRepository.save(functionPointInfo4);
            functionPointInfoRepository.save(functionPointInfo5);


            questionInfoRepository.save(questionInfo1);
            questionInfoRepository.save(questionInfo2);
            questionInfoRepository.save(questionInfo3);
            questionInfoRepository.save(questionInfo4);
            questionInfoRepository.save(questionInfo5);
            questionInfoRepository.save(questionInfo6);
        };
    }
}
