
public class Materiale {
	private int codice;
	private String nome;
	private String fornitore;
	private String marca_materiale;
	private int disponibilit�;
	private double prezzo;
	private boolean singolo;
	
	public Materiale(int codice, String nome, String fornitore, String marca_materiale, int disponibilit�, double prezzo, boolean singolo) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.fornitore = fornitore;
		this.marca_materiale = marca_materiale;
		this.disponibilit� = disponibilit�;
		this.prezzo = prezzo;
		this.singolo = singolo;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFornitore() {
		return fornitore;
	}

	public void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}

	public String getMarca_materiale() {
		return marca_materiale;
	}

	public void setMarca_materiale(String marca_materiale) {
		this.marca_materiale = marca_materiale;
	}



	public int getDisponibilit�() {
		return disponibilit�;
	}

	public void setDisponibilit�(int disponibilit�) {
		this.disponibilit� = disponibilit�;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isSingolo() {
		return singolo;
	}

	public void setSingolo(boolean singolo) {
		this.singolo = singolo;
	}

	@Override
	public String toString() {
		return "Pezzo [codice=" + codice + ", nome=" + nome + ", fornitore=" + fornitore + ", marca_materiale="
				+ marca_materiale + ", disponibilit�=" + disponibilit� + ", prezzo=" + prezzo + ", singolo=" + singolo + "]";
	}
	
	

}
