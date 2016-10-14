package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaAerolineaCarga {
	
	@JsonProperty(value="aerolineasCarga")
	private List<AerolineaCarga> aerolineas;
	
	public ListaAerolineaCarga( @JsonProperty(value="aerolineasCarga")List<AerolineaCarga> ac){
		this.aerolineas = ac;
	}

	public List<AerolineaCarga> getAerolineasCarga() {
		return aerolineas;
	}

	public void setAerolineasCarga(List<AerolineaCarga> ac) {
		this.aerolineas = ac;
	}

}
