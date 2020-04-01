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

        languageModel.getCountry().forEach(country -> {
            Country found = countryRepository.findByName(country);
            System.out.println(found.toString());
        });
//language.getCountries().add(found);
        System.out.println(language.toString());
       // languageRepository.save(language);
        return null;
    }

    public List<LanguageModel> getAllLanguages() {
        List<Language> languages = languageRepository.findAll();

        List<LanguageModel> languageModels = languageModel.generateModels(languages);
        return languageModels;
    }
}
