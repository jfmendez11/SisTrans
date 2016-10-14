package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaViajesRealizadosCarga {
	
	@JsonProperty(value="viajesRealizadosCarga")
	private List<ViajesRealizadosCarga> viajesRealizadosCarga;
	
	public ListaViajesRealizadosCarga( @JsonProperty(value="viajesRealizadosCarga")List<ViajesRealizadosCarga> viajesRealizadosCarga){
		this.viajesRealizadosCarga = viajesRealizadosCarga;
	}
	
	public List<ViajesRealizadosCarga> getviajesRealizadosCarga() {
		return viajesRealizadosCarga;
	}
	
	public void setVideo(List<ViajesRealizadosCarga> viajesRealizadosCarga) {
		this.viajesRealizadosCarga = viajesRealizadosCarga;
	}

}
