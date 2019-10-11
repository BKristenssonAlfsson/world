package se.snowcatsystems.traveldiary.continent;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ContinentModel {

    private Long id;
    private String continent;
    private Integer countries;
    private Integer languages;

    public List<ContinentModel> getModelList(List<Continent> continents) {

        List<ContinentModel> models = new ArrayList<>();

        continents.forEach(continent -> {
            ContinentModel continentModel = new ContinentModel();
            continentModel.id = continent.getId();
            continentModel.continent = continent.getContinent();
            continentModel.countries = continent.getCountries();
            continentModel.languages = continent.getLanguages();
            models.add(continentModel);
        });

        return models;
    }
}
