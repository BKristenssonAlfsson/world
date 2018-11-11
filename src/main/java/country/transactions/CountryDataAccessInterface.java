package country.transactions;

import country.domain.Country;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CountryDataAccessInterface {

    public abstract List<Country> showAllCountries();
}
