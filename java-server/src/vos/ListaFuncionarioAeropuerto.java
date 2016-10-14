package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaFuncionarioAeropuerto {
	
	@JsonProperty(value="funcionariosAeropuerto")
	private List<FuncionarioAeropuerto> funcionarios;
	
	public ListaFuncionarioAeropuerto( @JsonProperty(value="funcionariosAeropuerto")List<FuncionarioAeropuerto> fa){
		this.funcionarios = fa;
	}

	public List<FuncionarioAeropuerto> getFuncionariosAeropuerto() {
		return funcionarios;
	}

	public void setFuncionarioAeropuerto(List<FuncionarioAeropuerto> fa) {
		this.funcionarios = fa;
	}


}
