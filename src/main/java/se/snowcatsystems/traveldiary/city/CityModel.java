package world.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CityModel {

    private int id;
    private String name;
    private int population;
    private int country;
    private int continent;
}
