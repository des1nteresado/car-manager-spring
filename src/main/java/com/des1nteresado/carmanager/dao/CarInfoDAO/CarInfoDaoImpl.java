package com.des1nteresado.carmanager.dao.CarInfoDAO;

import com.des1nteresado.carmanager.model.Car;
import com.des1nteresado.carmanager.model.CarInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarInfoDaoImpl implements CarInfoDao{

    private SessionFactory sessionFactory;

    @Override
    public void addCarInfo(CarInfo carInfo) {
        Session session = this.sessionFactory.getCurrentSession();
        Car car = (Car) session.load(Car.class, carInfo.getCar().getId());
        carInfo.setCar(car);
        session.persist(carInfo);
    }

    @Override
    public void updateCarInfo(CarInfo carInfo) {
        Session session = this.sessionFactory.getCurrentSession();
        Car car = (Car) session.load(Car.class, carInfo.getCar().getId());
        carInfo.setCar(car);
        session.update(carInfo);
    }

    @Override
    public void removeCarInfo(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CarInfo carInfo = (CarInfo) session.load(CarInfo.class, id);
        carInfo.setCar(null);
        if (carInfo != null) {
            session.delete(carInfo);
        }
    }

    @Override
    public CarInfo getCarInfoById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CarInfo carInfo = (CarInfo) session.load(CarInfo.class, id);
        return carInfo;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<CarInfo> listCarsInfo() {
        Session session = this.sessionFactory.getCurrentSession();
        List<CarInfo> carsInfoList = session.createQuery("from CarInfo").list();
        return carsInfoList;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
