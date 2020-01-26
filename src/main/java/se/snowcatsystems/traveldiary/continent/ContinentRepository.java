package se.snowcatsystems.traveldiary.continent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContinentRepository extends JpaRepository<Continent, Long> {

    @Query(value = "SELECT * FROM Continent WHERE continent = :continent", nativeQuery = true)
    Continent findByName(@Param("continent") String continent);
}
