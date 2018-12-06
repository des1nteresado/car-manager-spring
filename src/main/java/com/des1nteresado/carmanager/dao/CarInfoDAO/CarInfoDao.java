package com.des1nteresado.carmanager.dao.CarInfoDAO;

import com.des1nteresado.carmanager.model.CarInfo;

import java.util.List;

public interface CarInfoDao {
    void addCarInfo(CarInfo carInfo);

    void updateCarInfo(CarInfo carInfo);

    void removeCarInfo(int id);

    CarInfo getCarInfoById(int id);

    List<CarInfo> listCarsInfo();
}
