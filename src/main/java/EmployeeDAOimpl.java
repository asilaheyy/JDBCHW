import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAO {

    private Connection connection;

    public EmployeeDAOimpl() {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee readById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employeeList = (List<Employee>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From Employee").list();
        return employeeList;
    }




    @Override
    public void updateEmployee(int id) {
       try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
           Transaction transaction = session.beginTransaction();
           session.update(id);
           transaction.commit();
        }
    }

    @Override
    public void deleteById(int id) {
      try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
          Transaction transaction = session.beginTransaction();
          session.delete(id);
          transaction.commit();
      }
    }



}
