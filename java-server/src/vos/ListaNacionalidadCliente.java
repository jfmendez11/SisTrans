package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaNacionalidadCliente {
	
	@JsonProperty(value="nacionalidadCliente")
	private List<NacionalidadCliente> nacionalidadCliente;
	
	public ListaNacionalidadCliente( @JsonProperty(value="nacionalidadCliente")List<NacionalidadCliente> nacionalidadCliente){
		this.nacionalidadCliente = nacionalidadCliente;
	}
	
	public List<NacionalidadCliente> getnacionalidadCliente() {
		return nacionalidadCliente;
	}
	
	public void setVideo(List<NacionalidadCliente> nacionalidadCliente) {
		this.nacionalidadCliente = nacionalidadCliente;
	}

}
