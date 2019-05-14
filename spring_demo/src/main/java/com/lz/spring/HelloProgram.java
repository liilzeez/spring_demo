package com.lz.spring;

import com.lz.spring.helloworld.HelloWorld;
import com.lz.spring.helloworld.HelloWorldService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloProgram {
	 public static void main(String[] args) {
         
	        ApplicationContext context =
	                new ClassPathXmlApplicationContext("beans.xml");
	         
	        HelloWorldService service =
	             (HelloWorldService) context.getBean("helloWorldService");
	          
	        HelloWorld hw= service.getHelloWorld();
	         
	        hw.sayHello();
	    }



}