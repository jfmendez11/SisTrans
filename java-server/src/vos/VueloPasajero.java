package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class VueloPasajero {
	
	@JsonProperty(value="idVuelo")
	private String idVuelo;
	
	@JsonProperty(value="horaSalida")
	private Date horaSalida;
	
	@JsonProperty(value="horaLlegada")
	private Date horaLlegada;
	
	@JsonProperty(value="frecuencia")
	private int frecuencia;
	
	@JsonProperty(value="distancia")
	private double distancia;
	
	@JsonProperty(value="duracion")
	private double duracion;
	
	@JsonProperty(value="clasificacion")
	private String clasificacion;
	
	@JsonProperty(value="costoEconomica")
	private double costoEconomica;
	
	@JsonProperty(value="costoEjecutiva")
	private double costoEjecutiva;
	
	@JsonProperty(value="aeropuertoSalida")
	private String aeropuertoSalida;
	
	@JsonProperty(value="aeropuertoLlegada")
	private String aeropuertoLlegada;
	
	@JsonProperty(value="idAerolinea")
	private int idAerolinea;
	
	@JsonProperty(value="numSerie")
	private String numSerie;
	
	public VueloPasajero (@JsonProperty(value="idVuelo") String idVuelo,@JsonProperty(value="horaSalida") Date horaSalida, @JsonProperty(value="horaLlegada") Date horaLlegada, @JsonProperty(value="frecuencia") int frecuencia, @JsonProperty(value="distancia") double distancia, @JsonProperty(value="duracion") double duracion, @JsonProperty(value="clasificacion") String clasificacion, @JsonProperty(value="costoEconomica") double costoEconomica, @JsonProperty(value="costoEjecutiva") double costoEjecutiva, @JsonProperty(value="aeropuertoSalida") String aeropuertoSalida, @JsonProperty(value="aeropuertoLlegada") String aeropuertoLlegada, @JsonProperty(value="idAerolinea") int idAerolinea, @JsonProperty(value="numSerie") String numSerie) {
		super();
		this.idVuelo = idVuelo;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.frecuencia = frecuencia;
		this.distancia = distancia;
		this.duracion = duracion;
		this.clasificacion = clasificacion;
		this.costoEconomica = costoEconomica;
		this.costoEjecutiva = costoEjecutiva;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.idAerolinea = idAerolinea;
		this.numSerie = numSerie;
	}

	public String getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Date getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(Date horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public double getCostoEconomica() {
		return costoEconomica;
	}

	public void setCostoEconomica(double costoEconomica) {
		this.costoEconomica = costoEconomica;
	}
	
	public double getCostoEjecutiva() {
		return costoEjecutiva;
	}

	public void setCostoEjecutiva(double costoEjecutiva) {
		this.costoEjecutiva = costoEjecutiva;
	}

	public String getAeropuertoSalida() {
		return aeropuertoSalida;
	}

	public void setAeropuertoSalida(String aeropuertoSalida) {
		this.aeropuertoSalida = aeropuertoSalida;
	}

	public String getAeropuertoLlegada() {
		return aeropuertoLlegada;
	}

	public void setAeropuertoLlegada(String aeropuertoLlegada) {
		this.aeropuertoLlegada = aeropuertoLlegada;
	}

	public int getIdAerolinea() {
		return idAerolinea;
	}

	public void setIdAerolinea(int idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
}
