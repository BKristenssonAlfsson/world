package se.snowcatsystems.traveldiary.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public LanguageModel addNewLanguage(LanguageModel languageModel) {
        return null;
    }

    public List<Language> getAllLanguages() {
        List<Language> languages = languageRepository.findAll();

        return languages;
    }
}
