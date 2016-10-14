package vos;
import org.codehaus.jackson.annotate.*;


public class Administrador {
	
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="identificacion")
	private String identificacion;
	
	@JsonProperty(value="tipoIdentificacion")
	private String tipoIdentificacion;
	
	@JsonProperty(value="correoElectronico")
	private String correoElectronico;
	
	public Administrador (@JsonProperty(value="id") int id, @JsonProperty(value="nombre") String nombre, @JsonProperty(value="identificacion") String identificacion, @JsonProperty(value="tipoIdentificacion") String tipoIdentificacion, @JsonProperty(value="correoElectronico") String correoElectronico) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.tipoIdentificacion = tipoIdentificacion;
		this.correoElectronico = correoElectronico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
}
