package com.example.firstweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstwebApplication {
	@Autowired
	ApplicationContext context;
	@Bean ApplicationRunner run() {
		return new ApplicationRunner() {
			
			@Override
			public void run(ApplicationArguments args) throws Exception {
				 System.out.println("spring boot");
				 
				 int count = context.getBeanDefinitionCount();
			        System.out.println("Beans的个数：" + count);
			        String[] names = context.getBeanDefinitionNames();
			        for (String name : names) {
			               System.out.print(name);
			               System.out.print("->");
			               Object bean = context.getBean(name);
			               System.out.println(bean.getClass().getName());
			        }
			}
		};
	}
	
	@Bean int num() {
		return 1;
	}
	
	public static void main(String[] args) {
		 SpringApplication.run(FirstwebApplication.class, args);
        
	}
}
