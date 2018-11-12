package world.dao;

import world.domain.City;
import world.domain.Language;
import world.domain.Continent;
import world.domain.Country;
import world.transactions.CityDataAccess;
import world.transactions.ContinentDataAccess;
import world.transactions.CountryDataAccess;
import world.transactions.LanguageDataAccess;

import javax.ejb.*;
import javax.inject.*;
import java.util.List;

@Stateless
public class WorldDataAccess implements DataAccessLocal, DataAccessRemote {

  @Inject
  private CityDataAccess cityDataAccess;

  @Inject
  private ContinentDataAccess continentDataAccess;

  @Inject
  private CountryDataAccess countryDataAccess;

  @Inject
  private LanguageDataAccess languageDataAccess;

  public void addCity(City city) {
    cityDataAccess.addCity(city);
  }
  public void removeCity(String city) {
    cityDataAccess.removeCity(city);
  }
  public List<City> showAllCities() {
    return cityDataAccess.showAllCities();
  }

  public String getCityByName(String name) {
    return cityDataAccess.getCityByName(name);
  }

  public List<City> getCitiesBetweenMinMaxPopulation(String min, String max) {
    return cityDataAccess.getCitiesBetweenMinMaxPopulation(min, max);
  }

  public void updateCity(String name, String newName, Integer population) {
	cityDataAccess.updateCity(name, newName, population);
  }

  public List<Continent> showAllContinents() { return continentDataAccess.showAllContinents(); }

  public List<Country> showAllCountries() { return countryDataAccess.showAllCountries(); }

  public List<Language> listAllLanguages() { return languageDataAccess.listAllLanguages(); }

}
