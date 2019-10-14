package se.snowcatsystems.traveldiary.country;

import lombok.*;
import se.snowcatsystems.traveldiary.continent.Continent;
import se.snowcatsystems.traveldiary.language.Language;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="continent")
    private Continent continent;
    @Column(name = "country")
    private String name;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "country_language",
        joinColumns = {@JoinColumn(name = "country_id")},
        inverseJoinColumns = {@JoinColumn(name = "language_id")})
    private Set<Language> languages;
}