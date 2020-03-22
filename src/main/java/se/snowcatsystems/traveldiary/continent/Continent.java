package se.snowcatsystems.traveldiary.continent;


import lombok.*;
import se.snowcatsystems.traveldiary.city.City;
import se.snowcatsystems.traveldiary.country.Country;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="continent")
public class Continent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name="continent")
    private String continent;
    @Column(name="countries")
    private Integer countries;
    @Column(name="languages")
    private Integer languages;
    @OneToMany(mappedBy = "continent",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private Set<Country> country = new HashSet<>();
}
