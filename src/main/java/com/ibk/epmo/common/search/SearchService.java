package com.ibk.epmo.common.search;

import org.apache.http.HttpHost;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {
	
	private Logger logger = LoggerFactory.getLogger(SearchService.class);
	private Map<Integer, Float> searchProjectResultMap = new HashMap<Integer, Float>();

	RestHighLevelClient client;
	public SearchService(){
//		client = new RestHighLevelClient((RestClient.builder(
//				new HttpHost("search-luelsearch-kr3evqjalvekurflhglijdbgmm.us-east-1.es.amazonaws.com",443,"https"))));

//		client = new RestHighLevelClient((RestClient.builder(
//				new HttpHost("search-epmosearch-i6h5bimjjrrbale3dwtcqqcbeq.us-east-1.es.amazonaws.com",443,"https"))));

//		search-epmosearch-i6h5bimjjrrbale3dwtcqqcbeq.us-east-1.es.amazonaws.com
//		HttpHost.create("https://search-luelsearch-es-l6atdaxzimvtbcf3udf54ajm2a.ap-northeast-2.es.amazonaws.com"))));
		client = new RestHighLevelClient(
				RestClient.builder(
						new HttpHost("localhost", 9200, "http")));
	}
//9200
//	public List<SearchResult> Search(String keyword){
//		List<SearchResult> SearchResultList = new ArrayList<SearchResult>() ;
////		SearchRequest searchRequest = new SearchRequest("step_info");
////		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//		//BoolQueryBuilder query = new BoolQueryBuilder();
//		//query.must(QueryBuilders.wildcardQuery("title", "*판로*").boost(5));
//		//query.must(QueryBuilders.wildcardQuery("guideContents", "*판로*").boost(5));
//		//SearchRequest searchRequest =
//		//		null;
//		try {
//
//				SearchRequest	searchRequest = new SearchRequest("step_info")
//					.source(new SearchSourceBuilder(
//							// QueryBuilders 추가 가능
//							QueryBuilders.boolQuery()
//									.should(QueryBuilders.wildcardQuery("title", "*판로*"))
//					));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//String[] includeFields = new String[] {"title", "guideContents"};
//		//String[] excludeFields = new String[] {"user"};
//		//sourceBuilder.fetchSource(includeFields,excludeFields);
//		sourceBuilder.query(QueryBuilders.wildcardQuery("title", "*판로*"));
//
//		//sourceBuilder.query(query);
//		sourceBuilder.from(0);
//		sourceBuilder.size(10);
//
//		//sourceBuilder.from(0);
//		//sourceBuilder.size(5);
//		sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//		searchRequest.source(sourceBuilder);
//		try {
//			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//			List <Map<String, Object>> arrList = new ArrayList<>();
//			SearchHits hits = searchResponse.getHits();
//			TotalHits totalHits = hits.getTotalHits();
//			long numHits = totalHits.value;
//			TotalHits.Relation relation = totalHits.relation;
//			float maxScore = hits.getMaxScore();
//			System.out.println("개수:"+numHits);
//			SearchHit[] searchHits = hits.getHits();
//			for (SearchHit hit : searchHits) {
//				// do something with the SearchHit
//				String sourceAsString = hit.getSourceAsString();
//				Map<String, Object> sourceAsMap = hit.getSourceAsMap();
//				hit.getScore();
//				String documentTitle = (String) sourceAsMap.get("title");
//				System.out.println("title"+documentTitle);
//
//			}
//
//
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return SearchResultList;
//		//	return checkInfoList;
//	}


//public

public List<SearchProjectResult> searchProject(String keyword){

		logger.info("search Project start");
	List<SearchProjectResult> searchProjectResultList = new ArrayList<SearchProjectResult>() ;
	//Map<Integer, SearchProjectResult> searchProjectResultMap = new HashMap<Integer, SearchProjectResult>();

	MultiSearchRequest requests = new MultiSearchRequest();
	SearchRequest searchRequest = new SearchRequest("project_info");

	SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
	BoolQueryBuilder query = new BoolQueryBuilder();
	logger.info("search start 2"+keyword);


	query.should(QueryBuilders.wildcardQuery("projectName", "*"+keyword+"*").boost(5));
	query.should(QueryBuilders.wildcardQuery("projectType", "*"+keyword+"*").boost(5));
	query.should(QueryBuilders.wildcardQuery("epmo", "*"+keyword+"*").boost(1));
	query.should(QueryBuilders.wildcardQuery("proposer", "*"+keyword+"*").boost(1));
	query.should(QueryBuilders.wildcardQuery("keywords", "*"+keyword+"*").boost(10));
	query.should(QueryBuilders.wildcardQuery("fullDescription", "*"+keyword+"*").boost(3));
	query.should(QueryBuilders.wildcardQuery("backgroundContents", "*"+keyword+"*").boost(3));
	query.should(QueryBuilders.wildcardQuery("currentSituation", "*"+keyword+"*").boost(3));

	query.should(QueryBuilders.wildcardQuery("contents", "*"+keyword+"*").boost(3));
	query.should(QueryBuilders.wildcardQuery("effectContents", "*"+keyword+"*").boost(3));
	query.should(QueryBuilders.wildcardQuery("contractMethodContents", "*"+keyword+"*").boost(3));
	query.should(QueryBuilders.wildcardQuery("department", "*"+keyword+"*").boost(1));
	query.should(QueryBuilders.wildcardQuery("approvalRight", "*"+keyword+"*").boost(1));
	query.should(QueryBuilders.wildcardQuery("background", "*"+keyword+"*").boost(3));
	query.should(QueryBuilders.wildcardQuery("selectionMethod", "*"+keyword+"*").boost(1));
	query.should(QueryBuilders.wildcardQuery("emergencyBackground", "*"+keyword+"*").boost(1));
	query.should(QueryBuilders.wildcardQuery("products", "*"+keyword+"*").boost(10));

	query.should(QueryBuilders.wildcardQuery("manager", "*"+keyword+"*").boost(3));
	query.should(QueryBuilders.wildcardQuery("cooperations", "*"+keyword+"*").boost(3));
	query.should(QueryBuilders.wildcardQuery("etc", "*"+keyword+"*").boost(1));
	query.should(QueryBuilders.wildcardQuery("attach", "*"+keyword+"*").boost(3));
//	query.should(QueryBuilders.wildcardQuery("backgroundContents", "*"+keyword+"*").boost(1));

	//검색 대상 확대
	sourceBuilder.query(query);
	sourceBuilder.from(0);
	sourceBuilder.size(3);
	searchRequest.source(sourceBuilder);
	logger.info("search start 3");
	///
	try {
		SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		logger.info("search start 4");

		SearchHits hits = searchResponse.getHits();
		TotalHits totalHits = hits.getTotalHits();
		logger.info("search start 5");

		long numHits = totalHits.value;
		logger.info("검색 결과: "+numHits+"개");
		for(SearchHit s:searchResponse.getHits().getHits())
		{

			Map<String, Object> sourceMap = s.getSourceAsMap();
			Integer projectId = (Integer)sourceMap.get("projectId");
			String projectName = (String) sourceMap.get("projectName");
			String contents = (String) sourceMap.get("backgroundContents");
			String updatedDate = (String) sourceMap.get("updatedDate");
			String type = "PROJECT";
			float score = s.getScore();
			logger.info("ProjectId="+projectId+",projectName:"+projectName);
			//searchProjectResultMap.put(projectId,)
			SearchProjectResult searchProjectResult = SearchProjectResult.builder()
					.projectId(projectId)
					.projectName(projectName)
					.contents(contents)
					.updatedDate(updatedDate)
					.score(score)
					.type(type)
					.build();
					//new SearchResult(title,contents,type,updatedDate,score);
			searchProjectResultList.add(searchProjectResult);
			logger.info("==="+s.getScore()+s.getSourceAsMap().get("title"));
		}
		//return arrList;
	} catch (IOException e) {
		logger.error("Elastic search fail"+e);
	}
	return searchProjectResultList;
	//	return checkInfoList;
}

	public List<SearchGuideResult> searchGuide(String keyword){
		logger.info("search Guide start");

		List<SearchGuideResult> searchGuideResultList = new ArrayList<SearchGuideResult>() ;
		MultiSearchRequest requests = new MultiSearchRequest();
		SearchRequest searchRequest = new SearchRequest("guide_info");

		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		BoolQueryBuilder query = new BoolQueryBuilder();
		logger.info("search Guide[keyword]:"+keyword);


		query.should(QueryBuilders.wildcardQuery("title", "*"+keyword+"*").boost(5));
		query.should(QueryBuilders.wildcardQuery("guideContents", "*"+keyword+"*").boost(5));
		query.should(QueryBuilders.wildcardQuery("guideType", "*"+keyword+"*").boost(5));

		//검색 대상 확대
		sourceBuilder.query(query);
		sourceBuilder.from(0);
		sourceBuilder.size(3);
		searchRequest.source(sourceBuilder);

		logger.info("search start 3");
		///
		try {
			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
			logger.info("search start 4");

			SearchHits hits = searchResponse.getHits();
			TotalHits totalHits = hits.getTotalHits();
			logger.info("search start 5");

			long numHits = totalHits.value;
			logger.info("검색 결과: "+numHits+"개");
			for(SearchHit s:searchResponse.getHits().getHits())
			{

				Map<String, Object> sourceMap = s.getSourceAsMap();
				Integer guideId = (Integer)sourceMap.get("guideId");
				String title = (String) sourceMap.get("title");
				String guideContents = (String) sourceMap.get("guideContents");
				String guideType = (String) sourceMap.get("guideType");
				String step = (String) sourceMap.get("step");
				float score = s.getScore();
				logger.info("guideId="+guideId+",title:"+title);
				//searchProjectResultMap.put(projectId,)
				SearchGuideResult searchGuideResult = SearchGuideResult.builder()
						.guideId(guideId)
						.title(title)
						.guideContents(guideContents)
						.guideType(guideType)
						.score(score)
						.step(step)
						.build();
				//new SearchResult(title,contents,type,updatedDate,score);
				searchGuideResultList.add(searchGuideResult);
				logger.info("==="+s.getScore()+s.getSourceAsMap().get("title"));
			}
			//return arrList;
		} catch (IOException e) {
			logger.error("Elastic Guide search fail"+e);
		}
		return searchGuideResultList;
		//	return checkInfoList;
	}



//	public List<SearchResult> search(String keyword){
//		logger.info("search start");
//		List<SearchProjectResult> searchResultList = new ArrayList<SearchProjectResult>() ;
////	SearchResult searchResult = new SearchResult();
//		MultiSearchRequest requests = new MultiSearchRequest();
//		//SearchRequest searchRequest = new SearchRequest("step_info");
//		SearchRequest searchRequest = new SearchRequest("project_info");
//
//		//project_info
//		//SearchRequest searchRequest2 = new SearchRequest("issue_info");
//
//		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//		BoolQueryBuilder query = new BoolQueryBuilder();
//		//sourceBuilder.query(QueryBuilders.wildcardQuery("title", "*필요*"));
//		logger.info("search start 2"+keyword);
//
//		//query.should(QueryBuilders.wildcardQuery("title", "*"+keyword+"*").boost(5));
//		//query.should(QueryBuilders.wildcardQuery("guideContents", "*"+keyword+"*").boost(1));
//
//		query.should(QueryBuilders.wildcardQuery("projectName", "*"+keyword+"*").boost(5));
//		query.should(QueryBuilders.wildcardQuery("backgroundContents", "*"+keyword+"*").boost(1));
//
//
//		sourceBuilder.query(query);
//		//sourceBuilder.query(query);
//		logger.info("search start 2");
//
////	sourceBuilder.query(QueryBuilders.wildcardQuery("title", "*판로*"));
//		sourceBuilder.from(0);
//		sourceBuilder.size(10);
//		searchRequest.source(sourceBuilder);
//		logger.info("search start 3");
//		///
//		try {
//			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//			logger.info("search start 4");
//
//			List <Map<String, Object>> arrList = new ArrayList<>();
//			SearchHits hits = searchResponse.getHits();
//			TotalHits totalHits = hits.getTotalHits();
//			logger.info("search start 5");
//
//			long numHits = totalHits.value;
//			System.out.println("개수:"+numHits);
//			for(SearchHit s:searchResponse.getHits().getHits())
//			{
//
//				Map<String, Object>
//						sourceMap = s.getSourceAsMap();
//				arrList.add(sourceMap);
//
//				//s.getSourceAsMap()
//
//				String title = (String) sourceMap.get("projectName");
//				String contents = (String) sourceMap.get("backgroundContents");
//				String updatedDate = (String) sourceMap.get("updatedDate");
//				String type = "STEP_INFO";
//				float score = s.getScore();
//				SearchResult searchResult = new SearchResult(title,contents,type,updatedDate,score);
//				searchResultList.add(searchResult);
//				logger.info("==="+s.getScore()+s.getSourceAsMap().get("title"));
//			}
//			//return arrList;
//		} catch (IOException e) {
//			logger.info("Elastic search fail"+e);
//		}
//		return searchResultList;
//		//	return checkInfoList;
//	}


}
