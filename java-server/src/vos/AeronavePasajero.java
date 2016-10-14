package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class AeronavePasajero {
	
	@JsonProperty(value="numeroDeSerie")
	private String numSerie;
	
	@JsonProperty(value="capacidadEconomica")
	private int capacidadEconomica;
	
	@JsonProperty(value="capacidadEjecutiva")
	private int capacidadEjecutiva;
	
	@JsonProperty(value="marca")
	private String marca;
	
	@JsonProperty(value="anioFabricacion")
	private int anoFabricacion;
	
	@JsonProperty(value="propiedadAerolinea")
	private boolean propiedadAerolinea;
	
	@JsonProperty(value="modelo")
	private String modelo;
	
	@JsonProperty(value="idAerolinea")
	private int idAerolinea;
	
	public AeronavePasajero (@JsonProperty(value="numeroDeSerie") String numSerie, @JsonProperty(value="capacidadEconomica") int capacidadEconomica, @JsonProperty(value="capacidadEjecutiva") int capacidadEjecutiva, @JsonProperty(value="marca") String marca, @JsonProperty(value="anioFabricacion") int anoFabricacion, @JsonProperty(value="propiedadAerolinea") boolean propiedadAerolinea, @JsonProperty(value="modelo") String modelo,@JsonProperty(value="idAerolinea") int idAerolinea) {
		super();
		this.numSerie = numSerie;
		this.capacidadEconomica = capacidadEconomica;
		this.capacidadEjecutiva = capacidadEjecutiva;
		this.marca = marca;
		this.anoFabricacion = anoFabricacion;
		this.propiedadAerolinea = propiedadAerolinea;
		this.modelo = modelo;
		this.idAerolinea = idAerolinea;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public double getCapacidadEconomica() {
		return capacidadEconomica;
	}

	public void setCapacidadEconomica(int capacidadEconomica) {
		this.capacidadEconomica = capacidadEconomica;
	}
	
	public double getCapacidadEjecutiva() {
		return capacidadEjecutiva;
	}

	public void setCapacidadEjecutiva(int capacidadEjecutiva) {
		this.capacidadEjecutiva = capacidadEjecutiva;
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
