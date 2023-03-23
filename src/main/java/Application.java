import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();



        List<Employee> list = employeeDAO.readAll();
        for (Employee employee : list){
            System.out.println(employee);
        }
        employeeDAO.updateEmployee(3);

        /*final String user = "postgres";
        final String passw = "1945";
        final String url = "jdbc:postgresql://localhost:5432/prosky";


        try(final Connection connection = DriverManager.getConnection(url, user, passw);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = ?")){
            statement.setInt(1, 2);
            final ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while (resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                String nameOfEmployee = "Name: " + resultSet.getString("first_name");
                String lastNameOfEmpoyee = "Last name: " + resultSet.getString("last_name");
                int employeeId = resultSet.getInt(1);

                // Выводим данные в консоль
                System.out.println(nameOfEmployee);
                System.out.println(lastNameOfEmpoyee);
                System.out.println("ID: " + employeeId);
            }

            //Новый созданный сотрудник не добавляется в общий список
        EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            City city = new City(4, "NSK");


            System.out.println(employeeDAO.readAll().toString());

        }*/



    }
}
