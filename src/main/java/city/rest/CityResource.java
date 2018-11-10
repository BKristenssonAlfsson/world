package city.rest;

import city.dao.DataAccessLocal;
import city.domain.City;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/city")
public class CityResource{

  private Logger logger = LogManager.getLogger(CityResource.class.getName());
	
  public CityResource() {}

  @Inject
  private DataAccessLocal dal;

  @GET
  @Produces({"application/JSON"})
  @Path("{cityId}")
  public Response findCityByName( @PathParam("cityId") String name ) {
    try {
      String result = dal.getCityByName(name);
      return Response.ok(result).build();
    } catch ( Exception e ) {
      return Response.status(403).build();
    }
  }
  
  @GET
  @Produces({"application/JSON"})
  public Response showAllCities() {
	  try {
		  List<City> result = dal.showAllCities();
		  logger.trace(result);
		  return Response.ok(result).build();
	  } catch ( Exception e ) {
	      logger.trace(e);
		  return Response.status(402).build();
	  }
  }
  
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public City addCity(City city) {
		try {
			dal.addCity(city);
		} catch (ServiceUnavailableException e) {
			e.printStackTrace();
		}
		return city;
	}
  
  @DELETE
  @Path("{city}")
  public Response deleteCity( @PathParam("city") String name) {
	  try {
		  dal.removeCity(name);
		  return Response.status(200).build();
	  } catch ( Exception e ) {
		  return Response.status(404).build();
	  }
  }	
  
  @PUT
  public void updateCity(@QueryParam("name") String name, @QueryParam("newName") String newName, @QueryParam("population") Integer population ) {
	  dal.updateCity(name, newName, population);
  }

}