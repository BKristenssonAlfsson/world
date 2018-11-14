package world.rest;

import world.dao.DataAccessLocal;
import world.domain.Continent;
import lombok.NoArgsConstructor;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@NoArgsConstructor
@Stateless
@Path("/continent")
public class ContinentResource {

    @Inject
    private DataAccessLocal dal;

    @GET
    @Produces({"application/JSON"})
    public Response showAllContinents() {
        try {
            List<Continent> result = dal.showAllContinents();
            return Response.ok(result).build();
        } catch ( Exception e ) {
            return Response.status(404).build();
        }
    }
    
    @GET
    @Produces({"application/JSON"})
    @Path("{continentId}")
    public Response listAllCountriesOnContinent(@PathParam("continentId") Integer id) {
        try {
            List<Continent> result = dal.listAllCountriesOnContinent(id);
            return Response.ok(result).build();
        } catch (Exception e ) {
            return Response.status(404).build();
        }
    }
}
