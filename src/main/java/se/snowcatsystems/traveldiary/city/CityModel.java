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
            models.add(cityModel);
        });

        return models;
    }
}
