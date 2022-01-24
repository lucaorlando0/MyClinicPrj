import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Prenotazione implements Observer{
	private int id_prenotazione;
	private int id_operazione;
	private SalaOperatoria sala_operatoria;
	private Paziente paziente;
	private boolean prenotato = true;
	
	public Prenotazione(int id_prenotazione, int id_operazione, SalaOperatoria sala_operatoria, Paziente paziente) {
		super();
		this.id_prenotazione = id_prenotazione;
		this.id_operazione = id_operazione;
		this.sala_operatoria = sala_operatoria;
		this.sala_operatoria.addObserver(this);
		this.paziente = paziente;
	}

	public int getId_prenotazione() {
		return id_prenotazione;
	}
	public void setId_prenotazione(int id_prenotazione) {
		this.id_prenotazione = id_prenotazione;
	}

	public void setId_operazione(int id_operazione) {
		this.id_operazione = id_operazione;
	}
	public int getId_operazione() {
		return id_operazione;
	}



	public SalaOperatoria getSala_operatoria() {
		return sala_operatoria;
	}

	public void setSala_operatoria(SalaOperatoria sala_operatoria) {
		this.sala_operatoria = sala_operatoria;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public boolean isPrenotato() {
		return prenotato;
	}

	public void setPrenotato(boolean prenotato) {
		this.prenotato = prenotato;
	}

	@Override
	public void update(Observable o, Object arg) {
		int posti_liberi = ((SalaOperatoria)o).getPosti_disponibili();
		if(posti_liberi > 0 && prenotato) {
			System.err.println("Si e' liberato un posto in sala " + ((SalaOperatoria)o).getNome() + " mandare una mail a " + this.getPaziente().getEmail());
			this.prenotato = false;
		}
	}

	@Override
	public String toString() {
		return "Prenotazione [id_prenotazione=" + id_prenotazione + ", sala_operatoria=" + sala_operatoria
				+ ", cliente=" + paziente + ", prenotato=" + prenotato + "]";
	}

}
