package se.snowcatsystems.traveldiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TravelDiaryApplication {

    /*
    TODO: Add Exception handling
    TODO: Add User account details (blog, saved travels etc)
    TODO: When searching for a country, list all cities connected to it.
     */
    public static void main(String[] args) {
        SpringApplication.run(TravelDiaryApplication.class, args);
    }

}
