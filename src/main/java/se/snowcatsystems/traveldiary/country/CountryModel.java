package se.snowcatsystems.traveldiary.country;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountryModel {

    private Long id;
    private Integer continent;
    private String name;

    public List<CountryModel> generateModels(List<Country> entity) {

        List<CountryModel> cm = new ArrayList();

        entity.forEach(model -> {
            CountryModel countryModel = new CountryModel();
            countryModel.id = model.getId();
            countryModel.continent = model.getContinent();
            countryModel.name = model.getName();
            cm.add(countryModel);
        });

        return cm;
    }
}
