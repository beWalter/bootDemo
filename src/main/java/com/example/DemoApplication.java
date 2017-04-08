package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication implements EmbeddedServletContainerCustomizer{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@RequestMapping("/test")
	String test(){
		return "test";
	}
	
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container){
		container.setPort(8088);
	}
}
