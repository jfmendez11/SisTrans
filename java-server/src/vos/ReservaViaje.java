package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class ReservaViaje {
	
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="idVuelo")
	private String idVuelo;
	
	@JsonProperty(value="fechaSalidaVuelo")
	private Date fechaSalidaVuelo;
	
	@JsonProperty(value="fechaLlegadaVuelo")
	private Date fechaLlegadaVuelo;
	
	@JsonProperty(value="numeroSilla")
	private String numeroSilla;
	
	@JsonProperty(value="claseSilla")
	private String claseSilla;
	
	@JsonProperty(value="idCliente")
	private String idCliente;
	
	public ReservaViaje(@JsonProperty(value="id")int id,@JsonProperty(value="idVuelo")String idVuelo,@JsonProperty(value="fechaSalidaVuelo")Date fechaSalidaVuelo,@JsonProperty(value="fechaLlegadaVuelo")Date fechaLlegadaVuelo,@JsonProperty(value="numeroSilla")String numeroSilla, @JsonProperty(value="claseSilla")String claseSilla, @JsonProperty(value="idCliente")String idCliente){
		super();
		this.id = id;
		this.idVuelo = idVuelo;
		this.fechaSalidaVuelo = fechaSalidaVuelo;
		this.fechaLlegadaVuelo = fechaLlegadaVuelo;
		this.numeroSilla = numeroSilla;
		this.claseSilla = claseSilla;
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

	public String getNumeroSilla() {
		return numeroSilla;
	}

	public void setNumeroSilla(String numeroSilla) {
		this.numeroSilla = numeroSilla;
	}

	public String getClaseSilla() {
		return claseSilla;
	}

	public void setClaseSilla(String claseSilla) {
		this.claseSilla = claseSilla;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

}
