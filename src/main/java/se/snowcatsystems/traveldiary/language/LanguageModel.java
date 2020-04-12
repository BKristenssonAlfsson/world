package se.snowcatsystems.traveldiary.language;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageModel {

    private String language;
    private Set<String> country = new HashSet<>();

    public List<LanguageModel> generateModels(List<Language> languages) {
        List<LanguageModel> languageModels = new ArrayList<>();

        languages.forEach(language -> {
            LanguageModel languageModel = new LanguageModel();
            languageModel.setLanguage(language.getLanguage());
            language.getCountries().forEach(countries -> {
               languageModel.country.add(countries.getName());
            });

            languageModels.add(languageModel);
        });
        return languageModels;
    }
}
