package world.transactions;

import world.domain.Language;

import javax.ejb.Local;
import java.util.List;

@Local
public interface LanguageDataAccess {
    public abstract List<Language> listAllLanguages();
}
