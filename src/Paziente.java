
public class Paziente {
	
	private int CF;
	private String nome;
	private String cognome;
	private String email;
	private String cellulare;
	private int operazioni_passate = 0;
	
	public Paziente() {}
	public Paziente(int cF, String nome, String cognome, String email, String cellulare) {
		super();
		this.CF = cF;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.cellulare = cellulare;
	}
	public int getCF() {
		return CF;
	}
	public void setCF(int cF) {
		CF = cF;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellulare() {
		return cellulare;
	}
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	public int getoperazioni_passate() {
		return operazioni_passate;
	}
	public void setoperazioni_passate(int operazioni_passate) {
		this.operazioni_passate = operazioni_passate;
	}
	@Override
	public String toString() {
		return "Cliente [CF=" + CF + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", cellulare="
				+ cellulare + ", operazioni_passate=" + operazioni_passate + "]";
	};
	
}
