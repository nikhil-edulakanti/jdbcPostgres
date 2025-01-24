package com.nikhil.jdbcPostgresSB.service;

import com.nikhil.jdbcPostgresSB.model.Cars;
import com.nikhil.jdbcPostgresSB.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarRepo repo;

    public CarRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(CarRepo repo) {
        this.repo = repo;
    }


    public void addCar(Cars car){
        System.out.println("Car Added");
        repo.save(car);
    }


    public List<Cars> getCars() {

        return repo.findAll();
    }

    public List<Cars> getSpecific(int a, int b){
        return repo.getfilter(a,b);
    }
}
