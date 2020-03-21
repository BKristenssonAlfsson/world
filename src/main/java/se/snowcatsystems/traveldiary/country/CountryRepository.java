package se.snowcatsystems.traveldiary.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query(value = "SELECT * FROM Country WHERE country = :country", nativeQuery = true)
    Country findByName(@Param("country") String country);
}
