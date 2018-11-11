package language.dao;

import language.domain.Language;
import javax.ejb.Local;
import java.util.List;

@Local
public interface LanguageDAOlocal {
    public List<Language> listAllLanguages();
}
