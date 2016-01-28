/**
 * 
 */
package com.imti.spring.es.service;

import java.util.Map;

import org.apache.lucene.index.IndexNotFoundException;
import org.elasticsearch.indices.IndexAlreadyExistsException;

/**
 * @author imteyaz
 *
 */
public interface ElasticsearchService {

	boolean createIndex(String indexName) throws IndexAlreadyExistsException;

	Map<String, String> getIndexData(String indexName) throws IndexNotFoundException;
}
