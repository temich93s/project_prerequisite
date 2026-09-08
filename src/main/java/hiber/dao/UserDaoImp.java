package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      if (isUserNotExist(user)) {
         sessionFactory.getCurrentSession().save(user);
      }
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCar(String model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
              "from User u where u.car.model = :model and u.car.series = :series",
              User.class
      );
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.getSingleResult();
   }

   private boolean isUserNotExist(User user) {
      return sessionFactory.getCurrentSession()
              .createQuery(
                      "from User u " +
                      "where u.firstName = :fistname " +
                      "and u.lastName = :lastname " +
                      "and u.email = :email " +
                      "and u.car.model = :model " +
                      "and u.car.series = :series",
                      User.class
              )
              .setParameter("fistname", user.getFirstName())
              .setParameter("lastname", user.getLastName())
              .setParameter("email", user.getEmail())
              .setParameter("model", user.getCar().getModel())
              .setParameter("series", user.getCar().getSeries())
              .getResultList()
              .isEmpty();
   }
}
