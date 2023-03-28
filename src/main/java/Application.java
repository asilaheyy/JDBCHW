import javax.persistence.EntityManager;
import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        HibernateSessionFactoryUtil hibernateSessionFactoryUtil = new HibernateSessionFactoryUtil();


        //СОЗДАНИЕ СОТРУДНИКОВ
      /*  hibernateSessionFactoryUtil.withEntityManager(em -> {
            Employee newemployee = new Employee();
            newemployee.setFirst_name("Artur");
            newemployee.setLast_name("Pirozhkov");
            newemployee.setAge(48);
            newemployee.setGender("Male");
            newemployee.setCity_id(1);
            em.persist(newemployee);
        });

        hibernateSessionFactoryUtil.withEntityManager(em -> {
            Employee employee1 = new Employee();
            employee1.setFirst_name("Alisa");
            employee1.setLast_name("Aleksandrova");
            employee1.setAge(21);
            employee1.setGender("Female");
            employee1.setCity_id(1);
            em.persist(employee1);
        });
*/
        //ПОИСК СОТРУДНИКА ПО ID
        hibernateSessionFactoryUtil.withEntityManager(em -> {
            Employee employeeFromDataBase = em.find(Employee.class,53);
            System.out.println(employeeFromDataBase.getFirst_name());
            System.out.println(employeeFromDataBase.getLast_name());
        });

        //ОБНОВЛЕНИЕ ДАННЫХ СОТРУДНИКА
        hibernateSessionFactoryUtil.withEntityManager(em -> {
            Employee employee = em.find(Employee.class, 53);
            employee.setAge(22);
            employee.setCity_id(3);
            System.out.println(employee);
        });

        //ВЫВОД ВСЕХ СОТРУДНИКОВ
        hibernateSessionFactoryUtil.withEntityManager(em ->{
            List<Employee> allEmployees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
            System.out.println(allEmployees);
        });

      /* НАХОДИМ СОТРУДНИКА ПО ID
       hibernateSessionFactoryUtil.withEntityManager(em -> {
            Employee employee = em.find(Employee.class, 31);
            System.out.println(employee.getFirst_name());
            System.out.println(employee.getLast_name());
        });
*/
       /* УДАЛЯЕМ СОТРУДНИКА ПО ID
       hibernateSessionFactoryUtil.withEntityManager(em -> {
            Employee employee = em.find(Employee.class, 31);
            em.remove(employee);

        });*/

    }
}
