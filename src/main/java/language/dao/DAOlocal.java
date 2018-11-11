package language.dao;

import language.domain.Language;
import javax.ejb.Local;
import java.util.List;

@Local
public interface DAOlocal {
    public List<Language> listAllLanguages();
}
