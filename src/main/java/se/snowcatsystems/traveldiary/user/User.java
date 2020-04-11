package se.snowcatsystems.traveldiary.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name ="person")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column()
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "last_login")
    private Instant lastLogin;

    @Column(name = "created")
    private Instant createdTimestamp;

    private Integer active;

    private String permissions = "";

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;

}
