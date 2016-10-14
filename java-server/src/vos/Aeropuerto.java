package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Aeropuerto {
	
	@JsonProperty(value="codigo")
	private String codigo;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="capacidad")
	private String capacidad;
	
	@JsonProperty(value="ciudad")
	private String ciudad;
	
	@JsonProperty(value="pais")
	private String pais;
	
	public Aeropuerto (@JsonProperty(value="codigo") String codigo, @JsonProperty(value="nombre") String nombre, @JsonProperty(value="capacidad") String capacidad, @JsonProperty(value="ciudad") String ciudad, @JsonProperty(value="pais") String pais) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.ciudad = ciudad;
		this.pais = pais;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
