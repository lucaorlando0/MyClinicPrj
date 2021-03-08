import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class StartUp {
	private static ArrayList<Paziente> pazienti;
	private static ArrayList<Materiale> materiali;

	private static ArrayList<SalaOperatoria> sale_operatorie;
	
	public StartUp(){
		pazienti= new ArrayList<Paziente>();
		materiali= new  ArrayList<Materiale>();

		sale_operatorie = new ArrayList<SalaOperatoria>();
	}
	
	public ArrayList<Paziente> caricaPazienti() throws IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Paziente> pl =(List<Paziente>)session.createQuery("from Paziente").list();
		for(Paziente pa: pl) {
			pazienti.add(pa);
		}
		session.close();
		return pazienti;
	}
	
	public ArrayList<Materiale> caricaMateriali() {
		Materiale mat1 = new Materiale(1, "Bisturi", "Medical_j", "paradontax", 147, 15.7,  true);
		Materiale mat2 = new Materiale(2, "Raschietto", "NewHospital", "DentalPro", 45, 9.8,  true);

		materiali.add(mat1);
		materiali.add(mat2);

		return materiali;
	}
	

	
	public ArrayList <SalaOperatoria> caricaSale() {
		SalaOperatoria so1 = new SalaOperatoria(1, "[SALA 1]", 1);
		SalaOperatoria so2 = new SalaOperatoria(2, "[SALA 2]", 5);
		SalaOperatoria so3 = new SalaOperatoria(3, "[SALA 3]", 5);
		sale_operatorie.add(so1);
		sale_operatorie.add(so2);
		sale_operatorie.add(so3);
		return sale_operatorie;
	}

}
