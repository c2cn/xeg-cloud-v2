package com.xeg.cores.elasticsearch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

/**
	* @author xian
	* @date   2021年11月9日 下午2:52:39
	* @version v1.0.0
	* @Description	ES配置
	* ElasticSearchConfig.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月9日 下午2:52:39       xian            v1.0.0           Created
 */
@Getter
@Setter
@Configuration
public class ElasticSearchConfig {
	@Value("${es.uris:''}")
    private String uris;
}
