package dataaccess;

import domain.Cities;

import javax.ejb.*;
import java.util.List;

@Local
public interface DataAccessLocal {
  public void addCity(Cities city);
  public void removeCity(String name);
  public List<Cities> showAllCities();
  public String getCityByName(String name);
  public List<Cities> getCitiesBetweenMinMaxPopulation(String cityOne, String cityTwo);
public void updateCity(String name, String newName, Integer population);
}
