package se.snowcatsystems.traveldiary.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class UserService {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Boolean registerNewUser(UserModel userModel) {
        final User user = new User();
        //TODO Check if user is already created, if so return true
        Instant instant = Instant.now().truncatedTo(ChronoUnit.MILLIS);
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setUsername(userModel.getUsername());
        user.setActive(user.getActive());
        user.setRoles(userModel.getRole());
        user.setTimestamp(instant);
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setEmail("S@S.t");
        user.setCreatedTimestamp(instant);

        userRepository.save(user);
        return false;
    }
}
