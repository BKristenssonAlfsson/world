package se.snowcatsystems.traveldiary.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityModel>> getAllCities() {

        List<CityModel> cities = cityService.findAllCities();

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CityModel> saveCity(@RequestBody CityModel newCity) {
        CityModel city = cityService.storeCity(newCity);

        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}
