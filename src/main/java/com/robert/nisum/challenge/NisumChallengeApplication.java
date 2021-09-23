package com.robert.nisum.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NisumChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NisumChallengeApplication.class, args);
	}

}
