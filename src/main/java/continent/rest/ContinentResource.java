package continent.rest;

import continent.dao.DAOlocal;
import continent.domain.Continent;
import lombok.NoArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@NoArgsConstructor
@Stateless
@Path("/continent")
public class ContinentResource {

    private Logger logger = LogManager.getLogger(ContinentResource.class.getName());

    @Inject
    private DAOlocal dal;

    @GET
    @Produces({"application/JSON"})
    public Response showAllContinents() {
        try {
            List<Continent> result = dal.showAllContinents();
            logger.trace(result);
            return Response.ok(result).build();
        } catch ( Exception e ) {
            logger.trace(e);
            return Response.status(404).build();
        }
    }
}
