import javax.persistence.EntityManager;
import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOimpl();

        Employee employee = new Employee("B", "C", 4, "Male",new City(4, "KRD"));

        System.out.println( employeeDAO.readById(61));

        employee.setFirst_name("Hello");
        employeeDAO.updateEmployee(0);






            //////////////////////////////////////////////////////////////////////////////////////


            //СОЗДАНИЕ СОТРУДНИКОВ
   /* hibernateSessionFactoryUtil.withEntityManager(em -> {
          City newCity = new City();
          newCity.setId(3);
          newCity.setCity_name("RND");


            Employee newemployee = new Employee();
            newemployee.setFirst_name("Artur");
            newemployee.setLast_name("Pirozhkov");
            newemployee.setAge(48);
            newemployee.setGender("Male");
            newemployee.setCity(newCity);
            newCity.getEmployeesFromThisCity().add(newemployee);
            em.persist(newCity);
       });

        hibernateSessionFactoryUtil.withEntityManager(em -> {
            Employee employee1 = new Employee();
            employee1.setFirst_name("Alisa");
            employee1.setLast_name("Aleksandrova");
            employee1.setAge(21);
            employee1.setGender("Female");
            employee1.setCity(new City(3,"RND"));
            em.persist(employee1);
        });
*/


            //ПОИСК СОТРУДНИКА ПО ID
        /*hibernateSessionFactoryUtil.withEntityManager(em -> {
            Employee employeeFromDataBase = em.find(Employee.class,1);
            System.out.println(employeeFromDataBase.getFirst_name());
            System.out.println(employeeFromDataBase.getLast_name());
            System.out.println(employeeFromDataBase.getCity().cityNameAndID());
        });*/

            //ОБНОВЛЕНИЕ ДАННЫХ СОТРУДНИКА
       /* hibernateSessionFactoryUtil.withEntityManager(em -> {
            City cityRND = new City(3,"RND");
            Employee employee = em.find(Employee.class, 56);
            employee.setFirst_name("Savva");
            employee.setLast_name("Kozenko");
            employee.setAge(24);
            employee.setGender("Male");
            employee.setCity(cityRND);
            System.out.println(employee);
        });*/

            //ВЫВОД ВСЕХ СОТРУДНИКОВ
      /* hibernateSessionFactoryUtil.withEntityManager(em ->{
            List<Employee> allEmployees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
            System.out.println(allEmployees);
        });*/

      /* НАХОДИМ СОТРУДНИКА ПО ID
       hibernateSessionFactoryUtil.withEntityManager(em -> {
            Employee employee = em.find(Employee.class, 31);
            System.out.println(employee.getFirst_name());
            System.out.println(employee.getLast_name());
        });
*/
            // УДАЛЯЕМ СОТРУДНИКА ПО ID
      /* hibernateSessionFactoryUtil.withEntityManager(em -> {
            Employee employee = em.find(Employee.class, 57);
            em.remove(employee);

        });*/

        }

    }

