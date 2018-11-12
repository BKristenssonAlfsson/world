package world.transactions;

import world.domain.Country;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CountryDataAccess {

    public abstract List<Country> showAllCountries();
}
