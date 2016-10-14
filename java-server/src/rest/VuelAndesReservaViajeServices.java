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
import vos.ReservaViaje;
import vos.ListaReservaViaje;

@Path("reservasViajes")
public class VuelAndesReservaViajeServices {
	
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
	public Response getReservaViaje() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaReservaViaje reservaViaje;
		try {
			reservaViaje = tm.darReservasViaje();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(reservaViaje).build();
	}

	
	@PUT
	@Path("/reservaViaje")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addReservaViaje(ReservaViaje reservaViaje) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addReservaViaje(reservaViaje);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(reservaViaje).build();
	}
	
	@PUT
	@Path("/reservasViaje")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addReservaViaje(ListaReservaViaje reservaViaje) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addReservasViaje(reservaViaje);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(reservaViaje).build();
	}
	
	
	@POST
	@Path("/reservaViaje")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateReservaViaje(ReservaViaje reservaViaje) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateReservaViaje(reservaViaje);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(reservaViaje).build();
	}
	
	@DELETE
	@Path("/reservaViaje")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteReservaViaje(ReservaViaje reservaViaje) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteReservaViaje(reservaViaje);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(reservaViaje).build();
	}


}
