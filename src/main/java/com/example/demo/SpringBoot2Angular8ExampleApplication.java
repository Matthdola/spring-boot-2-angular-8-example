package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Car;
import com.example.demo.model.CarRepository;

@SpringBootApplication
public class SpringBoot2Angular8ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2Angular8ExampleApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(CarRepository repository) {
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugati",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
						Car car = new Car();
						car.setName(name);
						repository.save(car);
			});
			repository.findAll().forEach(System.out::println);
		};
	}

}
