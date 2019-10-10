package se.snowcatsystems.traveldiary.continent;


import lombok.*;
import se.snowcatsystems.traveldiary.country.Country;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="continent")
@ToString
public class Continent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name="continent")
    private String continent;
    @Column(name="countries")
    private int countries;
    @Column(name="languages")
    private int languages;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "continent")
    private Set<Country> country;
}
