/**
 * 
 */
package com.imti.spring.es;

import java.util.Map;

import org.apache.lucene.index.IndexNotFoundException;
import org.elasticsearch.indices.IndexAlreadyExistsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.imti.spring.es.service.ElasticsearchService;

/**
 * @author imteyaz
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootesApplication.class)
public class ElasticsearchServiceTest {

	@Autowired
	ElasticsearchService elasticSearchService;

	@Test
	public void testIndexSettings() throws IndexNotFoundException {

		Map<String, String> map = elasticSearchService.getIndexSettings("imti");
		assertThat(map.isEmpty(), is(false));

	}

	@Test
	public void testIfIndexExists() {
		try {
			elasticSearchService.getIndexSettings("lilly");
		} catch (IndexNotFoundException e) {
			assertThat("lilly does not exist", e instanceof IndexNotFoundException, is(true));
		}

	}

	@Test
	public void testCreateIndex() {
		try {
			elasticSearchService.createIndex("lil");
			elasticSearchService.createIndex("imteyaz");
			
		} catch (Exception e) {
			assertThat("Index already exists", e instanceof IndexAlreadyExistsException, is(true));
		}
	}

}
