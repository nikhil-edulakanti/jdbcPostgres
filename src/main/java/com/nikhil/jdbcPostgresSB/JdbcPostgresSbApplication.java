package com.nikhil.jdbcPostgresSB;

import com.nikhil.jdbcPostgresSB.model.Cars;
import com.nikhil.jdbcPostgresSB.service.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.util.List;

@SpringBootApplication
public class JdbcPostgresSbApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(JdbcPostgresSbApplication.class, args);

		Cars car = context.getBean(Cars.class);

		car.setId(110);
		car.setMake("Nissan");
		car.setModel("Altima");
		car.setMileage(85000);
		car.setVin("NS78901KL5");
		car.setYear(2021);


		CarService service = context.getBean(CarService.class);
		//service.addCar(car);

		//List <Cars> carsList = service.getCars();
		//System.out.println(carsList);
		List <Cars> carFiltered = service.getSpecific(2018,2020);
		System.out.println(carFiltered);
	}

}
