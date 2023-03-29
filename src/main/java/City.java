import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {


    @Id
    private int id;

    @OneToMany(mappedBy = "city", cascade =CascadeType.ALL )
    private List<Employee> employeesFromThisCity = new ArrayList<>();

    private String city_name;

    public City(){
    }

    public List<Employee> getEmployeesFromThisCity() {
        return employeesFromThisCity;
    }

    public String cityNameAndID(){
        return this.id + " " +this.city_name;
    }

    public City(int id,String city_name) {
        this.id=id;
        this.city_name = city_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && Objects.equals(city_name, city.city_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city_name);
    }
    @Override
    public String toString() {
        return
                "\n"+"CITY ID: "+ id+"\n"+
                "CITY NAME: "+city_name + "\n"
                ;
    }
}
