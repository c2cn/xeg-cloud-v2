package com.xeg.cores.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
	* @author xian
	* @date   2021年10月29日 下午10:04:05
	* @version v1.0.0
	* @Description	ElasticSearch 配置加载 TODO
	* ElasticSearchClientConfig.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年10月29日 下午10:04:05       xian            v1.0.0           Created
 */
@Slf4j
@Configuration
public class ElasticSearchClientConfig {
	
	@Bean
	public RestHighLevelClient restHighLevelClient(ElasticSearchConfig config) {
		log.info("getUris = " + config.getUris());
		try {
			// uris: http://192.168.1.150:9200,http://192.168.1.150:9200 ES链接，多个以逗号分隔
			String[] uris = config.getUris().split(",");
			
			HttpHost[] httpHosts = new HttpHost[uris.length];
			for (int i = 0; i < uris.length; i++) {
				String uri = uris[i];
				
				String hostname = uri.substring(uri.indexOf("//") + 2, uri.lastIndexOf(":"));
				int port = Integer.parseInt(uri.substring(uri.lastIndexOf(":") + 1));
				log.info("hostname = " + hostname + ", port = " + port);
				
				// 创建
				HttpHost httpHost = new HttpHost(hostname, port, "http");
				httpHosts[i] = httpHost;
			}
			// 构建集群
			RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
					RestClient.builder(httpHosts));
			
			return restHighLevelClient;
		} catch (Exception e) {
			throw new RuntimeException("错误的 ElasticSearch 配置，请检查配置 ：" + config.getUris());
		}
	}
	
	public static void main(String[] args) {
		String uri =  "http://192.168.1.150:9200";
		String hostname = uri.substring(uri.indexOf("//") + 2, uri.lastIndexOf(":"));
		String port = uri.substring(uri.lastIndexOf(":") + 1);
		log.info("hostname = " + hostname + ", port = " + port);
		
	}
}
