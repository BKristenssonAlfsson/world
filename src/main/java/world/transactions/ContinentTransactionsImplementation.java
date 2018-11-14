package world.transactions;

import world.domain.Continent;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Default
public class ContinentTransactionsImplementation implements ContinentDataAccess {

    @PersistenceContext(unitName="world")
    private EntityManager em;

    @Override
    public List<Continent> showAllContinents() {
        Query q = em.createNativeQuery("SELECT * FROM continent", Continent.class);
        List<Continent> continents = q.getResultList();
        return continents;
    }

    @Override
    public List<Continent> listAllCountriesOnContinent(Integer id) {
        Query q = em.createNativeQuery("SELECT continent.continent, country.country FROM continent JOIN country ON continent.id = country.continent WHERE continent.id = :id", Continent.class);
        q.setParameter("id", id);
        List<Continent> continent = q.getResultList();
        return continent;
    }
}
