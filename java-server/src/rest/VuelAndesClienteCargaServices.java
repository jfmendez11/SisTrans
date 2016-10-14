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
import vos.ClienteCarga;
import vos.ListaClienteCarga;

@Path("clientesCarga")
public class VuelAndesClienteCargaServices {
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
	public Response getClienteCarga() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaClienteCarga ClienteCarga;
		try {
			ClienteCarga = tm.darClienteCarga();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(ClienteCarga).build();
	}

	
	@PUT
	@Path("/ClienteCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addClienteCarga(ClienteCarga ClienteCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addClienteCarga(ClienteCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(ClienteCarga).build();
	}
	
	@PUT
	@Path("/ClientesCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addClienteCarga(ListaClienteCarga ClienteCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addClientesCarga(ClienteCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(ClienteCarga).build();
	}
	
	
	@POST
	@Path("/ClienteCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateClienteCarga(ClienteCarga ClienteCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateClienteCarga(ClienteCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(ClienteCarga).build();
	}
	
	@DELETE
	@Path("/ClienteCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteClienteCarga(ClienteCarga ClienteCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteClienteCarga(ClienteCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(ClienteCarga).build();
	}

}
