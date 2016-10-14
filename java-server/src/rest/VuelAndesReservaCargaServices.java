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
import vos.ReservaCarga;
import vos.ListaReservaCarga;

@Path("reservasCarga")
public class VuelAndesReservaCargaServices {
	
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
	public Response getReservaCarga() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaReservaCarga reservaCarga;
		try {
			reservaCarga = tm.darReservasCarga();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(reservaCarga).build();
	}

	
	@PUT
	@Path("/reservaCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addReservaCarga(ReservaCarga reservaCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addReservaCarga(reservaCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(reservaCarga).build();
	}
	
	@PUT
	@Path("/reservasCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addReservaCarga(ListaReservaCarga reservaCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addReservasCarga(reservaCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(reservaCarga).build();
	}
	
	
	@POST
	@Path("/reservaCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateReservaCarga(ReservaCarga reservaCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateReservaCarga(reservaCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(reservaCarga).build();
	}
	
	@DELETE
	@Path("/reservaCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteReservaCarga(ReservaCarga reservaCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteReservaCarga(reservaCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(reservaCarga).build();
	}


}
