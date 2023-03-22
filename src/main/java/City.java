import java.util.Objects;

public class City {
    private int city_id;
    private String city_name;

    public City(){
    }

    public City(int city_id,String city_name) {
        this.city_id=city_id;
        this.city_name = city_name;
    }

    public int getId() {
        return city_id;
    }

    public void setId(int city_id){
        this.city_id = city_id;
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
        return city_id == city.city_id && Objects.equals(city_name, city.city_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city_id, city_name);
    }
    @Override
    public String toString() {
        return
                "\n"+"CITY ID: "+ city_id+"\n"+
                "CITY NAME: "+city_name + "\n"
                ;
    }
}
