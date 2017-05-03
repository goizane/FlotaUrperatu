package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Bonba;
import logika.Laukia;
import logika.Ontzia;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class BonbaTest {
	
	Bonba bonba1 = new Bonba(5);
	Bonba bonba2 = new Bonba(50);
	Bonba bonba3 = new Bonba(90);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBonba() {
		assertNotNull(bonba1);
		assertNotNull(bonba2);
		assertNotNull(bonba3);
		
		assertTrue(bonba1.getIzena()=="bonba");
		assertTrue(bonba1.getKantitatea()==5);
		assertTrue(bonba1.getPrezioa()==10);
		
		assertTrue(bonba2.getIzena()=="bonba");
		assertFalse(bonba2.getIzena()=="Okerra den izena!");
		assertTrue(bonba2.getKantitatea()==50);
		assertFalse(bonba2.getKantitatea()==330);
		assertTrue(bonba2.getPrezioa()==10);
		assertFalse(bonba2.getPrezioa()==100000);
		
		assertTrue(bonba3.getIzena()=="bonba");
		assertFalse(bonba3.getIzena()=="Okerra den izena!");
		assertTrue(bonba3.getKantitatea()==90);
		assertFalse(bonba3.getKantitatea()==789);
		assertTrue(bonba3.getPrezioa()==10);
		assertFalse(bonba3.getPrezioa()==4567);
	}

	@Test
	public void testMinEgin() {
		Laukia lauki1 = new Laukia();
		bonba1.minEgin(lauki1);
		
		Laukia lauki2 = new Laukia();
		Ontzia ontzi2 = new Ontzia("Itsaspeko");
		lauki2.ontziaSartu(ontzi2);
		bonba2.minEgin(lauki2);
		
		Laukia lauki3 = new Laukia();
		Ontzia ontzi3 = new Ontzia("Itsaspeko");
		lauki3.ontziaSartu(ontzi3);
		bonba3.minEgin(lauki3);
	}
}