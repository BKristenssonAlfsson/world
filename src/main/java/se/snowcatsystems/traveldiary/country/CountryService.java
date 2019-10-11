package se.snowcatsystems.traveldiary.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    private Country country = new Country();
    private CountryModel countryModel = new CountryModel();

    public List<CountryModel> getAllCountries() {
        List<Country> entity = countryRepository.findAll();
        List<CountryModel> model = countryModel.generateModels(entity);
        return model;
    }
}
