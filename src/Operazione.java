
public class Operazione {
	private Scheda scheda;
	private Paziente paziente;
	private int id_sala;
	private boolean pagato = false;
	
	public Operazione(Scheda scheda, Paziente paziente, int id_sala) {
		super();
		this.scheda = scheda;
		this.paziente = paziente;
		this.id_sala = id_sala;
	}

	public Scheda getScheda() {
		return scheda;
	}

	public void setScheda(Scheda scheda) {
		this.scheda = scheda;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}



	public boolean isPagato() {
		return pagato;
	}

	public void setPagato(boolean pagato) {
		this.pagato = pagato;
	}
	
	public int getId_sala() {
		return id_sala;
	}

	public void setId_sala(int id_sala) {
		this.id_sala = id_sala;
	}


	@Override
	public String toString() {
		return "Operazione [scheda=" + scheda + ", paziente=" + paziente  + ", id_sala="
				+ id_sala + ", pagato=" + pagato + "]";
	}

}
