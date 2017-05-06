package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Laukia;
import logika.Misil;
import logika.Ontzia;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class MisilTest {
	
	Misil misil1 = new Misil(5);
	Misil misil2 = new Misil(10);
	Misil misil3 = new Misil(15);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMisil() {
		assertNotNull(misil1);
		
		assertNotNull(misil2);
		
		assertNotNull(misil3);
		
		assertEquals(misil1.getIzena(), "misil");
		assertEquals(misil1.getKantitatea(), 5);
		assertEquals(misil1.getPrezioa(), 20);
		
		assertEquals(misil2.getIzena(), "misil");
		assertNotEquals(misil2.getIzena(), "Okerra den izena!");
		assertEquals(misil2.getKantitatea(), 10);
		assertNotEquals(misil2.getKantitatea(), 330);
		assertEquals(misil2.getPrezioa(), 20);
		assertNotEquals(misil2.getPrezioa(), 100000);
		
		assertEquals(misil3.getIzena(), "misil");
		assertNotEquals(misil3.getIzena(), "Okerra den izena!");
		assertEquals(misil3.getKantitatea(), 15);
		assertNotEquals(misil3.getKantitatea(), 789);
		assertEquals(misil3.getPrezioa(), 20);
		assertNotEquals(misil3.getPrezioa(), 4567);
	}

	@Test
	public void testMinEgin() {
		Laukia lauki1 = new Laukia();
		misil1.minEgin(lauki1);
		
		Laukia lauki2 = new Laukia();
		Ontzia ontzi2 = new Ontzia("Itsaspeko");
		lauki2.ontziaSartu(ontzi2);
		misil2.minEgin(lauki2);
		
		Laukia lauki3 = new Laukia();
		Ontzia ontzi3 = new Ontzia("Itsaspeko");
		lauki3.ontziaSartu(ontzi3);
		misil2.minEgin(lauki3);
	}
}