package be.ordina.boerenkostbe.boerenkost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class BoerenkostApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoerenkostApplication.class, args);
	}
}
