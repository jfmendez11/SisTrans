package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaAeronavePasajero {
	
	@JsonProperty(value="aeronavesPasajero")
	private List<AeronavePasajero> aeronaves;
	
	public ListaAeronavePasajero( @JsonProperty(value="aeronavesPasajero")List<AeronavePasajero> ap){
		this.aeronaves = ap;
	}

	public List<AeronavePasajero> getAeronavesPasajero() {
		return aeronaves;
	}

	public void setAeronavesPasajero(List<AeronavePasajero> ap) {
		this.aeronaves = ap;
	}


}
