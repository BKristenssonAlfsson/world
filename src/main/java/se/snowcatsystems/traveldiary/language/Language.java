package se.snowcatsystems.traveldiary.language;

import lombok.*;
import se.snowcatsystems.traveldiary.country.Country;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="language")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="language", length = 25)
    private String language;

    @ManyToMany(mappedBy = "languages")
    private Set<Country> countries;
}
