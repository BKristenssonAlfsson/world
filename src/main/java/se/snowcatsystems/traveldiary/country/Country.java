package se.snowcatsystems.traveldiary.country;

import lombok.*;
import se.snowcatsystems.traveldiary.continent.Continent;

import javax.persistence.*;
import java.io.Serializable;

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
}