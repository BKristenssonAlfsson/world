package world.rest;

import world.dao.DataAccessLocal;
import world.domain.City;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/city")
public class CityResource{

  public CityResource() {}

  @Inject
  private DataAccessLocal dal;

  @GET
  @Produces({"application/JSON"})
  @Path("{cityId}")
  public Response findCityByName( @PathParam("cityId") String name ) {
    try {
      String result = dal.getCityByName(name);
        Jsonb jsonb = JsonbBuilder.create();
        String jsonString = jsonb.toJson(result);
      return Response.ok(jsonString).build();
    } catch ( Exception e ) {
      return Response.status(403).build();
    }
  }
  
  @GET
  @Produces({"application/JSON"})
  public Response showAllCities() {
	  try {
		  List<City> result = dal.showAllCities();
		  return Response.ok(result).build();
	  } catch ( Exception e ) {
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