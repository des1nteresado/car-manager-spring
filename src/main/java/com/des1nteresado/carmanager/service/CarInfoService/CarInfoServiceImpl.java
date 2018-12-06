package com.des1nteresado.carmanager.service.CarInfoService;

import com.des1nteresado.carmanager.dao.CarInfoDAO.CarInfoDao;
import com.des1nteresado.carmanager.model.CarInfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarInfoServiceImpl implements CarInfoService {

    private CarInfoDao carInfoDao;

    @Override
    @Transactional
    public void addCarInfo(CarInfo carInfo) {
        carInfoDao.addCarInfo(carInfo);
    }

    @Override
    @Transactional
    public void updateCarInfo(CarInfo carInfo) {
        carInfoDao.updateCarInfo(carInfo);
    }

    @Override
    @Transactional
    public void removeCarInfo(int id) {
        carInfoDao.removeCarInfo(id);
    }

    @Override
    @Transactional
    public CarInfo getCarInfoById(int id) {
        return carInfoDao.getCarInfoById(id);
    }

    @Override
    @Transactional
    public List<CarInfo> listCarsInfo() {
        return carInfoDao.listCarsInfo();
    }

    public void setCarInfoDao(CarInfoDao carInfoDao) {
        this.carInfoDao = carInfoDao;
    }
}
