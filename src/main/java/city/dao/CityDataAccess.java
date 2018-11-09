package city.dao;

import city.domain.City;
import city.transactions.CityDataAccessInterface;

import javax.ejb.*;
import javax.inject.*;
import java.util.List;

@Stateless
public class CityDataAccess implements DataAccessLocal, DataAccessRemote {

  @Inject
  private CityDataAccessInterface cda;

  public void addCity(City city) {
    cda.addCity(city);
  }
  public void removeCity(String city) {
    cda.removeCity(city);
  }
  public List<City> showAllCities() {
    return cda.showAllCities();
  }

  public String getCityByName(String name) {
    return cda.getCityByName(name);
  }

  public List<City> getCitiesBetweenMinMaxPopulation(String min, String max) {
    return cda.getCitiesBetweenMinMaxPopulation(min, max);
  }

  public void updateCity(String name, String newName, Integer population) {
	cda.updateCity(name, newName, population);
  }

}
