package city.transactions;

import city.domain.Cities;

import javax.ejb.*;
import java.util.List;

@Local
public interface CityDataAccessInterface {
  public abstract void addCity(Cities city);
  public abstract void removeCity(String city);
  public abstract List<Cities> showAllCities();
  public abstract String getCityByName(String name);
  public abstract List<Cities> getCitiesBetweenMinMaxPopulation(String min, String max);
  public abstract void updateCity(String name, String newName, Integer population);
}
