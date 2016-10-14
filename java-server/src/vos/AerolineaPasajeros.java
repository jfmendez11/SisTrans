package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class AerolineaPasajeros {
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="idIata")
	private String idIata;
	
	@JsonProperty(value="codigo")
	private String codigo;
	
	@JsonProperty(value="idAerolinea")
	private int idAerolinea;
	
	@JsonProperty(value="paisRadicacion")
	private String paisRadicacion;

	public AerolineaPasajeros(@JsonProperty(value="nombre")String nombre,@JsonProperty(value="idIata")String idIata,@JsonProperty(value="codigo")String codigo,@JsonProperty(value="idAerolinea")int idAerolinea,@JsonProperty(value="paisRadicacion")String paisRadicacion){
		super();
		this.nombre = nombre;
		this.idIata =  idIata;
		this.codigo = codigo;
		this.idAerolinea =  idAerolinea;
		this.paisRadicacion = paisRadicacion;
		
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

	public int getIdAerolinea() {
		return idAerolinea;
	}

	public void setIdAerolinea(int idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

	public String getPaisRadicacion() {
		return paisRadicacion;
	}

	public void setPaisRadicacion(String paisRadicacion) {
		this.paisRadicacion = paisRadicacion;
	}
	
}
