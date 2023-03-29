


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

public class HibernateSessionFactoryUtil {
    private SessionFactory sessionFactory;

    public HibernateSessionFactoryUtil() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(City.class);
        this.sessionFactory = configuration.buildSessionFactory();
    }


    public  void withEntityManager(Consumer<EntityManager> function) {
        try (Session session = this.sessionFactory.openSession()) {

            session.beginTransaction();
            function.accept(session);
            session.getTransaction().commit();
        }
    }
}

