package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaAdministrador {
	
	@JsonProperty(value="administradores")
	private List<Administrador> administradores;
	
	public ListaAdministrador( @JsonProperty(value="administradores")List<Administrador> administradores){
		this.administradores = administradores;
	}

	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministrador(List<Administrador> administradores) {
		this.administradores = administradores ;
	}

}
