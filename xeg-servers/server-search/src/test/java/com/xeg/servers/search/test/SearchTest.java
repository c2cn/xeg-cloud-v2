package com.xeg.servers.search.test;

import java.io.IOException;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.xeg.servers.search.index.UserIndex;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SearchTest {
	@Autowired
	RestHighLevelClient client;
	
	/**
	* @Title: createIndex  
	* @Description: 2021年10月29日 下午10:02:23 创建索引
	* @param @throws IOException    参数  
	* @return void    返回类型  
	* @throws
	 */
//	@Test
	@SuppressWarnings("deprecation")
    public void createIndex() throws IOException {
		log.info("createIndex...创建索引");
        CreateIndexRequest request = new CreateIndexRequest("xian2_index");
        
        CreateIndexResponse createIndexResponse = client.indices()
        		.create(request, RequestOptions.DEFAULT);
        
        log.info(JSON.toJSONString(createIndexResponse));
	}
	
	/**
	* @Title: addDocument  
	* @Description: 2021年10月29日 下午10:02:11 添加文档
	* @param @throws IOException    参数  
	* @return void    返回类型  
	* @throws
	 */
//	@Test
    public void addDocument() throws IOException {
		log.info("addDocument...添加数据");
		
		// 创建对象
		UserIndex userIndex = new UserIndex();
		userIndex.setName("xian2");
		userIndex.setAge(22);
		
		// 创建请求
		IndexRequest request = new IndexRequest("xian1_index");
		
		// 规则 put /xian1_index/_doc/1
//		request.id("1");
		request.timeout(TimeValue.timeValueSeconds(30));
		request.timeout("30s");
		
		// 将数据放入请求 JSON
		request.source(JSON.toJSONString(userIndex), XContentType.JSON);
		
		// 客户端发送请求，获取响应的结果
		IndexResponse response = client.index(request, RequestOptions.DEFAULT);
		log.info("response = " + JSON.toJSONString(response));
		log.info("response.status = " + response.status());
		
	}
	
    /**
    * @Title: isExistsDocument  
    * @Description: 2021年10月29日 下午10:01:54 文档是否存在
    * @param @throws IOException    参数  
    * @return void    返回类型  
    * @throws
     */
//    @Test
    public void isExistsDocument() throws IOException {
		log.info("isExistsDocument...数据是否存在");
		
		// 创建请求 规则 get /xian1_index/_doc/1
		GetRequest getRequest = new GetRequest("xian1_index", "1");
		
		// 不获取返回的_source 的上下文
		getRequest.fetchSourceContext(new FetchSourceContext(false));
		getRequest.storedFields("_none_");
		
		boolean isExists = client.exists(getRequest, RequestOptions.DEFAULT);
		
		log.info("isExists = " + isExists);
    }
	
    /**
    * @Title: queryDocument  
    * @Description: 2021年10月29日 下午10:03:32 查询文档
    * @param @throws IOException    参数  
    * @return void    返回类型  
    * @throws
     */
//    @Test
    public void queryDocument() throws IOException {
		log.info("queryDocument...查询数据");
		
		// 创建请求 规则 get /xian1_index/_doc/1
		GetRequest getRequest = new GetRequest("xian1_index", "1");
		
		// 获取响应数据
		GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
		
		log.info("getSource = " + getResponse.getSource());
		log.info("getSourceAsString = " + getResponse.getSourceAsString());
		log.info("getResponse = " + JSON.toJSONString(getResponse));
    }
	
    /**
    * @Title: updateDocument  
    * @Description: 2021年10月29日 下午10:10:10 更新文档
    * @param @throws IOException    参数  
    * @return void    返回类型  
    * @throws
     */
//    @Test
    public void updateDocument() throws IOException {
		log.info("updateDocument...更新数据");
		
		// 创建更新请求
		UpdateRequest updateRequest = new UpdateRequest("xian1_index", "1");
		updateRequest.timeout("30s");
		
		// 更新数据，只更新传输的数据，name不会更新
		UserIndex userIndex = new UserIndex();
		userIndex.setAge(31);
		updateRequest.doc(JSON.toJSONString(userIndex), XContentType.JSON);
		
		UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
		log.info("updateResponse = " + updateResponse.status());
    }
    
    /**
    * @Title: deleteDocument  
    * @Description: 2021年10月29日 下午10:16:22 删除文档
    * @param @throws IOException    参数  
    * @return void    返回类型  
    * @throws
     */
//    @Test
    public void deleteDocument() throws IOException {
		log.info("deleteDocument...删除数据");
		
		// 创建删除请求
		DeleteRequest deleteRequest = new DeleteRequest("xian1_index", "Pn1ZzHwBofpHVdlvPzuH");
		deleteRequest.timeout("10s");
		
		DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
		log.info("deleteResponse = " + deleteResponse.status());
    }
    
    /**
    * @Title: search  
    * @Description: 2021年10月30日 下午1:31:31 搜索
    * @param @throws IOException    参数  
    * @return void    返回类型  
    * @throws
     */
    @Test
    public void search() throws IOException {
		log.info("search...搜索查询");
		
		// 创建搜索请求
		SearchRequest searchRequest = new SearchRequest("xian1_index");
		
		// 构建搜索条件
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		
		/**
		 * 1、查询条件 使用 QueryBuilders
		 * 2、QueryBuilders termQuery 精准查询
		 * 3、QueryBuilders matchAllQuery 匹配查询
		 */
		TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "xian1");
		
		sourceBuilder.query(termQueryBuilder);
		
		searchRequest.source(sourceBuilder);
		
		SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		
		log.info("getHits = " + JSON.toJSONString(searchResponse.getHits()));
		
		for (SearchHit searchHit : searchResponse.getHits().getHits()) {
			log.info("searchHit = " + JSON.toJSONString(searchHit));
		}
    }
    
    
//    @Test
    public void search2() throws IOException {
    	log.info("search2...搜索查询");
    	// 创建搜索请求
    	SearchRequest searchRequest = new SearchRequest("xian1_index");
    	
    	// 构建搜索条件
    	SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    			
    	BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
    	
    	QueryBuilder queryBuilder = QueryBuilders.boolQuery().minimumShouldMatch(1)
		        .should(QueryBuilders.boolQuery()
		                .filter(QueryBuilders.wildcardQuery("name", ("*xian*"))))
		        .should(QueryBuilders.boolQuery()
		                .filter(QueryBuilders.matchPhraseQuery("name", ("*xian*"))))
		        .should(QueryBuilders.boolQuery()
		                .filter(QueryBuilders.matchQuery("name", "xian")));
		
		boolQueryBuilder.must(queryBuilder);
    	
    	
    	
    }
}
