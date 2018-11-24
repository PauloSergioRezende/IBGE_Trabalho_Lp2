

public class Municipio {
	private String siglaUF;
	private String codUF;
	private String codMun;
	private String municipio;
	private String populacao;
	
	// construtores
	public Municipio() {
	}
	public Municipio(String siglaUF, String codUF, 
					 String codMun, String municipio, String populacao) {
		this.siglaUF = siglaUF;
		this.codUF = codUF;
		this.codMun = codMun;
		this.municipio = municipio;
		this.populacao = populacao;
	}
	// toString ...
	@Override
	public String toString() {
		return "\nsiglaUF=" + siglaUF 
				+ ", codUF=" + codUF 
				+ ", codMun=" + codMun 
				+ ", municipio=" + municipio
				+ ", populacao=" + populacao;
	}
	
	// getters & setters
	public String getSiglaUF() {
		return siglaUF;
	}
	public void setSiglaUF(String siglaUF) {
		this.siglaUF = siglaUF;
	}
	public String getCodUF() {
		return codUF;
	}
	public void setCodUF(String codUF) {
		this.codUF = codUF;
	}
	public String getCodMun() {
		return codMun;
	}
	public void setCodMun(String codMun) {
		this.codMun = codMun;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getPopulacao() {
		return populacao;
	}
	public void setPopulacao(String populacao) {
		this.populacao = populacao;
	}
	
	
}
