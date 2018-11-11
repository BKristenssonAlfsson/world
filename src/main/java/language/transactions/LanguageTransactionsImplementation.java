package language.transactions;

import language.domain.Language;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Default
public class LanguageTransactionsImplementation implements LanguageDataAccess {

    @PersistenceContext(unitName="world")
    private EntityManager em;

    @Override
    public List<Language> listAllLanguages() {
        Query q = em.createNativeQuery("SELECT  * FROM language", Language.class);
        List<Language> languages = ((Query) q).getResultList();
        return languages;
    }
 }
