package gr.hua.dit.referenceLetterApp;

import gr.hua.dit.referenceLetterApp.repository.UserRepository;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ReferenceLetterAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(ReferenceLetterAppApplication.class, args);
	}

}
