package za.co.idealogic.javaexercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaExerciseApplication implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(JavaExerciseApplication.class, args);	
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Java Exercise 3: Application started!");
		
		GreetingService service = new GreetingService();
		service.process(args);

        log.info("Java Exercise 3: Application ended!");
	}
}
