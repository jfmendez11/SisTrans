package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ClienteViajero {
	
	@JsonProperty(value="idViajero")
	private String idViajero;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="identificacion")
	private String identificacion;
	
	@JsonProperty(value="tipoIdentificacion")
	private String tipoIdentificacion;
	
	@JsonProperty(value="correoElectronico")
	private String correoElectronico;
	
	@JsonProperty(value="nacionalidades")
	private String nacionalidades;
	
	public ClienteViajero(@JsonProperty(value="idViajero")String idViajero, @JsonProperty(value="nombre")String nombre,@JsonProperty(value="identificacion") String identificacion,@JsonProperty(value="tipoIdentificacion") String tipoIdentificacion,@JsonProperty(value="correoElectrico") String correoElectronico, @JsonProperty(value="nacionalidades") String nacionalidades) {
		super();
		this.idViajero = idViajero;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.tipoIdentificacion =  tipoIdentificacion;
		this.correoElectronico =  correoElectronico;
		this.nacionalidades = nacionalidades;
	}

	public String getIdViajero() {
		return idViajero;
	}

	public void setIdViajero(String idViajero) {
		this.idViajero = idViajero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getNacionalidades() {
		return nacionalidades;
	}

	public void setNacionalidades(String nacionalidades) {
		this.nacionalidades = nacionalidades;
	}

}
