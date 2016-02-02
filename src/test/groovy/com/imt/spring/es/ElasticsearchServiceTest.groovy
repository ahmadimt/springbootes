/**
 * 
 */
package com.imt.spring.es

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;

import com.imti.spring.es.SpringbootesApplication
import com.imti.spring.es.service.ElasticsearchService

import spock.lang.Specification;

/**
 * @author imteyaz
 *
 */
@ContextConfiguration (loader=SpringApplicationContextLoader.class ,classes = SpringbootesApplication.class)
class ElasticsearchServiceTest extends Specification{

	@Autowired
	ElasticsearchService elasticSearchService;

	public void testIndexSettings(){

		given: "the name of the index"
		def settings = elasticSearchService.getIndexSettings("imti");
		expect: "Should be able to print the settings for the index"
		settings
	}
}
