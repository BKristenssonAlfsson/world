package world.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
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
@XmlRootElement
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
