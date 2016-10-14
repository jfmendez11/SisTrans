package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class NacionalidadCliente {
	
	@JsonProperty(value="idCliente")
	private String idCliente;
	
	@JsonProperty(value="nacionalidad")
	private String nacionalidad;
	
	
	public NacionalidadCliente(@JsonProperty(value="idCliente")String idCliente, @JsonProperty(value="nacionalidad")String nacionalidad){
		super();
		this.idCliente = idCliente;
		this.nacionalidad = nacionalidad;
	}


	public String getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
