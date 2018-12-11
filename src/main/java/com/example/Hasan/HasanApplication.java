package com.example.Hasan;


import com.example.Hasan.domain.post.Post;
import com.example.Hasan.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HasanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HasanApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(PostService postService) {
		return (args) -> {

		};
	}

}
