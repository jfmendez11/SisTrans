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
import vos.AerolineaCarga;
import vos.ListaAerolineaCarga;

@Path ("aerolineasCarga")
public class VuelAndesAerolineaCargaServices {
	
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
	public Response getAerolineaCarga() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaAerolineaCarga aerolineaCarga;
		try {
			aerolineaCarga = tm.darAerolineasCarga();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aerolineaCarga).build();
	}

	
	@PUT
	@Path("/aerolineaCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAerolineaCarga(AerolineaCarga aerolineaCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAerolineaCarga(aerolineaCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aerolineaCarga).build();
	}
	
	@PUT
	@Path("/aerolineasCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAerolineaCarga(ListaAerolineaCarga aerolineaCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAerolineasCarga(aerolineaCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aerolineaCarga).build();
	}
	
	
	@POST
	@Path("/aerolineaCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAerolineaCarga(AerolineaCarga aerolineaCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateAerolineaCarga(aerolineaCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aerolineaCarga).build();
	}
	
	@DELETE
	@Path("/aerolineaCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAerolineaCarga(AerolineaCarga aerolineaCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteAerolineaCarga(aerolineaCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aerolineaCarga).build();
	}


}
