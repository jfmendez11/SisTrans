package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class ViajesRealizadosPasajero {
	
	@JsonProperty(value="idVueloRealPas")
	private String idVueloRealPas;
	
	@JsonProperty(value="idClientePas")
	private String idClientePas;
	
	@JsonProperty(value="horaSalidaVuelo")
	private Date horaSalidaVuelo;
	
	@JsonProperty(value="horaLlegadaVuelo")
	private Date horaLlegadaVuelo;
	
	
	public ViajesRealizadosPasajero(@JsonProperty(value="idVueloRealPas")String idVueloRealPas, @JsonProperty(value="idClientePas")String idClientePas, @JsonProperty(value="horaSalidaVuelo")Date horaSalidaVuelo,@JsonProperty(value="horaLlegadaVuelo")Date horaLlegadaVuelo ){
		super();
		this.idVueloRealPas = idVueloRealPas;
		this.idClientePas = idClientePas;
		this.horaSalidaVuelo = horaSalidaVuelo;
		this.horaLlegadaVuelo = horaLlegadaVuelo;
	}


	public String getIdVueloRealPas() {
		return idVueloRealPas;
	}


	public void setIdVueloRealPas(String idVueloRealPas) {
		this.idVueloRealPas = idVueloRealPas;
	}


	public String getIdClientePas() {
		return idClientePas;
	}


	public void setIdClientePas(String idClientePas) {
		this.idClientePas = idClientePas;
	}


	public Date getHoraSalidaVuelo() {
		return horaSalidaVuelo;
	}


	public void setHoraSalidaVuelo(Date horaSalidaVuelo) {
		this.horaSalidaVuelo = horaSalidaVuelo;
	}


	public Date getHoraLlegadaVuelo() {
		return horaLlegadaVuelo;
	}


	public void setHoraLlegadaVuelo(Date horaLlegadaVuelo) {
		this.horaLlegadaVuelo = horaLlegadaVuelo;
	}

}
