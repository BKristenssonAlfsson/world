package se.snowcatsystems.traveldiary.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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
            return new ResponseEntity<>(reply, HttpStatus.OK);
        } else {
            reply = "Sadly something went bad. Please inform an administrator!";
            return new ResponseEntity<>(reply, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<LanguageModel>> getAllLanguages() {
        List<LanguageModel> languages = languageService.getAllLanguages();

        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<LanguageModel> getLanguage(@RequestParam String language) {
        LanguageModel languageModel = languageService.findLanguageByName(language);

        return new ResponseEntity<>(languageModel, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<String> updateLanguage(@RequestBody LanguageModel languageModel) {


        Boolean check = languageService.updateLanguage(languageModel);

        String reply = "";

        if (check){
            reply = "Language " + languageModel.getLanguage() + " was updated. Thank you";
            return new ResponseEntity<>(reply, HttpStatus.OK);
        } else {
            reply = "Language " + languageModel.getLanguage() + " was not updated.";
            return new ResponseEntity<>(reply, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> removeLanguageFromCountry(@RequestBody LanguageModel languageModel) {
        Boolean check = languageService.removeCountryFromLanguage(languageModel);
        String reply = "";
        if (check){
            reply = "Language " + languageModel.getLanguage() + " was updated. Thank you";
            return new ResponseEntity<>(reply, HttpStatus.OK);
        } else {
            reply = "Language " + languageModel.getLanguage() + " was not found.";
            return new ResponseEntity<>(reply, HttpStatus.BAD_REQUEST);
        }
    }
}
