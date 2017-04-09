package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;
import com.example.mongodb.UserRepository;

@SpringBootApplication
@RestController
public class DemoApplication implements EmbeddedServletContainerCustomizer{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@RequestMapping("/test")
	String test(){
		return "test";
	}
	
	@RequestMapping("/getBean")
	TestBean getBean(){
		TestBean bean = new TestBean();
		bean.setId("id");
		bean.setAge(12);
		bean.setName("myName");
		return bean;
	}
	
	@RequestMapping("/saveUser/{id}/{userName}/{age}")
	User saveUser(@PathVariable("id")Long id,@PathVariable("userName")String userName,@PathVariable("age")Integer age){
		return userRepository.save(new User(id,userName,age));
	}
	
	@RequestMapping("/findUser/{userName}")
	User findByUser(@PathVariable("userName")String userName){
		return userRepository.findByUserName(userName);
	}
	
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container){
		container.setPort(8088);
	}
	
}

class TestBean{
	private String name ;
	private String id;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
