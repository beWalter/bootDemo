package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.mongodb.TestRepository;

@RestController
@RequestMapping("/credit")
public class CreditController {

	@Autowired
	TestRepository testRepository;
	
	@RequestMapping("/findAll/{title}")
	List<JSONObject> findObject(@PathVariable String title){
		System.out.println(title);
		return testRepository.findAll();
	}
	
	@RequestMapping("/save")
	JSONObject saveObject(){
		JSONObject object = JSONObject.parseObject("{\"Json解析\":\"支持格式化高亮折叠\",\"支持XML转换\":\"支持XML转换Json,Json转XML\",\"Json格式验证\":\"更详细准确的错误信息\",\"title\":\"mytest\"}");
		testRepository.save(object);
		return object;
	}
}
