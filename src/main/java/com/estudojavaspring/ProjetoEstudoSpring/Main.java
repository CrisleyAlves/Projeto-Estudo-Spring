package com.estudojavaspring.ProjetoEstudoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
	@SpringBootApplication define a classe principal do Spring
	@ComponentScan informa ao SpringBoot onde estará os controllers que serão utilizados
 */
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
