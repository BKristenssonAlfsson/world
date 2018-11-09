package city.dao;

import city.domain.City;

import javax.ejb.*;
import java.util.List;

@Local
public interface DataAccessLocal {
  public void addCity(City city);
  public void removeCity(String name);
  public List<City> showAllCities();
  public String getCityByName(String name);
  public List<City> getCitiesBetweenMinMaxPopulation(String cityOne, String cityTwo);
  public void updateCity(String name, String newName, Integer population);
}
