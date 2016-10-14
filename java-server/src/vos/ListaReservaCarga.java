package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaReservaCarga {
	
	@JsonProperty(value="reservaCarga")
	private List<ReservaCarga> reservaCarga;
	
	public ListaReservaCarga( @JsonProperty(value="funcionariosAerolineaCarga")List<ReservaCarga> reservaCarga){
		this.reservaCarga = reservaCarga;
	}
	
	public List<ReservaCarga> getreservaCarga() {
		return reservaCarga;
	}
	
	public void setVideo(List<ReservaCarga> reservaCarga) {
		this.reservaCarga = reservaCarga;
	}

}
