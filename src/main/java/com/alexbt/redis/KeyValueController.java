package com.alexbt.redis;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.keyvalue.core.KeyValueTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keyvalues")
public class KeyValueController {

	@Autowired
	private KeyValueTemplate keyValueTemplate;
	
	@Autowired
	private ModelKeyValueRepository modelRepository;
	
	@RequestMapping(value = "/repo", method = RequestMethod.GET)
	public Iterable<Model> findByRepo() throws IOException {
		return modelRepository.findAll();
	}
	
	@RequestMapping(value = "/repo/{value}", method = RequestMethod.GET)
	public void saveByRepo(@PathVariable String value) {
		Model model = new Model();
		model.setId(System.currentTimeMillis());
		model.setValue(value);
		modelRepository.save(model);
	}
	
	@RequestMapping(value = "/template", method = RequestMethod.GET)
	public Iterable<Model> findByTemplate() throws IOException {
		return keyValueTemplate.findAll(Model.class);
	}
	
	@RequestMapping(value = "/template/{value}", method = RequestMethod.GET)
	public void saveByTemplate(@PathVariable String value) {
		Model model = new Model();
		model.setId(System.currentTimeMillis());
		model.setValue(value);
		keyValueTemplate.insert(model);
	}
}
