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
import vos.Aeropuerto;
import vos.ListaAeropuerto;

@Path("aeropuertos")
public class VuelAndesAeropuertoServices {
	
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
	public Response getAeropuerto() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaAeropuerto aeropuerto;
		try {
			aeropuerto = tm.darAeropuertos();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeropuerto).build();
	}

	
	@PUT
	@Path("/Aeropuerto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAeropuerto(Aeropuerto aeropuerto) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAeropuerto(aeropuerto);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeropuerto).build();
	}
	
	@PUT
	@Path("/Aeropuertos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAeropuerto(ListaAeropuerto aeropuerto) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAeropuerto(aeropuerto);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeropuerto).build();
	}
	
	
	@POST
	@Path("/Aeropuerto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAeropuerto(Aeropuerto aeropuerto) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateAeropuerto(aeropuerto);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeropuerto).build();
	}
	
	@DELETE
	@Path("/Aeropuerto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAeropuerto(Aeropuerto aeropuerto) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteAeropuerto(aeropuerto);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeropuerto).build();
	}

}
