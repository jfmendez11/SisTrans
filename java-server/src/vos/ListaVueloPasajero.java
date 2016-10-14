package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaVueloPasajero {
	
	
	@JsonProperty(value="vuelosPasajero")
	private List<VueloPasajero> vuelos;
	
	public ListaVueloPasajero( @JsonProperty(value="vuelosPasajero")List<VueloPasajero> vp){
		this.vuelos = vp;
	}

	public List<VueloPasajero> getVuelosPasajero() {
		return vuelos;
	}

	public void setVueloPasajero(List<VueloPasajero> vp) {
		this.vuelos = vp;
	}

}
