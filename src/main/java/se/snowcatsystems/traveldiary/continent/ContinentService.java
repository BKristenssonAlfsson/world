package se.snowcatsystems.traveldiary.continent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.snowcatsystems.traveldiary.country.Country;
import se.snowcatsystems.traveldiary.country.CountryRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ContinentService {

    //TODO: Add dynamic count on languages

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private CountryRepository countryRepository;

    private ContinentModel continentModel = new ContinentModel();

    public List<ContinentModel> findAllContinents() {

        List<Continent> continents = continentRepository.findAll();
        List<Country> country = countryRepository.findAll();
        int[] count = new int[6];
        List<ContinentModel> models = continentModel.getModelList(continents);

        country.forEach(c -> {
            switch (c.getContinent().getContinent()) {
                case "Africa":
                    count[0]++;
                    break;
                case "Asia":
                    count[1]++;
                    break;
                case "Europe":
                    count[2]++;
                    break;
                case "North America":
                    count[3]++;
                    break;
                case "Oceania":
                    count[4]++;
                    break;
                case "South America":
                    count[5]++;
                    break;
            }
        });

        models.forEach(model -> {
            switch (model.getContinent()) {
                case "Africa":
                    model.setCountries(count[0]);
                    break;
                case "Asia":
                    model.setCountries(count[1]);
                    break;
                case "Europe":
                    model.setCountries(count[2]);
                    break;
                case "North America":
                    model.setCountries(count[3]);
                    break;
                case "Oceania":
                    model.setCountries(count[4]);
                    break;
                case "South America":
                    model.setCountries(count[5]);
                    break;
                default:
                    model.setCountries(0);
            }
        });

        return models;
    }
}
