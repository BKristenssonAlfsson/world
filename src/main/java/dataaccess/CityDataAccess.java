package dataaccess;

import domain.Cities;
import transactions.CityDataAccessInterface;

import javax.ejb.*;
import javax.inject.*;
import java.util.List;

@Stateless
public class CityDataAccess implements DataAccessLocal, DataAccessRemote {

  @Inject
  private CityDataAccessInterface cda;

  public void addCity(Cities city) {
    cda.addCity(city);
  }
  public void removeCity(String city) {
    cda.removeCity(city);
  }
  public List<Cities> showAllCities() {
    return cda.showAllCities();
  }

  public String getCityByName(String name) {
    return cda.getCityByName(name);
  }

  public List<Cities> getCitiesBetweenMinMaxPopulation(String min, String max) {
    return cda.getCitiesBetweenMinMaxPopulation(min, max);
  }

  public void updateCity(String name, String newName, Integer population) {
	cda.updateCity(name, newName, population);
  }

}
