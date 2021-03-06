package se.snowcatsystems.traveldiary.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.snowcatsystems.traveldiary.country.Country;
import se.snowcatsystems.traveldiary.country.CountryRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LanguageService {

    private LanguageModel languageModel = new LanguageModel();
    private Language language = new Language();
    private Set<Country> countries = new HashSet<>();

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private CountryRepository countryRepository;

    public Boolean addNewLanguage(LanguageModel languageModel) {
        language.setLanguage(languageModel.getLanguage());

        clearSet();

        countries = addCountries(languageModel);

        linkCountryAndLanguage(countries);

        return true;
    }

    public List<LanguageModel> getAllLanguages() {
        List<Language> languages = languageRepository.findAll();

        return languageModel.generateModels(languages);
    }

    private Language findLanguage(String language) {
        return languageRepository.findByName(language);
    }

    private Set<Country> findCountries( Language language ) {
        if(language != null) {
            language.getCountries().forEach(country -> {
                Country found = countryRepository.findByName(country.getName());
                countries.add(found);
            });
        }
        return countries;
    }

    private void clearSet() {
        countries.clear();
    }

    private Set<Country> addCountries(LanguageModel languageModel) {
        languageModel.getCountry().forEach(country -> {
            Country found = countryRepository.findByName(country);
            countries.add(found);
        });
        return countries;
    }

    private void linkCountryAndLanguage(Set<Country> countries) {
        countries.forEach(country -> {
            country.getLanguages().add(language);
            languageRepository.save(language);
        });
    }

    public Boolean updateLanguage(LanguageModel languageModel) {
        language.setLanguage(languageModel.getLanguage());

        if (language != null) {
            clearSet();

            language = findLanguage(languageModel.getLanguage());

            countries = findCountries(language);

            countries = addCountries(languageModel);

            linkCountryAndLanguage(countries);

            return true;
        }
        return false;
    }

    public Boolean removeCountryFromLanguage(LanguageModel languageModel) {
        language = findLanguage(languageModel.getLanguage());

        if (language != null ){
            Country country = new Country();

            languageModel.getCountry().forEach(country::setName);

            Country toRemoveFromLanguage = countryRepository.findByName(country.getName());
            toRemoveFromLanguage.removeLanguage(language);

            languageRepository.flush();
            return true;
        }
        return false;
    }

    public LanguageModel findLanguageByName(String language) {
        this.language = findLanguage(language);

        if ( this.language == null ){
            return languageModel.noLanguageFound(language);
        } else {
            return languageModel.singleLanguage(this.language);
        }
    }
}
