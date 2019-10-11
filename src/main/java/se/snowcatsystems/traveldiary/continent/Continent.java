package se.snowcatsystems.traveldiary.continent;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

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
}
