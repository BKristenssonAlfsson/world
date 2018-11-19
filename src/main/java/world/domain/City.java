package world.domain;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@XmlRootElement
public class City implements Serializable {

// SELECT city.population, city.name, country.country, continent.continent FROM
// CITY JOIN COUNTRY ON city.country = country.id JOIN continent ON
// city.continent = continent.id WHERE city.id = 1

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "population")
    private int population;
    @OneToOne
    @JoinColumn(name = "country", referencedColumnName = "id")
    private Country country;
    @OneToOne
    @JoinColumn(name = "continent", referencedColumnName = "id")
    private Continent continent;
}


