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
import vos.NacionalidadCliente;
import vos.ListaNacionalidadCliente;

@Path("nacionalidadesClientes")
public class VuelAndesNacionalidadClienteServices {
	
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
	public Response getNacionalidadCliente() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaNacionalidadCliente nacionalidadCliente;
		try {
			nacionalidadCliente = tm.darNacionalidadCliente();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(nacionalidadCliente).build();
	}

	
	@PUT
	@Path("/nacionalidadCliente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNacionalidadCliente(NacionalidadCliente nacionalidadCliente) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addNacionalidadCliente(nacionalidadCliente);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(nacionalidadCliente).build();
	}
	
	@PUT
	@Path("/nacionalidadesCliente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNacionalidadCliente(ListaNacionalidadCliente nacionalidadCliente) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addNacionalidadesClientes(nacionalidadCliente);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(nacionalidadCliente).build();
	}
	
	
	@DELETE
	@Path("/nacionalidadCliente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteNacionalidadCliente(NacionalidadCliente nacionalidadCliente) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteNacionalidadCliente(nacionalidadCliente);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(nacionalidadCliente).build();
	}


}
