package language.rest;

import language.dao.LanguageDAOlocal;
import language.domain.Language;
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
@Path("/language")
public class LanguageResource {

    @Inject
    private LanguageDAOlocal dal;

    @GET
    @Produces({"application/JSON"})
    public Response listAllLanguages() {
        try {
            List<Language> result = dal.listAllLanguages();
            return Response.ok(result).build();
        } catch ( Exception e ) {
            return Response.status(404).build();
        }
    }
}