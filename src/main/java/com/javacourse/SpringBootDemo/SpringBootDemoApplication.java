package com.javacourse.SpringBootDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.javacourse.SpringBootDemo.model.Post;
import com.javacourse.SpringBootDemo.repository.PostRepository;


@SpringBootApplication
public class SpringBootDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootDemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PostRepository repository) {
		return (args) -> {
			repository.save(new Post("Test", "Questo è un test"));
			repository.save(new Post("JAVAEE", "Powerful JavaEE"));
			
			log.info("Calling findAll");
			for(Post p : repository.findAll()) {
				log.info(p.toString());
			}
			log.info("");
		};
	}

}
