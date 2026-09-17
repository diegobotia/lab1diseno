package com.tdea.lab1diseno;

import com.tdea.lab1diseno.entity.Car;
import com.tdea.lab1diseno.repository.CarRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Lab1disenoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab1disenoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CarRepository repository) {
		return args -> {
			Stream.of("Ferrari",
					"Jaguar Car",
					"Porsche",
					"Lamborghini",
					"Bugatti",
					"AMC Gremlin",
					"Triumph Stag",
					"Ford Pinto",
					"Yugo GV").forEach(name -> {
						Car car = new Car();
						car.setName(name);
						repository.save(car);
			});
			repository.findAll().forEach(System.out::println);
		};
	}



}
