package rest;

import java.util.List;

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
import vos.*;

@Path("administradores")
public class VuelAndesAdministradorServices {

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
	public Response getAdministradores() {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		ListaAdministrador admins;
		try {
			admins = tm.darAdministradores();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(admins).build();
	}

	@PUT
	@Path("/administrador")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAdministrador(Administrador admin) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAdministrador(admin);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(admin).build();
	}

	@PUT
	@Path("/administradores")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAdministradores(ListaAdministrador admin) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAdministradores(admin);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(admin).build();
	}

	@POST
	@Path("/administrador")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAdministrador(Administrador admin) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.updateAdiministrador(admin);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(admin).build();
	}

	@DELETE
	@Path("/administrador")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAdministrador(Administrador admin) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.deleteAdministrador(admin);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(admin).build();
	}

	@PUT
	@Path("/administrador/registrarClienteViajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarClienteViajero (ClienteViajero cv) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			String [] nacionalidades = cv.getNacionalidades().split(";"); 
			tm.addClienteViajero(cv);
			for (int i = 0; i < nacionalidades.length; i++) {
				NacionalidadCliente nc = new NacionalidadCliente(cv.getIdViajero(), nacionalidades[i]);
				tm.addNacionalidadCliente(nc);
			}
		} catch (Exception e) {
			return Response.status(500).entity(cv).build();
		}
		return Response.status(200).entity(cv).build();
	}

	@PUT
	@Path("/administrador/registrarClienteRemitente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarClienteRemitente (ClienteCarga cc) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addClienteCarga(cc);
		} catch (Exception e) {
			return Response.status(500).entity(cc).build();
		}
		return Response.status(200).entity(cc).build();
	}
	
	@PUT
	@Path("/administrador/registrarAerolineaCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registarAerolineaCarga (AerolineaCarga ac) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAerolineaCarga(ac);
		} catch (Exception e) {
			return Response.status(500).entity(ac).build();
		}
		return Response.status(200).entity(ac).build();
	}
	
	@PUT
	@Path("/administrador/registrarAerolineaPasajero")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registarAerolineaPasajero (AerolineaPasajeros ap) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAerolineaPasajero(ap);
		} catch (Exception e) {
			return Response.status(500).entity(ap).build();
		}
		return Response.status(200).entity(ap).build();
	}
	
	@PUT
	@Path("/administrador/registarAeropuerto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registarAeropuerto (Aeropuerto a) {
		VuelAndesMaster tm = new VuelAndesMaster(getPath());
		try {
			tm.addAeropuerto(a);
		} catch (Exception e) {
			return Response.status(500).entity(a).build();
		}
		return Response.status(200).entity(a).build();
	}

}
