package se.snowcatsystems.traveldiary.language;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="language")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name="language", length = 25)
    private String language;
}
