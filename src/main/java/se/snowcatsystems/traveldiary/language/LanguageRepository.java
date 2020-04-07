package se.snowcatsystems.traveldiary.language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("DELETE FROM Language WHERE language = :language")
    Language deleteByName(@Param("language") String language);

    @Query("SELECT lang FROM Language lang WHERE language = :language")
    Language findByName(@Param("language") String language);
}
