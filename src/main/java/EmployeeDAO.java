import java.util.List;

public interface EmployeeDAO {

    // Добавление объекта
    void create(Employee employee);

    // Получение объекта по id
    Employee readById(int id);

    // Получение всех объектов
    List<Employee> readAll();

    // Изменение объекта по id
    void updateEmployeeById(int id, String first_name, String last_name, int age, String gender, int city_id);

    // Удаление объекта по id
    void deleteById(int id);


}
