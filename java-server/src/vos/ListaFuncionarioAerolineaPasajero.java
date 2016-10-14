package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaFuncionarioAerolineaPasajero {
	

	@JsonProperty(value="funcionariosAerolineaPasajero")
	private List<FuncionarioAerolineaPasajero> funcionarioAerolineaPasajero;
	
	public ListaFuncionarioAerolineaPasajero( @JsonProperty(value="funcionariosAerolineaPasajero")List<FuncionarioAerolineaPasajero> funcionarioAerolineaPasajero){
		this.funcionarioAerolineaPasajero = funcionarioAerolineaPasajero;
	}
	
	public List<FuncionarioAerolineaPasajero> getFuncionarioAerolineaPasajero() {
		return funcionarioAerolineaPasajero;
	}
	
	public void setVideo(List<FuncionarioAerolineaPasajero> funcionarioAerolineaPasajero) {
		this.funcionarioAerolineaPasajero = funcionarioAerolineaPasajero;
	}

}
