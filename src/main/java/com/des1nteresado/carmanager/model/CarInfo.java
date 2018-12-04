package com.des1nteresado.carmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "cars_info")
public class CarInfo {
    @Id
    private int id;
    private int vin;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "id=" + id +
                ", vin=" + vin +
                ", color='" + color + '\'' +
                '}';
    }
}
