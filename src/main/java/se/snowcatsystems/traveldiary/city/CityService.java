package se.snowcatsystems.traveldiary.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    private CityModel cityModel = new CityModel();
    private City city = new City();

    public List<CityModel> findAll() {

        List<City> cities = cityRepository.findAll();

        List<CityModel> models = cityModel.CityModel(cities);

        return models;
    }
}
