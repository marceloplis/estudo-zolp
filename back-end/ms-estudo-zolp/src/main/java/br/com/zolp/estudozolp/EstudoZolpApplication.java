package br.com.zolp.estudozolp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.zolp.estudozolp")
@EnableAutoConfiguration
public class EstudoZolpApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudoZolpApplication.class, args);
	}

}
