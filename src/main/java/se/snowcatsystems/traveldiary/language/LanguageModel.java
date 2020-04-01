package se.snowcatsystems.traveldiary.language;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageModel {

    private String language;
    private Set<String> country;

    public List<LanguageModel> generateModels(List<Language> languages) {
        List<LanguageModel> languageModels = new ArrayList<>();

        languages.forEach(language -> {
            LanguageModel languageModel = new LanguageModel();
            languageModel.setLanguage(language.getLanguage());
            languageModels.add(languageModel);
        });
        return languageModels;
    }
}
