package continent.transactions;

import continent.domain.Continent;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ContinentDataAccess  {

    public abstract List<Continent> showAllContinents();
}
