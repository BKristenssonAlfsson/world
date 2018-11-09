package transactions;

import domain.Cities;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Default
public class TransactionsImplementation implements CityDataAccessInterface {

    @PersistenceContext(unitName="world")
    private EntityManager em;

    @Override
    public void addCity(Cities city) {
    	em.persist(city);
    	em.flush();
    }

    @Override
    public void removeCity(String name) {
		Query q = em.createNativeQuery("DELETE FROM cities WHERE name = :city", Cities.class);
		q.setParameter("city", name).executeUpdate();
    }

    @Override
    public List<Cities> showAllCities() {
		Query q = em.createNativeQuery("SELECT * FROM cities", Cities.class);
		List<Cities> cities = q.getResultList();
		return cities;
    }

    @Override
    public String getCityByName(String name) {
    	Query q = em.createNativeQuery("SELECT * FROM cities WHERE name = :city", Cities.class);
    	q.setParameter("city", name);
    	List<Cities> result = q.getResultList();
    	return result.toString();
    }

    public List<Cities> getCitiesBetweenMinMaxPopulation(String min, String max){
      Query q = em.createNativeQuery("SELECT * FROM cities WHERE population >= :minimum AND population <= :maximum", Cities.class);
      q.setParameter("minimum", min);
      q.setParameter("maximum", max);
      List<Cities> result = q.getResultList();
      return result;
    }

	public Cities findByCityName(String name) {
		Query q = em.createNativeQuery("SELECT * FROM cities WHERE name= :city", Cities.class);
		q.setParameter("city", name);
		return (Cities)q.getSingleResult();
		
	}
    
	@Override
	public void updateCity(String name, String newName, Integer population) {
		Cities e = findByCityName(name);
		e.setName(newName);
		e.setPopulation(population);
	}
}