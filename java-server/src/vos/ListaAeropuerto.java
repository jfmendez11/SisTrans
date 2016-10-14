package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaAeropuerto {
	
	@JsonProperty(value="aeropuertos")
	private List<Aeropuerto> aeropuertos;
	
	public ListaAeropuerto( @JsonProperty(value="aeropuertos")List<Aeropuerto> aeropuertos){
		this.aeropuertos = aeropuertos;
	}

	public List<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}

	public void setAeropuerto(List<Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

}
