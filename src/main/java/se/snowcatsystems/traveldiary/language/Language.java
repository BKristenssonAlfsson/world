package se.snowcatsystems.traveldiary.language;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
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
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "language_sequence"),
                    @Parameter(name = "initial_value", value = "240"),
                    @Parameter(name = "increment_value", value = "1")
            }
    )
    private Long id;

    @Column(name="language", length = 25)
    private String language;

    @ManyToMany(mappedBy = "languages",
            cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH }, fetch = FetchType.LAZY)
    private Set<Country> countries;
}
