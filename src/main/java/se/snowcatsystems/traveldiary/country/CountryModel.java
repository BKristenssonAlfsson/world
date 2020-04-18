package se.snowcatsystems.traveldiary.country;

import lombok.*;
import se.snowcatsystems.traveldiary.language.Language;

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
    private Set<String> cities = new HashSet<>();

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
            model.getCity().forEach(city -> {
                countryModel.cities.add(city.getName() + ". Population: " + city.getPopulation() );
            });
            cm.add(countryModel);
        });

        return cm;
    }

    public CountryModel noCountryFound(String land) {
        CountryModel countryModel = new CountryModel();
        countryModel.setName("The country " + land + " was not found. Did you spell it right?");
        return countryModel;
    }

    public CountryModel singleCountry(Country country) {
        CountryModel countryModel = new CountryModel();
        countryModel.setName(country.getName());
        countryModel.setContinent(country.getContinent().getContinent());
        country.getLanguages().forEach(language -> {
            countryModel.languages.add(language.getLanguage());
        });
        country.getCity().forEach(city -> {
            countryModel.cities.add(city.getName() + ". Population: " + city.getPopulation() );
        });
        return countryModel;
    }
}
