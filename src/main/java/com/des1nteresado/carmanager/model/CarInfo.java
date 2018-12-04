package com.des1nteresado.carmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "cars_info")
public class CarInfo {
    @Id
    private int id;
    private int mileage;
    private String color;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "id=" + id +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
