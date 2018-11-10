package continent.dao;

import continent.domain.Continent;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DAOlocal {
    public List<Continent> showAllContinents();
}
