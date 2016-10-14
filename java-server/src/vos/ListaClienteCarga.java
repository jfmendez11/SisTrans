package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaClienteCarga {
	
	@JsonProperty(value="clientesCarga")
	private List<ClienteCarga> clientes;
	
	public ListaClienteCarga( @JsonProperty(value="clientesCarga")List<ClienteCarga> cc){
		this.clientes = cc;
	}

	public List<ClienteCarga> getClientesCarga() {
		return clientes;
	}

	public void setClienteCarga(List<ClienteCarga> cc) {
		this.clientes = cc;
	}
}
