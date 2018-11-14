package world.domain;

import lombok.*;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "continent")
    private Integer continent;
    @Column(name = "country")
    private String name;

    @ManyToOne
    @JoinTable(name="countries_on_continent")
    Continent cont;
}
