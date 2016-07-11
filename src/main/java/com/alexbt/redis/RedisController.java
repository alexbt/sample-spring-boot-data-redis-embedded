package com.alexbt.redis;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis/template")
public class RedisController {

	@Autowired
	private RedisTemplate<String, Model> redisTemplate;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Model> findAll() throws IOException {
		return redisTemplate.boundSetOps("myKey").members();
	}

	@RequestMapping(value = "/{value}", method = RequestMethod.GET)
	public void save(@PathVariable String value) {
		Model model = new Model();
		model.setId(System.currentTimeMillis());
		model.setValue(value);
		redisTemplate.boundSetOps("myKey").add(model);
	}
}
