package country.dao;

import country.domain.Country;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CountryDAOlocal {

    public List<Country> showAllCountries();
}
