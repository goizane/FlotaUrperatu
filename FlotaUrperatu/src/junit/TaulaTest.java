package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Laukia;
import logika.Ontzia;
import logika.Taula;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class TaulaTest {
	
	Taula taula1;
	Taula taula2;
	Taula taula3;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		taula1 = null;
		taula2 = null;
		taula3 = null;
	}

	@Test
	public void testTaula() {
		taula1 = new Taula();
		taula2 = new Taula();
		taula3 = new Taula();
		
		assertNotNull(taula1);
		assertNotNull(taula2);
		assertNotNull(taula3);
	}

	@Test
	public void testJarDaiteke() {
		taula1 = new Taula();
		taula2 = new Taula();
		taula3 = new Taula();
		
		assertNotNull(taula1);
		assertNotNull(taula2);
		assertNotNull(taula3);
		
		assertTrue(taula1.jarDaiteke(3, 4, 5, 'h'));
		assertTrue(taula1.jarDaiteke(2, 6, 7, 'h'));
		assertFalse(taula1.jarDaiteke(3, 9, 9, 'h'));
		assertFalse(taula1.jarDaiteke(2, 9, 9, 'h'));
		assertFalse(taula1.jarDaiteke(3, 8, 8, 'h'));
	}

	@Test
	public void testOntziaKokatu() {
		taula1 = new Taula();
		taula2 = new Taula();
		taula3 = new Taula();
		
		assertNotNull(taula1);
		assertNotNull(taula2);
		assertNotNull(taula3);
		
		Ontzia ontzia1 = new Ontzia("Itsaspeko");
		Ontzia ontzia2 = new Ontzia("Itsaspeko");
		Ontzia ontzia3 = new Ontzia("Itsaspeko");
		
		assertTrue(taula1.jarDaiteke(3, 3, 3, 'h'));
		taula1.ontziaKokatu(3, 3, 3, 'h', ontzia1);
		assertFalse(taula1.jarDaiteke(3, 3, 3, 'h'));
		
		assertTrue(taula2.jarDaiteke(2, 6, 6, 'h'));
		taula2.ontziaKokatu(2, 6, 6, 'h', ontzia2);
		assertFalse(taula2.jarDaiteke(2, 6, 6, 'h'));
		
		assertTrue(taula3.jarDaiteke(3, 5, 5, 'h'));
		taula3.ontziaKokatu(3, 5, 5, 'h', ontzia3);
		assertFalse(taula3.jarDaiteke(3, 5, 5, 'h'));
	}

	@Test
	public void testTamaina() {
		taula1 = new Taula();
		taula2 = new Taula();
		taula3 = new Taula();
		
		assertNotNull(taula1);
		assertNotNull(taula2);
		assertNotNull(taula3);
		
		assertEquals(taula1.tamaina(), 10);
		assertNotEquals(taula1.tamaina(), 9);
		assertEquals(taula2.tamaina(), 10);
		assertNotEquals(taula2.tamaina(), 9);
		assertEquals(taula3.tamaina(), 10);
		assertNotEquals(taula3.tamaina(), 9);
	}

	@Test
	public void testGetTaula() {
		taula1 = new Taula();
		taula2 = new Taula();
		taula3 = new Taula();
		
		assertNotNull(taula1);
		assertNotNull(taula2);
		assertNotNull(taula3);
		
		Laukia[][] laukia1 = taula1.getTaula();
		assertNotNull(laukia1);
		Laukia[][] laukia2 = taula2.getTaula();
		assertNotNull(laukia2);
		Laukia[][] laukia3 = taula3.getTaula();
		assertNotNull(laukia3);
	}

	@Test
	public void testInprimatu() {
		taula1 = new Taula();
		taula2 = new Taula();
		taula3 = new Taula();
		
		assertNotNull(taula1);
		assertNotNull(taula2);
		assertNotNull(taula3);
		
		taula1.inprimatu();
		taula2.inprimatu();
		taula3.inprimatu();
	}

	@Test
	public void testOntziaDa() {
		taula1 = new Taula();
		taula2 = new Taula();
		taula3 = new Taula();
		
		assertNotNull(taula1);
		assertNotNull(taula2);
		assertNotNull(taula3);
		
		Ontzia ontzia1 = new Ontzia("Itsaspeko");
		Ontzia ontzia2 = new Ontzia("Itsaspeko");
		Ontzia ontzia3 = new Ontzia("Itsaspeko");
		
		assertTrue(taula1.jarDaiteke(3, 3, 3, 'h'));
		taula1.ontziaKokatu(3, 3, 3, 'h', ontzia1);
		assertFalse(taula1.jarDaiteke(3, 3, 3, 'h'));
		assertTrue(taula1.ontziaDa(3, 3));
		assertFalse(taula1.ontziaDa(1, 1));
		
		assertTrue(taula2.jarDaiteke(2, 6, 6, 'h'));
		taula2.ontziaKokatu(2, 6, 6, 'h', ontzia2);
		assertFalse(taula2.jarDaiteke(2, 6, 6, 'h'));
		assertTrue(taula2.ontziaDa(6, 6));
		assertFalse(taula2.ontziaDa(3, 3));
		
		assertTrue(taula3.jarDaiteke(3, 5, 5, 'h'));
		taula3.ontziaKokatu(3, 5, 5, 'h', ontzia3);
		assertFalse(taula3.jarDaiteke(3, 5, 5, 'h'));
		assertTrue(taula3.ontziaDa(5, 5));
		assertFalse(taula3.ontziaDa(1, 1));
	}

	@Test
	public void testHondoratua() {
		taula1 = new Taula();
		taula2 = new Taula();
		taula3 = new Taula();
		
		assertNotNull(taula1);
		assertNotNull(taula2);
		assertNotNull(taula3);
		
		Ontzia ontzia1 = new Ontzia("Itsaspeko");
		Ontzia ontzia2 = new Ontzia("Itsaspeko");
		Ontzia ontzia3 = new Ontzia("Itsaspeko");
		
		assertTrue(taula1.jarDaiteke(3, 3, 3, 'h'));
		taula1.ontziaKokatu(3, 3, 3, 'h', ontzia1);
		assertFalse(taula1.jarDaiteke(3, 3, 3, 'h'));
		assertTrue(taula1.ontziaDa(3, 3));
		assertFalse(taula1.ontziaDa(1, 1));
		assertFalse(taula1.hondoratua(3, 3));
		
		assertTrue(taula2.jarDaiteke(2, 6, 6, 'h'));
		taula2.ontziaKokatu(2, 6, 6, 'h', ontzia2);
		assertFalse(taula2.jarDaiteke(2, 6, 6, 'h'));
		assertTrue(taula2.ontziaDa(6, 6));
		assertFalse(taula2.ontziaDa(3, 3));
		assertFalse(taula2.hondoratua(6, 6));
		
		assertTrue(taula3.jarDaiteke(3, 5, 5, 'h'));
		taula3.ontziaKokatu(3, 5, 5, 'h', ontzia3);
		assertFalse(taula3.jarDaiteke(3, 5, 5, 'h'));
		assertTrue(taula3.ontziaDa(5, 5));
		assertFalse(taula3.ontziaDa(1, 1));
		assertFalse(taula3.hondoratua(5, 5));
	}
}