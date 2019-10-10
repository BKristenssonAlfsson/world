package se.snowcatsystems.traveldiary.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.Hibernate;
import se.snowcatsystems.traveldiary.country.Country;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

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
