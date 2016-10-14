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
import vos.FuncionarioAeropuerto;
import vos.ListaFuncionarioAeropuerto;

@Path("funcionariosAeropuerto")
public class VuelAndesFuncionarioAeropuertoServices {
	
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
	public Response getFuncionarioAeropuerto() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaFuncionarioAeropuerto funcionarioAeropuerto;
		try {
			funcionarioAeropuerto = tm.darFuncionariosAeropuerto();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAeropuerto).build();
	}

	
	@PUT
	@Path("/funcionarioAeropuerto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFuncionarioAeropuerto(FuncionarioAeropuerto funcionarioAeropuerto) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addFuncionarioAeropuerto(funcionarioAeropuerto);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAeropuerto).build();
	}
	
	@PUT
	@Path("/funcionariosAeropuerto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAerolienaPasajeros(ListaFuncionarioAeropuerto aerolineasPasajeros) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addFuncionariosAeropuerto(aerolineasPasajeros);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aerolineasPasajeros).build();
	}
	
	
	@POST
	@Path("/funcionarioAeropuerto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFuncionarioAeropuerto(FuncionarioAeropuerto funcionarioAeropuerto) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateFuncionarioAeropuerto(funcionarioAeropuerto);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAeropuerto).build();
	}
	
	@DELETE
	@Path("/funcionarioAeropuerto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncionarioAeropuerto(FuncionarioAeropuerto funcionarioAeropuerto) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteFuncionarioAeropuerto(funcionarioAeropuerto);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAeropuerto).build();
	}

}
