package city.transactions;

import city.domain.City;

import javax.ejb.*;
import java.util.List;

@Local
public interface CityDataAccessInterface {
  public abstract void addCity(City city);
  public abstract void removeCity(String city);
  public abstract List<City> showAllCities();
  public abstract String getCityByName(String name);
  public abstract List<City> getCitiesBetweenMinMaxPopulation(String min, String max);
  public abstract void updateCity(String name, String newName, Integer population);
}
