package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class ViajesRealizadosCarga {

	@JsonProperty(value="idVueloRealCarga")
	private String idVueloRealCarga;
	
	@JsonProperty(value="idClienteCarga")
	private String idClienteCarga;
	
	@JsonProperty(value="horaSalidaVuelo")
	private Date horaSalidaVuelo;
	
	@JsonProperty(value="horaLlegadaVuelo")
	private Date horaLlegadaVuelo;
	
	
	public ViajesRealizadosCarga(@JsonProperty(value="idVueloRealCarga")String idVueloRealCarga, @JsonProperty(value="idClienteCarga")String idClienteCarga, @JsonProperty(value="horaSalidaVuelo")Date horaSalidaVuelo,@JsonProperty(value="horaLlegadaVuelo")Date horaLlegadaVuelo ){
		super();
		this.idVueloRealCarga = idVueloRealCarga;
		this.idClienteCarga = idClienteCarga;
		this.horaSalidaVuelo = horaSalidaVuelo;
		this.horaLlegadaVuelo = horaLlegadaVuelo;
		
	}


	public String getIdVueloRealCarga() {
		return idVueloRealCarga;
	}


	public void setIdVueloRealCarga(String idVueloRealCarga) {
		this.idVueloRealCarga = idVueloRealCarga;
	}


	public String getIdClienteCarga() {
		return idClienteCarga;
	}


	public void setIdClienteCarga(String idClienteCarga) {
		this.idClienteCarga = idClienteCarga;
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
