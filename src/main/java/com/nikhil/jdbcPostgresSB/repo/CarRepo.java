package com.nikhil.jdbcPostgresSB.repo;

import com.nikhil.jdbcPostgresSB.model.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Cars car) {
        String query = "insert into cars values (?, ? , ?, ?, ?, ?)";

        int row = jdbc.update(query, car.getId(),car.getMake(), car.getModel(), car.getVin(), car.getMileage(),car.getYear());
        System.out.println(row + " inserted");


    }

    public List<Cars> findAll() {

        String query = "select * from cars";


        return jdbc.query(query,(ResultSet rs, int rowNum) -> {
            Cars car = new Cars();
            car.setId(rs.getInt("id"));
            car.setMake(rs.getString("make"));
            car.setModel(rs.getString("model"));
            car.setVin(rs.getString("vin"));
            car.setMileage(rs.getInt("mileage"));
            car.setYear(rs.getInt("year"));
            return car;
        });
    }

    public List<Cars> getfilter(int a, int b) {
        String query = "select * from cars where year between " + a + " and " + b;


        return jdbc.query(query,(ResultSet rs, int rowNum)-> {
        Cars car = new Cars();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setVin(rs.getString("vin"));
        car.setMileage(rs.getInt("mileage"));
        car.setYear(rs.getInt("year"));
        return car;
    });
    }
}