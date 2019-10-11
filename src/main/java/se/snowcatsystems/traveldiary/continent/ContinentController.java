package se.snowcatsystems.traveldiary.continent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/continent")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @GetMapping
    public ResponseEntity<List<ContinentModel>> getAllContinents() {

        List<ContinentModel> continents = continentService.findAllContinents();

        System.out.println(continents);

        return new ResponseEntity<>(continents, HttpStatus.OK);
    }
}
