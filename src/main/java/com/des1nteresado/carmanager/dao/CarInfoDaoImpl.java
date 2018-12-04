package com.des1nteresado.carmanager.dao;

import com.des1nteresado.carmanager.model.CarInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarInfoDaoImpl /*implements CarInfoDao*/{
   /* private static final Logger logger = LoggerFactory.getLogger(CarDaoImpl.class);

    private SessionFactory sessionCarFactory;

    @Override
    public void addCarInfo(CarInfo carInfo) {
        Session session = this.sessionCarInfoFactory.getCurrentSession();
        session.persist(carInfo);
        logger.info("CarInfo successfully saved. CarInfo details: " + carInfo);
    }

    @Override
    public void updateCarInfo(CarInfo carInfo) {
        Session session = this.sessionCarInfoFactory.getCurrentSession();
        session.update(carInfo);
        logger.info("CarInfo successfully update. CarInfo details: " + carInfo);
    }

    @Override
    public void removeCarInfo(int id) {
        Session session = this.sessionCarInfoFactory.getCurrentSession();
        CarInfo carInfo = (CarInfo) session.load(CarInfo.class, id);

        if (carInfo != null) {
            session.delete(carInfo);
        }
        logger.info("CarInfo successfully removed. CarInfo details: " + carInfo);
    }

    @Override
    public CarInfo getCarInfoById(int id) {
        Session session = this.sessionCarInfoFactory.getCurrentSession();
        CarInfo carInfo = (CarInfo) session.load(CarInfo.class, id);
        logger.info("CarInfo successfully loaded. CarInfo details: " + carInfo);
        return carInfo;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<CarInfo> listCarsInfo() {
        Session session = this.sessionCarInfoFactory.getCurrentSession();
        List<CarInfo> carsInfoList = session.createQuery("from CarInfo").list();

        for(CarInfo carsInfo : carsInfoList) {
            logger.info("CarInfo list: " + carsInfo);
        }
        return carsInfoList;
    }

    public void setSessionCarInfoFactory(SessionFactory sessionCarInfoFactory) {
        this.sessionCarInfoFactory = sessionCarInfoFactory;
    }*/
}
