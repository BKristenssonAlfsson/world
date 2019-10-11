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

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private CountryRepository countryRepository;

    private ContinentModel continentModel = new ContinentModel();

    public List<ContinentModel> findAllContinents() {

        List<Continent> continents = continentRepository.findAll();
        List<Country> country = countryRepository.findAll();
        Long count[] = new Long[7];

        for ( int i = 0; i < 7; i++ ) {
            final int countryNumber = i;
            count[i] = country.stream().filter(c -> c.getContinent().equals(countryNumber)).count();
        }

        List<ContinentModel> models = continentModel.getModelList(continents);

        models.forEach(model -> {
            if ( model.getContinent().equals("Africa")) {
                model.setCountries(count[1].intValue());
            } else if (model.getContinent().equals("Asia")) {
                model.setCountries(count[2].intValue());
            }else if (model.getContinent().equals("Europe")) {
                model.setCountries(count[3].intValue());
            }else if (model.getContinent().equals("North America")) {
                model.setCountries(count[4].intValue());
            }else if (model.getContinent().equals("Oceania")) {
                model.setCountries(count[5].intValue());
            }else if (model.getContinent().equals("South America")) {
                model.setCountries(count[6].intValue());
            }
        });

        return models;
    }
}
