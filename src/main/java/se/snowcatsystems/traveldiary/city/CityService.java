package se.snowcatsystems.traveldiary.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.snowcatsystems.traveldiary.continent.Continent;
import se.snowcatsystems.traveldiary.continent.ContinentRepository;
import se.snowcatsystems.traveldiary.country.Country;
import se.snowcatsystems.traveldiary.country.CountryRepository;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ContinentRepository continentRepository;

    private CityModel cityModel = new CityModel();
    private City city = new City();

    public List<CityModel> findAllCities() {

        List<City> cities = cityRepository.findAll();

        List<CityModel> models = cityModel.cityModelList(cities);

        return models;
    }

    public CityModel storeCity(CityModel cityModel) {
        //Requires Cityname, Population and Country
            System.out.println(cityModel.toString());

            city.setName(cityModel.getName());
            city.setPopulation(cityModel.getPopulation());

            Country test = countryRepository.findByName(cityModel.getCountry());
        System.out.println(test.toString());
        //    city.getCountry().add(test);
//            city.setContinent(continentRepository.findByName(cityModel.getContinent()));

            System.out.println(city.toString());

        return null;
    }
}
