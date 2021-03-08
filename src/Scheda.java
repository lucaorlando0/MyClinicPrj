import java.util.ArrayList;

public class Scheda {
	
	private int ID;
	private String CF;
	private int numero_sedute = 0;
	private ArrayList<Materiale> materiali;
	private double totalePrezzo;
	
	public Scheda(int iD, String cF, ArrayList<Materiale> materiali) {
		super();
		this.ID = iD;
		this.CF = cF;
		this.materiali = materiali;
		this.calcolaTotale();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCF() {
		return CF;
	}

	public void setCF(String cF) {
		CF = cF;
	}

	public int getNumero_sedute() {
		return numero_sedute;
	}

	public void setNumero_sedute(int numero_sedute) {
		this.numero_sedute = numero_sedute;
	}

	public ArrayList<Materiale> getMateriali() {
		return materiali;
	}

	public void setMateriali(ArrayList<Materiale> materiali) {
		this.materiali = materiali;
	}
	
	public void addMateriali(ArrayList<Materiale> materiali) {
		this.materiali.addAll(materiali);
	}

	public double getTotalePrezzo() {
		return totalePrezzo;
	}

	public void setTotalePrezzo(double totalePrezzo) {
		this.totalePrezzo = totalePrezzo;
	}

	@Override
	public String toString() {
		return "Scheda [ID=" + ID + ", CF=" + CF + ", numero_sedute=" + numero_sedute + ", materiali=" + materiali
				+ ", totalePrezzo=" + totalePrezzo + "]";
	}
	
	public double calcolaTotale() {
		double tot = 0;
		for(int i =0; i<materiali.size();i++) {
			if(materiali.get(i).getPrezzo()>=0) {
				tot = tot + materiali.get(i).getPrezzo();
			}
		}
		tot = tot + (this.numero_sedute*100);
		this.setTotalePrezzo(tot);
		return tot;
	}

}
