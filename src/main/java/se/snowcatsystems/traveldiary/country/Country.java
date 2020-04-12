package se.snowcatsystems.traveldiary.country;

import lombok.*;
import se.snowcatsystems.traveldiary.city.City;
import se.snowcatsystems.traveldiary.continent.Continent;
import se.snowcatsystems.traveldiary.language.Language;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Continent continent;
    @Column(name = "country")
    private String name;
    @OneToMany(mappedBy = "country",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<City> city = new HashSet<>();
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "country_language",
        joinColumns = {@JoinColumn(name = "country_id")},
        inverseJoinColumns = {@JoinColumn(name = "language_id")})
    private Set<Language> languages;

    public void addLanguage(Language language) {
        this.languages.add(language);
        language.getCountries().add(this);
    }

    public void removeLanguage(Language language) {
        this.languages.remove(language);
        language.getCountries().remove(this);
    }
}