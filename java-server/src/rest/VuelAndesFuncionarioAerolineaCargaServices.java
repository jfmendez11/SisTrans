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
import vos.AerolineaCarga;
import vos.AeronaveCarga;
import vos.AeronavePasajero;
import vos.FuncionarioAerolineaCarga;
import vos.FuncionarioAerolineaPasajero;
import vos.ListaAerolineaCarga;
import vos.ListaAeronaveCarga;
import vos.ListaFuncionarioAerolineaCarga;
import vos.ListaFuncionarioAerolineaPasajero;
import vos.VueloCarga;
import vos.VueloPasajero;

@Path("funcionariosAerolineaCarga")
public class VuelAndesFuncionarioAerolineaCargaServices {
	
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
	public Response getFuncionarioAerolineaCarga() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaFuncionarioAerolineaCarga funcionarioAerolineaCarga;
		try {
			funcionarioAerolineaCarga = tm.darFuncionariosAerolineaCarga();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAerolineaCarga).build();
	}

	
	@PUT
	@Path("/funcionarioAerolineaCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFuncionarioAerolineaCarga(FuncionarioAerolineaCarga funcionarioAerolineaCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addFuncionarioAerolineaCarga(funcionarioAerolineaCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAerolineaCarga).build();
	}
	
	@PUT
	@Path("/funcionariosAerolineaCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFuncionarioAerolineaCarga(ListaFuncionarioAerolineaCarga funcionarioAerolineaCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addFuncionariosAerolineaCarga(funcionarioAerolineaCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAerolineaCarga).build();
	}
	
	
	@POST
	@Path("/funcionarioAerolineaCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFuncionarioAerolineaCarga(FuncionarioAerolineaCarga funcionarioAerolineaCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateFuncionarioAerolineaCarga(funcionarioAerolineaCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAerolineaCarga).build();
	}
	
	@DELETE
	@Path("/funcionarioAerolineaCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncionarioAerolineaCarga(FuncionarioAerolineaCarga funcionarioAerolineaCarga) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteFuncionarioAerolineaCarga(funcionarioAerolineaCarga);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(funcionarioAerolineaCarga).build();
	}
	
	@PUT
	@Path("/funcionarioAerolineaCarga/{idFuncionario}/registrarAeronave")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarAeronaveCarga (@PathParam("idFuncionario") int idFuncionario, AeronaveCarga ac) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaFuncionarioAerolineaCarga funcionarios = null;
		int idAerolinea = 0;
		try {
			funcionarios = tm.darFuncionariosAerolineaCarga();

			for (FuncionarioAerolineaCarga fac : funcionarios.getFuncionarioAerolineaCarga())
				if (fac.getId() == idFuncionario) idAerolinea = fac.getId();
		} catch (Exception e) {
			return Response.status(500).entity(funcionarios).build();
		}
		ac.setIdAerolinea(idAerolinea);
		try {
			tm.addAeronaveCarga(ac);
		} catch (Exception e) {
			return Response.status(500).entity(ac).build();
		}
		return Response.status(200).entity(ac).build();
	}
	
	@PUT
	@Path("/funcionarioAerolineaCarga/{idFuncionario}/registrarVuelo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarVueloCarga (@PathParam("idFuncionario") int idFuncionario, VueloCarga vc) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaFuncionarioAerolineaCarga funcionarios = null;
		ListaAerolineaCarga aerolineas = null;
		int idAerolinea = 0;
		String codigo = "";
		try {
			funcionarios = tm.darFuncionariosAerolineaCarga();

			for (FuncionarioAerolineaCarga fac : funcionarios.getFuncionarioAerolineaCarga())
				if (fac.getId() == idFuncionario) idAerolinea = fac.getId();
		} catch (Exception e) {
			return Response.status(500).entity(funcionarios).build();
		}
		vc.setIdAerolinea(idAerolinea);
		try {
			aerolineas = tm.darAerolineasCarga();
			
			for (AerolineaCarga ac : aerolineas.getAerolineasCarga()) {
				if (ac.getId() == idAerolinea) {
					codigo = ac.getIdIata();
					break;
				}
			}
		} catch (Exception e) {
			return Response.status(500).entity(aerolineas).build();
		}
		vc.setIdVuelo(codigo + vc.getIdVuelo());
		vc.setNumSerie(null);
		try {
			tm.addVueloCarga(vc);
		} catch (Exception e) {
			return Response.status(500).entity(vc).build();
		}
		return Response.status(200).entity(vc).build();
	}
}
