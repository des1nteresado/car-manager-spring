package com.des1nteresado.carmanager.service.CarInfoService;

import com.des1nteresado.carmanager.model.CarInfo;

import java.util.List;

public interface CarInfoService {
    void addCarInfo(CarInfo carInfo);

    void updateCarInfo(CarInfo carInfo);

    void removeCarInfo(int id);

    CarInfo getCarInfoById(int id);

    List<CarInfo> listCarsInfo();
}
