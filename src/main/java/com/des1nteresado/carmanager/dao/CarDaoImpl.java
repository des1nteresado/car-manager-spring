package com.des1nteresado.carmanager.dao;

import com.des1nteresado.carmanager.model.Car;
import com.des1nteresado.carmanager.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private static final Logger logger = LoggerFactory.getLogger(CarDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCar(Car car) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, car.getUser().getId());
        car.setUser(user);
        session.persist(car);
        logger.info("Car successfully saved. Car details: " + car);
    }

    @Override
    public void updateCar(Car car) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, car.getUser().getId());
        car.setUser(user); //in add this!
        session.update(car);
        logger.info("Car successfully update. Car details: " + car);
    }

    @Override
    public void removeCar(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Car car = (Car) session.load(Car.class, id);

        if (car != null) {
            session.delete(car);
        }
        logger.info("Car successfully removed. Car details: " + car);
    }

    @Override
    public Car getCarById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Car car = (Car) session.load(Car.class, id);
        logger.info("Car successfully loaded. Car details: " + car);
        return car;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<Car> listCars() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Car> carList = session.createQuery("from Car").list();

        for(Car car : carList) {
            logger.info("Car list: " + car);
        }
        return carList;
    }

}
