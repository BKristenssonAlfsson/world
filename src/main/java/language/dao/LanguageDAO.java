package language.dao;

import language.domain.Language;
import language.transactions.LanguageDataAccess;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LanguageDAO implements LanguageDAOlocal, LanguageDAOremote {

    @Inject
    private LanguageDataAccess cda;

    @Override
    public List<Language> listAllLanguages() {
        return cda.listAllLanguages();
    }
}
