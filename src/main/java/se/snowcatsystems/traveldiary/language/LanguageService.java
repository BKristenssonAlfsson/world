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

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private CountryRepository countryRepository;

    public Boolean addNewLanguage(LanguageModel languageModel) {
        language.setLanguage(languageModel.getLanguage());

        Set<Country> countries = new HashSet<>();

        languageModel.getCountry().forEach(country -> {
            Country found = countryRepository.findByName(country);
            countries.add(found);
        });

        countries.forEach(country -> {
            country.getLanguages().add(language);
            languageRepository.save(language);
        });

        return true;
    }

    public List<LanguageModel> getAllLanguages() {
        List<Language> languages = languageRepository.findAll();

        return languageModel.generateModels(languages);
    }

    public void updateLanguage(LanguageModel languageModel) {
        language.setLanguage(languageModel.getLanguage());

        language = languageRepository.findByName(languageModel.getLanguage());

        if(language != null) {
            System.out.println("Language found");

        } else {
            System.out.println("No language found!");
        }

        Set<Country> countries = new HashSet<>();

        languageModel.getCountry().forEach(country -> {
            Country found = countryRepository.findByName(country);
            found.removeLanguage(language);
            countries.add(found);
        });

        countries.forEach(country -> {
            country.getLanguages().add(language);
            languageRepository.save(language);
        });

    }
}
