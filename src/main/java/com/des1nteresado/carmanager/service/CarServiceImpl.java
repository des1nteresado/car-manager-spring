package com.des1nteresado.carmanager.service;

import com.des1nteresado.carmanager.dao.CarDao;
import com.des1nteresado.carmanager.model.Car;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    @Transactional
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Override
    @Transactional
    public void updateCar(Car car) {
        carDao.updateCar(car);
    }

    @Override
    @Transactional
    public void removeCar(int id) {
        carDao.removeCar(id);
    }

    @Override
    @Transactional
    public Car getCarById(int id) {
        return carDao.getCarById(id);
    }

    @Override
    @Transactional
    public List<Car> listCars() {
        return carDao.listCars();
    }
}
