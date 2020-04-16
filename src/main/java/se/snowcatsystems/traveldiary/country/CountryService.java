package se.snowcatsystems.traveldiary.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.snowcatsystems.traveldiary.language.LanguageModel;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryService {

    //TODO: Add Update country

    @Autowired
    private CountryRepository countryRepository;

    private Country country = new Country();
    private CountryModel countryModel = new CountryModel();

    public List<CountryModel> getAllCountries() {
        List<Country> entity = countryRepository.findAll();
        List<CountryModel> model = countryModel.generateModels(entity);
        return model;
    }

    public CountryModel findCountry(String land) {
        this.country = searchCountry(land);

        if (this.country == null) {
            return countryModel.noCountryFound(land);
        } else {
            return countryModel.singleCountry(this.country);
        }
    }


    private Country searchCountry(String country) {
        return this.country = countryRepository.findByName(country);
    }
}
