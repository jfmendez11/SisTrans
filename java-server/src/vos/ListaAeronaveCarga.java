package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaAeronaveCarga {
	
	@JsonProperty(value="aeronavesCarga")
	private List<AeronaveCarga> aeronaves;
	
	public ListaAeronaveCarga( @JsonProperty(value="aeronavesCarga")List<AeronaveCarga> ac){
		this.aeronaves = ac;
	}

	public List<AeronaveCarga> getAeronavesCarga() {
		return aeronaves;
	}

	public void setAeronavesCarga(List<AeronaveCarga> ac) {
		this.aeronaves = ac;
	}

}
