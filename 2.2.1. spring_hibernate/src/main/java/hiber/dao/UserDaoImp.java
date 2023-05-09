package hiber.dao;

import com.mysql.cj.Session;
import hiber.model.Car;
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
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listOwners(String model, int series) {
      String HQL="from User usr where usr.userCar.model =:carModel and usr.userCar.series =:carSeries";

      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery(HQL, User.class)
              .setParameter("carModel", model)
              .setParameter( "carSeries",series);
      return query.getResultList();

   }

}
