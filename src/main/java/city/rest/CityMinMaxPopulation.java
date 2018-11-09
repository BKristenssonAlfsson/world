package city.rest;

import city.dataaccess.DataAccessLocal;
import city.domain.Cities;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/city/MinMax")
public class CityMinMaxPopulation {
	
	public CityMinMaxPopulation() {}
	
	  @Inject
	  private DataAccessLocal dal;
	  
	  @GET
	  @Produces({"application/JSON"})
	  public Response findCitiesBetweenMinMaxPopulation(@QueryParam("cityOne") String cityOne, @QueryParam("cityTwo") String cityTwo) {
		  try {
			  List<Cities> result = dal.getCitiesBetweenMinMaxPopulation(cityOne, cityTwo);
			  return Response.ok(result).build();
		  } catch ( Exception e ) {
			  return Response.status(404).build();
		  }
	  }
}