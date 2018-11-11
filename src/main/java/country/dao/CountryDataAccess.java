package country.dao;

import country.domain.Country;
import country.transactions.CountryDataAccessInterface;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CountryDataAccess implements CountryDAOlocal, CountryDAOreomte {

    @Inject
    private CountryDataAccessInterface cda;

    public List<Country> showAllCountries() {
        return cda.showAllCountries();
    }
}
