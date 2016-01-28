/**
 * 
 */
package com.imti.spring.es.controller;

import org.apache.lucene.index.IndexNotFoundException;
import org.elasticsearch.indices.IndexAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imti.spring.es.service.ElasticSearchServiceImpl;

/**
 * @author imteyaz
 *
 */
@Controller
public class HomeController {

	@Autowired
	ElasticSearchServiceImpl elasticService;

	@RequestMapping("/settings/{name}")
	public String getIndexSettings(Model model, @PathVariable String indexName) throws IndexNotFoundException {
		model.addAttribute("settings", elasticService.getIndexData(indexName));
		System.out.println(elasticService.getIndexData(indexName));
		return "home";
	}

	@RequestMapping("/createIndex/{name}")
	public String createIndex(Model model, @PathVariable String indexName) throws IndexAlreadyExistsException {
		boolean flag = elasticService.createIndex(indexName);
		if (flag) {
			model.addAttribute("flag", flag);
		}
		return "index";
	}
}
