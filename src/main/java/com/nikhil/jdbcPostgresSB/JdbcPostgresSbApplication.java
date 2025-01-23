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
		car.setId(101);
		car.setMake("Ford");
		car.setModel("Focus SE");
		car.setMileage(130000);
		car.setVin("1WERE232SS");
		car.setYear(2015);


		CarService service = context.getBean(CarService.class);
//		service.addCar(car);

		List <Cars> carsList = service.getCars();
		System.out.println(carsList);
//
//		List <Cars> carFiltered = service.getSpecific(10,20);
//		System.out.println(carFiltered);
	}

}
