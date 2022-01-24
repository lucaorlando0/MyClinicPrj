import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SchedaTest {

	@Test
	void testCalcoloTot1() { // solo materiali con prezzi positivi
		ArrayList<Materiale> materiali = new ArrayList<Materiale>();
		Materiale mat1 = new Materiale(1, "Bisturi", "Medical_j", "paradontax", 147, 15.7,  true);
		Materiale mat2 = new Materiale(2, "Raschietto", "NewHospital", "DentalPro", 45, 9.8,  true);
		materiali.add(mat1);
		materiali.add(mat2);
		Scheda scheda = new Scheda(1, "5", materiali);
		double ris = scheda.calcolaTotale();

	}
	
	@Test
	void testCalcoloTot2() { // presente  un materiale con prezzo negativo
		ArrayList<Materiale> materiali = new ArrayList<Materiale>();
		Materiale mat1 = new Materiale(1, "Bisturi", "Medical_j", "paradontax", 147, -15.7,  true);
		Materiale mat2 = new Materiale(2, "Raschietto", "NewHospital", "DentalPro", 45, 9.8,  true);
		materiali.add(mat1);
		materiali.add(mat2);
		Scheda scheda = new Scheda(1, "5", materiali);
		double ris = scheda.calcolaTotale();

	}
	

}
