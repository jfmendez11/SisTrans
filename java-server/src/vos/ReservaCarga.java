package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class ReservaCarga {

	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="idVuelo")
	private String idVuelo;
	
	@JsonProperty(value="fechaSalidaVuelo")
	private Date fechaSalidaVuelo;
	
	@JsonProperty(value="fechaLlegadaVuelo")
	private Date fechaLlegadaVuelo;
	
	@JsonProperty(value="contenido")
	private String contenido;
	
	@JsonProperty(value="volumen")
	private double volumen;
	
	@JsonProperty(value="peso")
	private double peso;
	
	@JsonProperty(value="idCliente")
	private String idCliente;
	
	public ReservaCarga(@JsonProperty(value="id")int id,@JsonProperty(value="idVuelo")String idVuelo,@JsonProperty(value="fechaSalidaVuelo")Date fechaSalidaVuelo,@JsonProperty(value="fechaLlegadaVuelo")Date fechaLlegadaVuelo,@JsonProperty(value="contenido")String contenido, @JsonProperty(value="volumen")double volumen,@JsonProperty(value="peso")double peso, @JsonProperty(value="idCliente")String idCliente){
		super();
		this.id = id;
		this.idVuelo = idVuelo;
		this.fechaSalidaVuelo = fechaSalidaVuelo;
		this.fechaLlegadaVuelo = fechaLlegadaVuelo;
		this.contenido = contenido;
		this.volumen = volumen;
		this.peso = peso;
		this.idCliente = idCliente;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Date getFechaSalidaVuelo() {
		return fechaSalidaVuelo;
	}

	public void setFechaSalidaVuelo(Date fechaSalidaVuelo) {
		this.fechaSalidaVuelo = fechaSalidaVuelo;
	}

	public Date getFechaLlegadaVuelo() {
		return fechaLlegadaVuelo;
	}

	public void setFechaLlegadaVuelo(Date fechaLlegadaVuelo) {
		this.fechaLlegadaVuelo = fechaLlegadaVuelo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
