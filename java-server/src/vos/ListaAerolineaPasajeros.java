package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaAerolineaPasajeros {
	
	@JsonProperty(value="aerolineasPasajeros")
	private List<AerolineaPasajeros> aerolineaPasajeros;
	
	public ListaAerolineaPasajeros( @JsonProperty(value="aerolineasPasajeros")List<AerolineaPasajeros> aerolineaPasajeros){
		this.aerolineaPasajeros = aerolineaPasajeros;
	}
	
	public List<AerolineaPasajeros> getAerolineaPasajeros() {
		return aerolineaPasajeros;
	}
	
	public void setVideo(List<AerolineaPasajeros> aerolineaPasajeros) {
		this.aerolineaPasajeros = aerolineaPasajeros;
	}

}
