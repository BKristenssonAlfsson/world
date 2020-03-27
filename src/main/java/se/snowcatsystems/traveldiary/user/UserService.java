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
        Instant instant = Instant.now().truncatedTo(ChronoUnit.MILLIS);

        user.setUsername(userModel.getUsername());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setLastLogin(instant);
        user.setCreatedTimestamp(instant);
        user.setActive(user.getActive());
        user.setRoles(userModel.getRole());
        user.setActive(userModel.getActive());

        User exist = userRepository.findByUsername(user.getUsername());
        if ( exist == null ) {
            userRepository.save(user);
            return false;
        } else {
            return true;
        }
    }
}
