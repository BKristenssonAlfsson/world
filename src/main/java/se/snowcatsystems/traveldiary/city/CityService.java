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

        return cityModel.cityModelList(cities);
    }

    //TODO: Return value
    public CityModel storeCity(CityModel cityModel) {
            city.setName(cityModel.getName());
            city.setPopulation(cityModel.getPopulation());
            Country country = countryRepository.findByName(cityModel.getCountry());
            city.setCountry(country);
            cityRepository.save(city);
        return null;
    }

    public CityModel findOneCity(String cityModel) {
        city = cityRepository.findByName(cityModel);
        if (city == null) {
            return this.cityModel.noCityFound(cityModel);
        } else {
            return this.cityModel.toModel(city);
        }
    }
}
