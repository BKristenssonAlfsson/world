package se.snowcatsystems.traveldiary.country;

import lombok.*;
import se.snowcatsystems.traveldiary.continent.Continent;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountryModel {

    private Long id;
    private String continent;
    private String name;

    public List<CountryModel> generateModels(List<Country> entity) {

        List<CountryModel> cm = new ArrayList();

        entity.forEach(model -> {
            CountryModel countryModel = new CountryModel();
            countryModel.id = model.getId();
            countryModel.name = model.getName();
            countryModel.continent = model.getContinent().getContinent();
            cm.add(countryModel);
        });

        return cm;
    }
}
