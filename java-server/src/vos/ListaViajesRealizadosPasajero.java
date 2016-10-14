package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaViajesRealizadosPasajero {
	
	@JsonProperty(value="viajesRealizadosPasajero")
	private List<ViajesRealizadosPasajero> viajesRealizadosPasajero;
	
	public ListaViajesRealizadosPasajero( @JsonProperty(value="viajesRealizadosPasajero")List<ViajesRealizadosPasajero> viajesRealizadosPasajero){
		this.viajesRealizadosPasajero = viajesRealizadosPasajero;
	}
	
	public List<ViajesRealizadosPasajero> getviajesRealizadosPasajero() {
		return viajesRealizadosPasajero;
	}
	
	public void setVideo(List<ViajesRealizadosPasajero> viajesRealizadosPasajero) {
		this.viajesRealizadosPasajero = viajesRealizadosPasajero;
	}

}
