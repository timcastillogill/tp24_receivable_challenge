package com.tp24.receivables;

import com.tp24.receivables.models.Receivable;
import com.tp24.receivables.repository.ReceivableRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ReceivableRepository receivableRepository) {
		return args -> {
			Receivable receivable_1 = new Receivable(
					"123456",
					"GBP",
					"23/01/2020",
					1234.56,
					1234.56,
					"23/02/2020",
					null,
					true,
					"Apple",
					"asdfsadf",
					"5 Farringdon",
					"New Walk",
					"London",
					null,
					null,
					"UK",
					null
			);
			receivableRepository.save(receivable_1);
		};
	}
}
