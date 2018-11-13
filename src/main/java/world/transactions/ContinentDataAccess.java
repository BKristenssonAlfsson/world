package world.transactions;

import world.domain.Continent;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ContinentDataAccess  {

    public abstract List<Continent> showAllContinents();
    public abstract List<Continent> showDetailsAboutContinent(Integer id);
}
