package com.nikhil.jdbcPostgresSB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
public class Cars {

    @Id
    @GeneratedValue
    private int id;

    private String make;
    private String model;
    private String vin;
    private int mileage;
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "ID : " + getId() + "\t" +
                "MAKE : " + getMake() + "\t" +
                "MODEL : " + getModel() + "\t" +
                "VIN : " + getVin() + "\t" +
                "MILEAGE : " + getMileage() + "\t" +
                "YEAR : " + getYear() + "\n";
    }
}
