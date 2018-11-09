package city.transactions;

import city.domain.City;

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
    public void addCity(City city) {
    	em.persist(city);
    	em.flush();
    }

    @Override
    public void removeCity(String name) {
		Query q = em.createNativeQuery("DELETE FROM cities WHERE name = :city", City.class);
		q.setParameter("city", name).executeUpdate();
    }

    @Override
    public List<City> showAllCities() {
		Query q = em.createNativeQuery("SELECT * FROM cities", City.class);
		List<City> cities = q.getResultList();
		return cities;
    }

    @Override
    public String getCityByName(String name) {
    	Query q = em.createNativeQuery("SELECT * FROM cities WHERE name = :city", City.class);
    	q.setParameter("city", name);
    	List<City> result = q.getResultList();
    	return result.toString();
    }

    public List<City> getCitiesBetweenMinMaxPopulation(String min, String max){
      Query q = em.createNativeQuery("SELECT * FROM cities WHERE population >= :minimum AND population <= :maximum", City.class);
      q.setParameter("minimum", min);
      q.setParameter("maximum", max);
      List<City> result = q.getResultList();
      return result;
    }

	public City findByCityName(String name) {
		Query q = em.createNativeQuery("SELECT * FROM cities WHERE name= :city", City.class);
		q.setParameter("city", name);
		return (City)q.getSingleResult();
		
	}
    
	@Override
	public void updateCity(String name, String newName, Integer population) {
		City e = findByCityName(name);
		e.setName(newName);
		e.setPopulation(population);
	}
}