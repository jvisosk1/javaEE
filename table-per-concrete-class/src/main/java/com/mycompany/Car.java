package com.mycompany;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Car {
        
    @Id 
    private int carId;

    private String name;

    @Column(name="MADE_YEAR")
    private int year;    

    public int getIdCar() {
        return carId;
    }
    public void setIdCar(int carId) {
        this.carId = carId;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}   