package world.transactions;


import world.domain.Country;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Default
public class CountryTransactionsImplementation implements CountryDataAccess {

    @PersistenceContext(unitName="world")
    private EntityManager em;

    @Override
    public List<Country> showAllCountries() {
        Query q = em.createNativeQuery("SELECT * FROM country", Country.class);

        List<Country> countries = q.getResultList();
        return countries;
    }
}
