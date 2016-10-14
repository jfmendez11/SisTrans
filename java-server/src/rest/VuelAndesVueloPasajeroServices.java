package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.VuelAndesMaster;
import vos.VueloPasajero;
import vos.ListaVueloPasajero;

@Path("vuelosPasajero")
public class VuelAndesVueloPasajeroServices {
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	
	
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getVueloPasajero() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaVueloPasajero vueloPasajero;
		try {
			vueloPasajero = tm.darVuelosPasajero();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(vueloPasajero).build();
	}

	
	@PUT
	@Path("/vueloPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addVueloPasajero(VueloPasajero vueloPasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addVueloPasajero(vueloPasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(vueloPasajero).build();
	}
	
	@PUT
	@Path("/vuelosPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAerolienaPasajeros(ListaVueloPasajero aerolineasPasajeros) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addVuelosPasajero(aerolineasPasajeros);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aerolineasPasajeros).build();
	}
	
	
	@POST
	@Path("/vueloPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateVueloPasajero(VueloPasajero vueloPasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateVueloPasajero(vueloPasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(vueloPasajero).build();
	}
	
	@DELETE
	@Path("/vueloPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteVueloPasajero(VueloPasajero vueloPasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteVueloPasajero(vueloPasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(vueloPasajero).build();
	}

}
