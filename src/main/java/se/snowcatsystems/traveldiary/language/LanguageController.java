package se.snowcatsystems.traveldiary.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping
    public ResponseEntity<LanguageModel> addLanguage(@RequestBody LanguageModel languageModel) {
        LanguageModel model = languageService.addNewLanguage(languageModel);

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LanguageModel>> getAllLanguages() {
        List<LanguageModel> languages = languageService.getAllLanguages();

        return new ResponseEntity<>(languages, HttpStatus.OK);
    }
}
