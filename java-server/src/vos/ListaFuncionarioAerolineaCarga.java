package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaFuncionarioAerolineaCarga {
	
	@JsonProperty(value="funcionariosAerolineaCarga")
	private List<FuncionarioAerolineaCarga> funcionarioAerolineaCarga;
	
	public ListaFuncionarioAerolineaCarga( @JsonProperty(value="funcionariosAerolineaCarga")List<FuncionarioAerolineaCarga> funcionarioAerolineaCarga){
		this.funcionarioAerolineaCarga = funcionarioAerolineaCarga;
	}
	
	public List<FuncionarioAerolineaCarga> getFuncionarioAerolineaCarga() {
		return funcionarioAerolineaCarga;
	}
	
	public void setVideo(List<FuncionarioAerolineaCarga> funcionarioAerolineaCarga) {
		this.funcionarioAerolineaCarga = funcionarioAerolineaCarga;
	}

}
