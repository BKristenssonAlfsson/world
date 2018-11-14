package world.dao;

import world.domain.City;
import world.domain.Continent;
import world.domain.Country;
import world.domain.Language;

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
  public List<Continent> showAllContinents();
  public List<Country> showAllCountries();
  public List<Language> listAllLanguages();
  public List<Continent> listAllCountriesOnContinent(Integer continent);
}
