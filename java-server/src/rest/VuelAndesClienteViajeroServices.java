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
import vos.ClienteViajero;
import vos.ListaClienteViajero;

@Path("clientesViajero")
public class VuelAndesClienteViajeroServices {
	
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
	public Response getClienteViajero() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaClienteViajero clienteViajero;
		try {
			clienteViajero = tm.darClienteViajero();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(clienteViajero).build();
	}

	
	@PUT
	@Path("/clienteViajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addClienteViajero(ClienteViajero clienteViajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addClienteViajero(clienteViajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(clienteViajero).build();
	}
	
	@PUT
	@Path("/clientesViajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addClienteViajero(ListaClienteViajero clienteViajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addClientesViajero(clienteViajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(clienteViajero).build();
	}
	
	
	@POST
	@Path("/clienteViajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateClienteViajero(ClienteViajero clienteViajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateClienteViajero(clienteViajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(clienteViajero).build();
	}
	
	@DELETE
	@Path("/clienteViajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteClienteViajero(ClienteViajero clienteViajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteClienteViajero(clienteViajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(clienteViajero).build();
	}

}
