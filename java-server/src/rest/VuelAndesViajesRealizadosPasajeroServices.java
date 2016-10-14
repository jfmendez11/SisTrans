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
import vos.ViajesRealizadosPasajero;
import vos.ListaViajesRealizadosPasajero;

@Path("viajesRealizadosPasajeros")
public class VuelAndesViajesRealizadosPasajeroServices {
	
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
	public Response getViajesRealizadosPasajero() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaViajesRealizadosPasajero viajesRealizadosPasajero;
		try {
			viajesRealizadosPasajero = tm.darViajesRealizadosPasajero();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(viajesRealizadosPasajero).build();
	}

	
	@PUT
	@Path("/viajeRealizadoPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addViajesRealizadosPasajero(ViajesRealizadosPasajero viajesRealizadosPasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addViajeRealizadoPasajero(viajesRealizadosPasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(viajesRealizadosPasajero).build();
	}
	
	@PUT
	@Path("/viajesRealizadosPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addViajesRealizadosPasajero(ListaViajesRealizadosPasajero viajesRealizadosPasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addViajesRealizadosPasajero(viajesRealizadosPasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(viajesRealizadosPasajero).build();
	}
	
	
	
	@DELETE
	@Path("/viajesRealizadosPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteViajesRealizadosPasajero(ViajesRealizadosPasajero viajesRealizadosPasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteViajeRealizadosPasajero(viajesRealizadosPasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(viajesRealizadosPasajero).build();
	}


}
