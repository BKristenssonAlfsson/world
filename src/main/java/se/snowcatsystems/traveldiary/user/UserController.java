package se.snowcatsystems.traveldiary.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<HttpStatus> registerUser(@RequestBody UserModel userModel){
        Boolean user = userService.registerNewUser(userModel);

        if (user){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            return ResponseEntity.ok(HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<HttpStatus> deleteUser(@RequestBody UserModel userModel) {
        userService.deleteUser(userModel);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
