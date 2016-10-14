package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaReservaViaje{
	
	@JsonProperty(value="reservaViaje")
	private List<ReservaViaje> reservaViaje;
	
	public ListaReservaViaje( @JsonProperty(value="funcionariosAerolineaViaje")List<ReservaViaje> reservaViaje){
		this.reservaViaje = reservaViaje;
	}
	
	public List<ReservaViaje> getreservaViaje() {
		return reservaViaje;
	}
	
	public void setVideo(List<ReservaViaje> reservaViaje) {
		this.reservaViaje = reservaViaje;
	}

}
