/**
 * 
 */
package com.imti.spring.es.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.index.IndexNotFoundException;
import org.elasticsearch.index.Index;
import org.elasticsearch.indices.IndexAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * @author imteyaz
 *
 */
@Service
public class ElasticSearchServiceImpl implements ElasticsearchService {

	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;

	@SuppressWarnings("unchecked")
	public Map<String, String> getIndexSettings(String indexName) throws IndexNotFoundException {
		Map<String, String> result = new HashMap<String, String>();
		if (elasticsearchTemplate.indexExists(indexName)) {
			result = elasticsearchTemplate.getSetting(indexName);
		} else {
			throw new IndexNotFoundException(indexName + " does not exists");
		}
		return result;
	}

	@Override
	public boolean createIndex(String indexName) throws IndexAlreadyExistsException {
		if (!elasticsearchTemplate.indexExists(indexName)) {
			elasticsearchTemplate.createIndex(indexName);
			return true;
		} else {
			throw new IndexAlreadyExistsException(new Index(indexName), " Already Exists");

		}
	}
}
