package com.ibk.epmo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.ibk.epmo")
public class ESConfig {

    @Bean
    public RestHighLevelClient client(){
        return  new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));

//            return new

 //       return new RestHighLevelClient((RestClient.builder(
 //               new HttpHost("search-luelsearch-kr3evqjalvekurflhglijdbgmm.us-east-1.es.amazonaws.com",443,"https"))));
 //       new HttpHost("search-epmosearch-i6h5bimjjrrbale3dwtcqqcbeq.us-east-1.es.amazonaws.com",443,"https"))));

//        https://search-epmosearch-i6h5bimjjrrbale3dwtcqqcbeq.us-east-1.es.amazonaws.com
                                                                          //https://search-luelsearch-kr3evqjalvekurflhglijdbgmm.us-east-1.es.amazonaws.com/
                                                                          //https://search-luelsearch-kr3evqjalvekurflhglijdbgmm.us-east-1.es.amazonaws.com/
//        return new RestHighLevelClient((RestClient.builder(HttpHost.create("https://search-luelsearch-es-l6atdaxzimvtbcf3udf54ajm2a.ap-northeast-2.es.amazonaws.com"))));
    }
}
