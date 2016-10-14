package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaClienteViajero {
	
	@JsonProperty(value="clientesViajero")
	private List<ClienteViajero> clientesViajero;
	
	public ListaClienteViajero( @JsonProperty(value="clientesViajero")List<ClienteViajero> clienteViajero){
		this.clientesViajero = clienteViajero;
	}
	
	public List<ClienteViajero> getClienteViajero() {
		return clientesViajero;
	}
	
	public void setVideo(List<ClienteViajero> clienteViajero) {
		this.clientesViajero = clienteViajero;
	}


}
