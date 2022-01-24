import java.util.Observable;

@SuppressWarnings("deprecation")
public class SalaOperatoria extends Observable {
	private int id_sala;
	private String nome;
	private int posti_disponibili;
	
	public SalaOperatoria(int id_sala, String nome, int posti_disponibili) {
		super();
		this.id_sala = id_sala;
		this.nome = nome;
		if (posti_disponibili > 0) this.posti_disponibili = posti_disponibili;
	}

	public int getId_sala() {
		return id_sala;
	}

	public void setId_sala(int id_sala) {
		this.id_sala = id_sala;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPosti_disponibili() {
		return posti_disponibili;
	}

	public void setPosti_disponibili(int posti_disponibili) {
		this.posti_disponibili = posti_disponibili;
		setChanged();
		notifyObservers();
	}
	
	public void incrementaPostiDisponibili(int posti){
		if(posti > 0){
		this.setPosti_disponibili(posti + this.getPosti_disponibili());
		}
	}
	
	public boolean assegnaPosto() {
		if(this.getPosti_disponibili()>0) {
			System.err.println("Area lavoro: posto assegnato in "+this.nome+", ora i posti sono: " + (this.getPosti_disponibili()-1) +" prima erano : "+this.getPosti_disponibili());
			this.setPosti_disponibili(this.getPosti_disponibili()-1);	
			return true;
		}
		else {	
			System.err.println("Area lavoro: posto non disponibile in "+this.nome);
			return false;
		}
	
	}

	@Override
	public String toString() {
		return "AreaLavoro [id_sala=" + id_sala + ", nome=" + nome + ", posti_disponibili=" + posti_disponibili
				+ "]";
	}
	
}
