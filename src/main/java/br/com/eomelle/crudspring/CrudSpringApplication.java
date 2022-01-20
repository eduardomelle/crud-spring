package br.com.eomelle.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.eomelle.crudspring.model.Course;
import br.com.eomelle.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("Front-end");

			courseRepository.deleteAll();
			courseRepository.save(c);
		};
	}

}
