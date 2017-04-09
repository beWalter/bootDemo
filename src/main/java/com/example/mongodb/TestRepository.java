package com.example.mongodb;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.alibaba.fastjson.JSONObject;

public interface TestRepository extends MongoRepository<JSONObject, Serializable>{

/*	List<JSONObject> findByTitle(String title);
	
	Page<JSONObject> findByTitle(String title,Pageable page);*/
}
