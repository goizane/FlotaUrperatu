package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Ezkutua;
import logika.Ontzia;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class EzkutuaTest {
	
	Ezkutua ezkutua1 = new Ezkutua(5);
	Ezkutua ezkutua2 = new Ezkutua(10);
	Ezkutua ezkutua3 = new Ezkutua(15);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEzkutua() {
		assertNotNull(ezkutua1);
		assertNotNull(ezkutua2);
		assertNotNull(ezkutua3);
		
		assertTrue(ezkutua1.getKantitatea()==5);
		assertFalse(ezkutua1.getKantitatea()==155);
		
		assertTrue(ezkutua2.getKantitatea()==10);
		assertFalse(ezkutua2.getKantitatea()==777);
		
		assertTrue(ezkutua3.getKantitatea()==15);
		assertFalse(ezkutua3.getKantitatea()==100);
	}

	@Test
	public void testOntziaEzkututatu() {
		Ontzia ontzia1 = new Ontzia("Itsaspeko");
		String egoeraNormala = ontzia1.getEgora();
		ezkutua1.ontziaEzkututatu(ontzia1);
		String egoeraEzkutatua = ontzia1.getEgora();
		assertNotEquals(egoeraEzkutatua, egoeraNormala);
		
		Ontzia ontzia2 = new Ontzia("Itsaspeko");
		String egoeraNormala2 = ontzia2.getEgora();
		ezkutua2.ontziaEzkututatu(ontzia2);
		String egoeraEzkutatua2 = ontzia2.getEgora();
		assertNotEquals(egoeraEzkutatua2, egoeraNormala2);
		
		Ontzia ontzia3 = new Ontzia("Itsaspeko");
		String egoeraNormala3 = ontzia3.getEgora();
		ezkutua3.ontziaEzkututatu(ontzia3);
		String egoeraEzkutatua3 = ontzia3.getEgora();
		assertNotEquals(egoeraEzkutatua3, egoeraNormala3);
	}

	@Test
	public void testEzkutuaErabili() {
		assertNotNull(ezkutua1);
		assertNotNull(ezkutua2);
		assertNotNull(ezkutua3);
		
		assertTrue(ezkutua1.getKantitatea()==5);
		assertFalse(ezkutua1.getKantitatea()==155);
		
		assertTrue(ezkutua2.getKantitatea()==10);
		assertFalse(ezkutua2.getKantitatea()==777);
		
		assertTrue(ezkutua3.getKantitatea()==15);
		assertFalse(ezkutua3.getKantitatea()==100);
		
		ezkutua1.ezkutuaErabili();
		assertTrue(ezkutua1.getKantitatea()==4);
		assertFalse(ezkutua1.getKantitatea()==5);
		ezkutua1.ezkutuaErabili();
		assertTrue(ezkutua1.getKantitatea()==3);
		assertFalse(ezkutua1.getKantitatea()==4);
		ezkutua1.ezkutuaErabili();
		assertTrue(ezkutua1.getKantitatea()==2);
		assertFalse(ezkutua1.getKantitatea()==3);
		ezkutua1.ezkutuaErabili();
		assertTrue(ezkutua1.getKantitatea()==1);
		assertFalse(ezkutua1.getKantitatea()==2);
		
		ezkutua2.ezkutuaErabili();
		assertTrue(ezkutua2.getKantitatea()==9);
		assertFalse(ezkutua2.getKantitatea()==10);
		ezkutua2.ezkutuaErabili();
		assertTrue(ezkutua2.getKantitatea()==8);
		assertFalse(ezkutua2.getKantitatea()==9);
		ezkutua2.ezkutuaErabili();
		assertTrue(ezkutua2.getKantitatea()==7);
		assertFalse(ezkutua2.getKantitatea()==8);
		ezkutua2.ezkutuaErabili();
		assertTrue(ezkutua2.getKantitatea()==6);
		assertFalse(ezkutua2.getKantitatea()==7);
		
		ezkutua3.ezkutuaErabili();
		assertTrue(ezkutua3.getKantitatea()==14);
		assertFalse(ezkutua3.getKantitatea()==15);
		ezkutua3.ezkutuaErabili();
		assertTrue(ezkutua3.getKantitatea()==13);
		assertFalse(ezkutua3.getKantitatea()==14);
		ezkutua3.ezkutuaErabili();
		assertTrue(ezkutua3.getKantitatea()==12);
		assertFalse(ezkutua3.getKantitatea()==13);
		ezkutua3.ezkutuaErabili();
		assertTrue(ezkutua3.getKantitatea()==11);
		assertFalse(ezkutua3.getKantitatea()==12);
	}

	@Test
	public void testGetKantitatea() {
		assertNotNull(ezkutua1);
		assertNotNull(ezkutua2);
		assertNotNull(ezkutua3);
		
		assertTrue(ezkutua1.getKantitatea()==5);
		assertFalse(ezkutua1.getKantitatea()==155);
		
		assertTrue(ezkutua2.getKantitatea()==10);
		assertFalse(ezkutua2.getKantitatea()==777);
		
		assertTrue(ezkutua3.getKantitatea()==15);
		assertFalse(ezkutua3.getKantitatea()==100);
	}
}