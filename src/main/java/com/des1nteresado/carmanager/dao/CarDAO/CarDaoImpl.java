package com.des1nteresado.carmanager.dao.CarDAO;

import com.des1nteresado.carmanager.model.Car;
import com.des1nteresado.carmanager.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.TransactionManager;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

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
    }

    @Override
    public void updateCar(Car car) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, car.getUser().getId());
        car.setUser(user);
        session.update(car);
    }

    @Override
    public void removeCar(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Car car = (Car) session.load(Car.class, id);
        car.setUser(null);
        if (car != null) {
            session.delete(car);
        }
    }

    @Override
    public Car getCarById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Car car = (Car) session.load(Car.class, id);
        return car;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<Car> listCars() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Car> carList = session.createQuery("from Car").list();
        return carList;
    }

}
