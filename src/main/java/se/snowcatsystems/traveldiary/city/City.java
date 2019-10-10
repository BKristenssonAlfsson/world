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
@ToString
@Entity
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @OneToOne
    @JoinColumn(name = "continent", referencedColumnName = "id")
    private Continent continent;
    @OneToOne
    @JoinColumn(name = "country", referencedColumnName = "id")
    private Country country;
    @Column(name = "name")
    private String name;
    @Column(name = "population")
    private int population;
}


