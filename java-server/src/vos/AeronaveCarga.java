package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class AeronaveCarga {
	
	@JsonProperty(value="numeroDeSerie")
	private String numSerie;
	
	@JsonProperty(value="capacidad")
	private double capacidad;
	
	@JsonProperty(value="marca")
	private String marca;
	
	@JsonProperty(value="modelo")
	private String modelo;
	
	@JsonProperty(value="anioFabricacion")
	private int anoFabricacion;
	
	@JsonProperty(value="propiedadAerolinea")
	private boolean propiedadAerolinea;
	
	@JsonProperty(value="idAerolinea")
	private int idAerolinea;
	
	public AeronaveCarga (@JsonProperty(value="numeroDeSerie") String numSerie, @JsonProperty(value="capacidad") double capacidad, @JsonProperty(value="marca") String marca, @JsonProperty(value="modelo") String modelo, @JsonProperty(value="anioFabricacion") int anoFabricacion, @JsonProperty(value="propiedadAerolinea") boolean propiedadAerolinea, @JsonProperty(value="idAerolinea") int idAerolinea) {
		super();
		this.numSerie = numSerie;
		this.capacidad = capacidad;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacion = anoFabricacion;
		this.propiedadAerolinea = propiedadAerolinea;
		this.idAerolinea = idAerolinea;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoFabricacion() {
		return anoFabricacion;
	}

	public void setAnoFabricacion(int anoFabricacion) {
		this.anoFabricacion = anoFabricacion;
	}

	public boolean isPropiedadAerolinea() {
		return propiedadAerolinea;
	}

	public void setPropiedadAerolinea(boolean propiedadAerolinea) {
		this.propiedadAerolinea = propiedadAerolinea;
	}

	public int getIdAerolinea() {
		return idAerolinea;
	}

	public void setIdAerolinea(int idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

}
