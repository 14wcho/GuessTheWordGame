package com.seleniumexpress.guesstheword.guess_the_word;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GuessTheWordApplication {

	public static void main(String[] args) {

		//ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(GuessTheWordApplication.class, args); - can see what is created behind the scenes

		SpringApplication.run(GuessTheWordApplication.class, args);

	}

}
