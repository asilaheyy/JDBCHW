import javax.persistence.EntityManager;
import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String passw = "1945";
        final String url = "jdbc:postgresql://localhost:5432/prosky";


        try (final Connection connection = DriverManager.getConnection(url, user, passw);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = ?")) {
            statement.setInt(1, 2);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String nameOfEmployee = "Name: " + resultSet.getString("first_name");
                String lastNameOfEmpoyee = "Last name: " + resultSet.getString("last_name");
                int employeeId = resultSet.getInt(1);
                System.out.println(nameOfEmployee);
                System.out.println(lastNameOfEmpoyee);
                System.out.println("ID: " + employeeId);
            }
            //Новый созданный сотрудник не добавляется в общий список
            EmployeeDAO employeeDAO = new EmployeeDAOimpl(connection);
            Employee employee = new Employee(5, "Alisa", "Aleksandrova", 21, "Female", new City(1, "SPB"));
            employeeDAO.create(employee);

            System.out.println(employee);
            System.out.println(employeeDAO.readAll());


            //////////////////////////////////////////////////////////////////////////////////////


            //СОЗДАНИЕ СОТРУДНИКОВ
    /*hibernateSessionFactoryUtil.withEntityManager(em -> {
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
}
