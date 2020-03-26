package se.snowcatsystems.traveldiary.user;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserModel {

    private String username;
    private String password;
    private List<Role> role;
}
