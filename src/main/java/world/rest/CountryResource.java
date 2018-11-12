package world.rest;

import world.dao.DataAccessLocal;
import world.domain.Country;
import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@NoArgsConstructor
@Stateless
@Path("/country")
public class CountryResource {

    @Inject
    private DataAccessLocal cdoal;

    @GET
    @Produces({"application/JSON"})
    public Response showAllCountries() {
        try {
            List<Country> result = cdoal.showAllCountries();
            return Response.ok(result).build();
        } catch ( Exception e ) {
            return Response.status(401).build();
        }
    }
}
