package com.nikhil.jdbcPostgresSB;

import com.nikhil.jdbcPostgresSB.model.Cars;
import com.nikhil.jdbcPostgresSB.service.CarService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.util.List;

@SpringBootApplication
public class JdbcPostgresSbApplication {

	public static void


	main(String[] args) {

		ApplicationContext context = SpringApplication.run(JdbcPostgresSbApplication.class, args);

		Cars car = context.getBean(Cars.class);

		car.setId(111);
		car.setMake("Nissan");
		car.setModel("Altima");
		car.setMileage(85003);
		car.setVin("BG4889DL5");
		car.setYear(2021);

		SessionFactory sf = new Configuration()
							.addAnnotatedClass(Cars.class)
							.configure("hibernate.config.xml")
							.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//session.merge(car);

		Cars c = session.get(Cars.class,101);

		//session.persist(car);

		//tx.commit();
		session.close();
		sf.close();
		System.out.println(c);








		//CarService service = context.getBean(CarService.class);
		//service.addCar(car);

		//List <Cars> carsList = service.getCars();
		//System.out.println(carsList);
		//List <Cars> carFiltered = service.getSpecific(2018,2020);
		//System.out.println(carFiltered);
	}

}
