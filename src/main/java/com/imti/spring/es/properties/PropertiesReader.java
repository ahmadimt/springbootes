/**
 * 
 */
package com.imti.spring.es.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author imteyaz
 *
 */
@Component
public class PropertiesReader {

	@Value("${spring.data.elasticsearch.index.name}")
	public String indexName;
}
