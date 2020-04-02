package se.snowcatsystems.traveldiary.country;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryModel {

    private Long id;
    private String continent;
    private String name;
    private Set<String> languages = new HashSet<>();

    public List<CountryModel> generateModels(List<Country> entity) {
        List<CountryModel> cm = new ArrayList<>();

        entity.forEach(model -> {
            CountryModel countryModel = new CountryModel();
            countryModel.id = model.getId();
            countryModel.name = model.getName();
            countryModel.continent = model.getContinent().getContinent();
            model.getLanguages().forEach(language -> {
               countryModel.languages.add(language.getLanguage());
            });
            cm.add(countryModel);
        });

        return cm;
    }
}
