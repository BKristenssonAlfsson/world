package se.snowcatsystems.traveldiary.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT city FROM City city WHERE name =:name")
    City findByName(@Param("name") String name);
}
