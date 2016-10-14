package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.VuelAndesMaster;
import vos.*;

@Path("funcionariosAerolineaPasajero")
public class VuelAndesFuncionarioAerolineaPasajeroServices {

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
	public Response getFuncionarioAerolineaPasajero() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaFuncionarioAerolineaPasajero funcionarioAerolineaPasajero;
		try {
			funcionarioAerolineaPasajero = tm.darFuncionariosAerolineaPasajero();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAerolineaPasajero).build();
	}


	@PUT
	@Path("/funcionarioAerolineaPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFuncionarioAerolineaPasajero(FuncionarioAerolineaPasajero funcionarioAerolineaPasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addFuncionarioAerolineaPasajero(funcionarioAerolineaPasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAerolineaPasajero).build();
	}

	@PUT
	@Path("/funcionariosAerolineaPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFuncionarioAerolineaPasajero(ListaFuncionarioAerolineaPasajero funcionarioAerolineaPasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addFuncionariosAerolineaPasajero(funcionarioAerolineaPasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAerolineaPasajero).build();
	}


	@POST
	@Path("/funcionarioAerolineaPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFuncionarioAerolineaPasajero(FuncionarioAerolineaPasajero funcionarioAerolineaPasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateFuncionarioAerolineaPasajero(funcionarioAerolineaPasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAerolineaPasajero).build();
	}

	@DELETE
	@Path("/funcionarioAerolineaPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncionarioAerolineaPasajero(FuncionarioAerolineaPasajero funcionarioAerolineaPasajero) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteFuncionarioAerolineaPasajero(funcionarioAerolineaPasajero);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAerolineaPasajero).build();
	}

	@PUT
	@Path("/funcionarioAerolineaPasajero/{idFuncionario}/registrarAeronave")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarAeronavePasajero (@PathParam("idFuncionario") int idFuncionario, AeronavePasajero ap) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaFuncionarioAerolineaPasajero funcionarios = null;
		int idAerolinea = 0;
		try {
			funcionarios = tm.darFuncionariosAerolineaPasajero();

			for (FuncionarioAerolineaPasajero fap : funcionarios.getFuncionarioAerolineaPasajero())
				if (fap.getId() == idFuncionario) idAerolinea = fap.getId();
		} catch (Exception e) {
			return Response.status(500).entity(funcionarios).build();
		}
		ap.setIdAerolinea(idAerolinea);
		try {
			tm.addAeronavePasajero(ap);
		} catch (Exception e) {
			return Response.status(500).entity(ap).build();
		}
		return Response.status(200).entity(ap).build();
	}
	
	@PUT
	@Path("/funcionarioAerolineaPasajero/{idFuncionario}/registrarVuelo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarVueloPasajero (@PathParam("idFuncionario") int idFuncionario, VueloPasajero vc) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaFuncionarioAerolineaPasajero funcionarios = null;
		ListaAerolineaPasajeros aerolineas = null;
		int idAerolinea = 0;
		String codigo = "";
		
		try {
			funcionarios = tm.darFuncionariosAerolineaPasajero();

			for (FuncionarioAerolineaPasajero fac : funcionarios.getFuncionarioAerolineaPasajero())
				if (fac.getId() == idFuncionario) idAerolinea = fac.getId();
		} catch (Exception e) {
			return Response.status(500).entity(funcionarios).build();
		}
		vc.setIdAerolinea(idAerolinea);
		try {
			aerolineas = tm.darAerolineasPasajero();
			
			for (AerolineaPasajeros ap : aerolineas.getAerolineaPasajeros()) {
				if (ap.getIdAerolinea() == idAerolinea) {
					codigo = ap.getIdIata();
					break;
				}
			}
		} catch (Exception e) {
			return Response.status(500).entity(aerolineas).build();
		}
		vc.setIdVuelo(codigo + vc.getIdVuelo());
		try {
			tm.addVueloPasajero(vc);
		} catch (Exception e) {
			return Response.status(500).entity(vc).build();
		}
		return Response.status(200).entity(vc).build();
	}
	
}
