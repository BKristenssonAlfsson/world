package se.snowcatsystems.traveldiary.city;

import lombok.*;
import se.snowcatsystems.traveldiary.continent.Continent;
import se.snowcatsystems.traveldiary.country.Country;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "population")
    private int population;
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
}


