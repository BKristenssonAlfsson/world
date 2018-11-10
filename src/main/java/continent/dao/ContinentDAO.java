package continent.dao;

import continent.domain.Continent;
import continent.transactions.ContinentDataAccess;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ContinentDAO implements DAOlocal, DAOremote {

    @Inject
    private ContinentDataAccess cda;

    @Override
    public List<Continent> showAllContinents() {
        return cda.showAllContinents();
    }
}
