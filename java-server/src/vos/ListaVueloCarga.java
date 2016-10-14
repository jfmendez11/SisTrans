package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaVueloCarga {
	
	@JsonProperty(value="vuelosCarga")
	private List<VueloCarga> vuelos;
	
	public ListaVueloCarga( @JsonProperty(value="vuelosCarga")List<VueloCarga> vc){
		this.vuelos = vc;
	}

	public List<VueloCarga> getVuelosCarga() {
		return vuelos;
	}

	public void setVueloCarga(List<VueloCarga> vc) {
		this.vuelos = vc;
	}


}
