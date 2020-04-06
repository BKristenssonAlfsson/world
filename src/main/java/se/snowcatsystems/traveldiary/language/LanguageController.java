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
    public ResponseEntity<String> addLanguage(@RequestBody LanguageModel languageModel) {
        Boolean model = languageService.addNewLanguage(languageModel);

        String reply = "";

        if (model){
            reply = "Language " + languageModel.getLanguage() + " was added. Thank you";
        } else {
            reply = "Sadly something went bad. Please inform an administrator!";
        }

        return new ResponseEntity<>(reply, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LanguageModel>> getAllLanguages() {
        List<LanguageModel> languages = languageService.getAllLanguages();

        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<LanguageModel> updateLanguage(@RequestBody LanguageModel languageModel) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
