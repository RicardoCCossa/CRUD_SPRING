package com.ricardo;

import com.ricardo.Repository.CourseRepository;
import com.ricardo.model.Courses;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();
			Courses courses = new Courses();
			courses.setName("Spring Crud");
			courses.setCategory("Spring Framework");

			courseRepository.save(courses);
		};
	}
}
