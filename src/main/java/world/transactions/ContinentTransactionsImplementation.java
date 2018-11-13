package world.transactions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

    private Logger logger = LogManager.getLogger(ContinentTransactionsImplementation.class.getName());

    @PersistenceContext(unitName="world")
    private EntityManager em;

    @Override
    public List<Continent> showAllContinents() {
        Query q = em.createNativeQuery("SELECT * FROM continent", Continent.class);
        List<Continent> continents = q.getResultList();
        return continents;
    }

    @Override
    public List<Continent> showDetailsAboutContinent(Integer id) {
        Query q = em.createNativeQuery("SELECT * FROM continent WHERE id = :id", Continent.class);
        q.setParameter("id", id);
        List<Continent> continent = q.getResultList();
        return continent;
    }

    @Override
    
}
