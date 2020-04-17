package se.snowcatsystems.traveldiary.city;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CityModel {

    private Long id;
    private String name;
    private int population;
    private String country;
    private String continent;

    public List<CityModel> cityModelList(List<City> cities) {

        List<CityModel> models = new ArrayList<>();

        cities.forEach(city -> {
            CityModel cityModel = new CityModel();
            cityModel.id = city.getId();
            cityModel.name = city.getName();
            cityModel.population = city.getPopulation();
            cityModel.country = city.getCountry().getName();
            cityModel.continent = city.getCountry().getContinent().getContinent();
            models.add(cityModel);
        });

        return models;
    }

    public CityModel toModel(City city) {
        CityModel cityModel = new CityModel();
        cityModel.name = city.getName();
        cityModel.population = city.getPopulation();
        cityModel.country = city.getCountry().getName();
        cityModel.continent = city.getCountry().getContinent().getContinent();

        return cityModel;
    }

    public CityModel noCityFound(String city) {
        CityModel cityModel = new CityModel();
        cityModel.name = "Sorry, the city " + city + " was not found!";

        return cityModel;
    }
}
