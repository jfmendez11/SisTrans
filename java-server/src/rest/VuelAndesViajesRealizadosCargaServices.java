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
import vos.ViajesRealizadosCarga;
import vos.ListaViajesRealizadosCarga;

@Path("viajesRealizadosCargas")
public class VuelAndesViajesRealizadosCargaServices {
	
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
	public Response getViajesRealizadosCarga() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaViajesRealizadosCarga viajesRealizadosCarga;
		try {
			viajesRealizadosCarga = tm.darViajesRealizadosCarga();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(viajesRealizadosCarga).build();
	}

	
	@PUT
	@Path("/viajeRealizadoCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addViajesRealizadosCarga(ViajesRealizadosCarga viajesRealizadosCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addViajeRealizadoCarga(viajesRealizadosCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(viajesRealizadosCarga).build();
	}
	
	@PUT
	@Path("/viajesRealizadosCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addViajesRealizadosCarga(ListaViajesRealizadosCarga viajesRealizadosCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addViajesRealizadosCarga(viajesRealizadosCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(viajesRealizadosCarga).build();
	}
	
	
	@DELETE
	@Path("/viajesRealizadosCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteViajesRealizadosCarga(ViajesRealizadosCarga viajesRealizadosCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteViajeRealizadosCarga(viajesRealizadosCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(viajesRealizadosCarga).build();
	}

}
