package com.des1nteresado.carmanager.dao.CarDAO;

import com.des1nteresado.carmanager.model.Car;

import java.util.List;

public interface CarDao {
    void addCar(Car car);

    void updateCar(Car car);

    void removeCar(int id);

    Car getCarById(int id);

    List<Car> listCars();
}
