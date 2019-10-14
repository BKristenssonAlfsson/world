package se.snowcatsystems.traveldiary.country;

import lombok.*;
import se.snowcatsystems.traveldiary.language.Language;

import java.util.ArrayList;
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
    private String languages;

    public List<CountryModel> generateModels(List<Country> entity) {
        List<CountryModel> cm = new ArrayList();

        entity.forEach(model -> {
            CountryModel countryModel = new CountryModel();
            countryModel.id = model.getId();
            countryModel.name = model.getName();
            countryModel.continent = model.getContinent().getContinent();
            System.out.println(model.getLanguages());
            cm.add(countryModel);
        });

        return cm;
    }
}
