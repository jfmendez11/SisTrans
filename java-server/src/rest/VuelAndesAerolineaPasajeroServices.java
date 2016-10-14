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
import vos.AerolineaPasajeros;
import vos.ListaAerolineaPasajeros;

@Path("aerolineasPasajero")
public class VuelAndesAerolineaPasajeroServices {
	
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
	public Response getAerolineaPasajeros() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaAerolineaPasajeros aerolineaPasajeros;
		try {
			aerolineaPasajeros = tm.darAerolineasPasajero();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aerolineaPasajeros).build();
	}

	
	@PUT
	@Path("/aerolineaPasajeros")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAerolineaPasajeros(AerolineaPasajeros aerolineaPasajeros) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAerolineaPasajero(aerolineaPasajeros);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aerolineaPasajeros).build();
	}
	
	@PUT
	@Path("/aerolineasPasajeros")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAerolienaPasajeros(ListaAerolineaPasajeros aerolineasPasajeros) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAerolineasPasajero(aerolineasPasajeros);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aerolineasPasajeros).build();
	}
	
	
	@POST
	@Path("/aerolineaPasajeros")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAerolineaPasajeros(AerolineaPasajeros aerolineaPasajeros) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateAerolineaPasajero(aerolineaPasajeros);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aerolineaPasajeros).build();
	}
	
	@DELETE
	@Path("/aerolineaPasajeros")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAerolineaPasajeros(AerolineaPasajeros aerolineaPasajeros) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteAerolineaPasajero(aerolineaPasajeros);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aerolineaPasajeros).build();
	}
}
