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

    public LanguageModel addNewLanguage(LanguageModel languageModel) {
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

        return null;
    }

    public List<LanguageModel> getAllLanguages() {
        List<Language> languages = languageRepository.findAll();

        List<LanguageModel> languageModels = languageModel.generateModels(languages);
        return languageModels;
    }
}
