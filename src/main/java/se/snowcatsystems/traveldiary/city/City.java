package se.snowcatsystems.traveldiary.city;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
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
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "1071"),
                    @Parameter(name = "increment_value", value = "1")
            }
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "population")
    private int population;
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
}


