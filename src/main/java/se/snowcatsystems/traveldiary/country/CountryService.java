package se.snowcatsystems.traveldiary.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
