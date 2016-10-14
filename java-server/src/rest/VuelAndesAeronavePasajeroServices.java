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
import vos.AeronavePasajero;
import vos.ListaAeronavePasajero;

@Path("aeronavesPasajero")
public class VuelAndesAeronavePasajeroServices {
	
	
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
	public Response getaeronavePasajero() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaAeronavePasajero aeronavePasajero;
		try {
			aeronavePasajero = tm.darAeronavesPasajero();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeronavePasajero).build();
	}

	
	@PUT
	@Path("/aeronavePasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAeronavePasajero(AeronavePasajero aeronavePasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAeronavePasajero(aeronavePasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeronavePasajero).build();
	}
	
	@PUT
	@Path("/aeronavesPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAeronavePasajero(ListaAeronavePasajero AeronavePasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAeronavesPasajero(AeronavePasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(AeronavePasajero).build();
	}
	
	
	@POST
	@Path("/aeronavePasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAeronavePasajero(AeronavePasajero aeronavePasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateAeronavePasajero(aeronavePasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeronavePasajero).build();
	}
	
	@DELETE
	@Path("/aeronavePasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAeronavePasajero(AeronavePasajero aeronavePasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteAeronavePasajero(aeronavePasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeronavePasajero).build();
	}

}
