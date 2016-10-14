package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class ClienteCarga {
	
	@JsonProperty(value="id")
	private String id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="tipoIdentificacion")
	private String tipoIdentificacion;
	
	@JsonProperty(value="correoElectronico")
	private String correoElectronico;
	
	@JsonProperty(value="identificacion")
	private String identificacion;
	
	public ClienteCarga (@JsonProperty(value="id") String id, @JsonProperty(value="nombre") String nombre,@JsonProperty(value="tipoIdentificacion") String tipoIdentificacion,@JsonProperty(value="correoElectronico") String correoElectronico,@JsonProperty(value="identificacion") String identificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoIdentificacion = tipoIdentificacion;
		this.correoElectronico = correoElectronico;
		this.identificacion = identificacion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	

}
