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
import vos.AeronaveCarga;
import vos.ListaAeronaveCarga;

@Path("aeronavesCarga")
public class VuelAndesAeronaveCargaServices {
	
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
	public Response getaeronaveCarga() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaAeronaveCarga aeronaveCarga;
		try {
			aeronaveCarga = tm.darAeronavesCarga();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeronaveCarga).build();
	}

	
	@PUT
	@Path("/aeronaveCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAeronaveCarga(AeronaveCarga aeronaveCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAeronaveCarga(aeronaveCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeronaveCarga).build();
	}
	
	@PUT
	@Path("/aeronavesCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAeronaveCarga(ListaAeronaveCarga AeronaveCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAeronavesCarga(AeronaveCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(AeronaveCarga).build();
	}
	
	
	@POST
	@Path("/aeronaveCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAeronaveCarga(AeronaveCarga aeronaveCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateAeronaveCarga(aeronaveCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeronaveCarga).build();
	}
	
	@DELETE
	@Path("/aeronaveCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAeronaveCarga(AeronaveCarga aeronaveCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteAeronaveCarga(aeronaveCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aeronaveCarga).build();
	}

}
