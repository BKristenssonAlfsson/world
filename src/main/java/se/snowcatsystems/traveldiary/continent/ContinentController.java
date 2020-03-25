package se.snowcatsystems.traveldiary.continent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private final static Logger logger = LogManager.getLogger(ContinentController.class);

    @Autowired
    private ContinentService continentService;

    @GetMapping
    public ResponseEntity<List<ContinentModel>> getAllContinents() {
        List<ContinentModel> continents = continentService.findAllContinents();

        return new ResponseEntity<>(continents, HttpStatus.OK);
    }
}
