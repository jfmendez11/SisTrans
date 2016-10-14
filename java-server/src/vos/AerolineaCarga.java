package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class AerolineaCarga {
	
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="idIata")
	private String idIata;
	
	@JsonProperty(value="codigo")
	private String codigo;
	
	@JsonProperty(value="paisRadicacion")
	private String paisRadicacion;
	
	public AerolineaCarga (@JsonProperty(value="id") int id, @JsonProperty(value="nombre") String nombre, @JsonProperty(value="idIata") String idIata, @JsonProperty(value="codigo") String codigo, @JsonProperty(value="paisRadicacion") String paisRadicacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idIata = idIata;
		this.codigo = codigo;
		this.paisRadicacion = paisRadicacion;
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

	public String getIdIata() {
		return idIata;
	}

	public void setIdIata(String idIata) {
		this.idIata = idIata;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPaisRadicacion() {
		return paisRadicacion;
	}

	public void setPaisRadicacion(String paisRadicacion) {
		this.paisRadicacion = paisRadicacion;
	}
	

}
