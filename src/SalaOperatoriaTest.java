import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SalaOperatoriaTest {

	@Test
	void testIncrementaPosto1() { // incremento con numero positivo
		SalaOperatoria so = new SalaOperatoria(1, "[SALA 1]", 5);
		so.incrementaPostiDisponibili(15);
		int ris = so.getPosti_disponibili();
		assertEquals(20, ris);
	}
	
	@Test
	void testIncrementaPosto2() { // incremento con numero negativo
		SalaOperatoria so = new SalaOperatoria(1, "[SALA 1]", 25);
		so.incrementaPostiDisponibili(-20);
		int ris = so.getPosti_disponibili();
		assertEquals(25, ris);
	}
	
	@Test
	void testAssegnaPosto() { // assegnazioni avvengono con successo fino ad esaurimento dei posti disponibili
		SalaOperatoria so = new SalaOperatoria(1, "[SALA 1]", 3);
		so.assegnaPosto();
		so.assegnaPosto();
		so.assegnaPosto();
		so.assegnaPosto();
		int ris = so.getPosti_disponibili();
		assertEquals(0, ris);
	}
	

}
