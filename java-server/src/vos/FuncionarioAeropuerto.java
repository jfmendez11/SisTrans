package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class FuncionarioAeropuerto {
	
	@JsonProperty(value="codigoAeropuerto")
	private String codigoAeropuerto;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="identificacion")
	private String identificacion;
	
	@JsonProperty(value="correoElectronico")
	private String correoElectronico;
	
	@JsonProperty(value="tipoIdentificacion")
	private String tipoIdentificacion;
	
	@JsonProperty(value="id")
	private int id;
	
	public FuncionarioAeropuerto (@JsonProperty(value="codigoAeropuerto") String codigoAeropuerto,@JsonProperty(value="nombre") String nombre,@JsonProperty(value="identificacion") String identificacion,@JsonProperty(value="correoElectronico") String correoElectronico,@JsonProperty(value="tipoIdentificacion") String tipoIdentificacion,@JsonProperty(value="id") int id) {
		super();
		this.codigoAeropuerto = codigoAeropuerto;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.correoElectronico = correoElectronico;
		this.tipoIdentificacion = tipoIdentificacion;
		this.id = id;
	}

	public String getCodigoAeropuerto() {
		return codigoAeropuerto;
	}

	public void setCodigoAeropuerto(String codigoAeropuerto) {
		this.codigoAeropuerto = codigoAeropuerto;
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
