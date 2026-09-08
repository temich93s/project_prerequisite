package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImp implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        if (isCarNotExist(car)) {
            sessionFactory.getCurrentSession().save(car);
        }
    }

    private boolean isCarNotExist(Car car) {
        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Car where model = :model and series = :series",
                        Car.class
                )
                .setParameter("model", car.getModel())
                .setParameter("series", car.getSeries())
                .getResultList()
                .isEmpty();
    }
}
