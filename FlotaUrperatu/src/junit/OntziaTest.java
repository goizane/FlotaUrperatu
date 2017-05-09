package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Egoera;
import logika.Ezkutatua;
import logika.Ontzia;
import logika.Ukitua;

public class OntziaTest {
	
	Ontzia ontzia1;
	Ontzia ontzia2;
	Ontzia ontzia3;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		ontzia1 = null;
		ontzia2 = null;
		ontzia3 = null;
	}

	@Test
	public void testOntzia() {
		ontzia1 = new Ontzia("Hegazkin-ontzi");
		ontzia2 = new Ontzia("Itsaspeko");
		ontzia3 = new Ontzia("Suntsitzaile");
		
		assertNotNull(ontzia1);
		assertNotNull(ontzia2);
		assertNotNull(ontzia3);
	}

	@Test
	public void testInprimatu() {
		ontzia1 = new Ontzia("Hegazkin-ontzi");
		ontzia2 = new Ontzia("Itsaspeko");
		ontzia3 = new Ontzia("Suntsitzaile");
		
		assertNotNull(ontzia1);
		assertNotNull(ontzia2);
		assertNotNull(ontzia3);
		
		ontzia1.inprimatu();
		ontzia2.inprimatu();
		ontzia3.inprimatu();
	}

	@Test
	public void testGetLuzeera() {
		ontzia1 = new Ontzia("Hegazkin-ontzi");
		ontzia2 = new Ontzia("Itsaspeko");
		ontzia3 = new Ontzia("Suntsitzaile");
		
		assertNotNull(ontzia1);
		assertNotNull(ontzia2);
		assertNotNull(ontzia3);
		
		assertEquals(ontzia1.getLuzeera(), 4);
		assertNotEquals(ontzia1.getLuzeera(), 3);
		assertEquals(ontzia2.getLuzeera(), 3);
		assertNotEquals(ontzia2.getLuzeera(), 2);
		assertEquals(ontzia3.getLuzeera(), 2);
		assertNotEquals(ontzia3.getLuzeera(), 4);
	}

	@Test
	public void testGetIzena() {
		ontzia1 = new Ontzia("Hegazkin-ontzi");
		ontzia2 = new Ontzia("Itsaspeko");
		ontzia3 = new Ontzia("Suntsitzaile");
		
		assertNotNull(ontzia1);
		assertNotNull(ontzia2);
		assertNotNull(ontzia3);
		
		assertEquals(ontzia1.getIzena(), "Hegazkin-ontzi");
		assertNotEquals(ontzia1.getIzena(), "Itsaspeko");
		assertEquals(ontzia2.getIzena(), "Itsaspeko");
		assertNotEquals(ontzia2.getIzena(), "Suntsitzaile");
		assertEquals(ontzia3.getIzena(), "Suntsitzaile");
		assertNotEquals(ontzia3.getIzena(), "Hegazkin-ontzi");
	}

	@Test
	public void testKokatu() {
		ontzia1 = new Ontzia("Hegazkin-ontzi");
		ontzia2 = new Ontzia("Itsaspeko");
		ontzia3 = new Ontzia("Suntsitzaile");
		
		assertNotNull(ontzia1);
		assertNotNull(ontzia2);
		assertNotNull(ontzia3);
		
		assertFalse(ontzia1.kokatuaDago());
		ontzia1.kokatu();
		assertTrue(ontzia1.kokatuaDago());
		
		assertFalse(ontzia2.kokatuaDago());
		ontzia2.kokatu();
		assertTrue(ontzia2.kokatuaDago());
		
		assertFalse(ontzia3.kokatuaDago());
		ontzia3.kokatu();
		assertTrue(ontzia3.kokatuaDago());
	}

	@Test
	public void testKokatuaDago() {
		ontzia1 = new Ontzia("Hegazkin-ontzi");
		ontzia2 = new Ontzia("Itsaspeko");
		ontzia3 = new Ontzia("Suntsitzaile");
		
		assertNotNull(ontzia1);
		assertNotNull(ontzia2);
		assertNotNull(ontzia3);
		
		assertFalse(ontzia1.kokatuaDago());
		ontzia1.kokatu();
		assertTrue(ontzia1.kokatuaDago());
		
		assertFalse(ontzia2.kokatuaDago());
		ontzia2.kokatu();
		assertTrue(ontzia2.kokatuaDago());
		
		assertFalse(ontzia3.kokatuaDago());
		ontzia3.kokatu();
		assertTrue(ontzia3.kokatuaDago());
	}

	@Test
	public void testEgoeraAldatu() {
		ontzia1 = new Ontzia("Hegazkin-ontzi");
		ontzia2 = new Ontzia("Itsaspeko");
		ontzia3 = new Ontzia("Suntsitzaile");
		
		assertNotNull(ontzia1);
		assertNotNull(ontzia2);
		assertNotNull(ontzia3);
		
		String hasierakoEgoera1 = ontzia1.getEgora();
		Egoera egoera1 = new Ezkutatua();
		ontzia1.egoeraAldatu(egoera1);
		String aldatutakoEgoera1 = ontzia1.getEgora();
		assertNotEquals(hasierakoEgoera1, aldatutakoEgoera1);
		
		String hasierakoEgoera2 = ontzia2.getEgora();
		Egoera egoera2 = new Ezkutatua();
		ontzia2.egoeraAldatu(egoera2);
		String aldatutakoEgoera2 = ontzia2.getEgora();
		assertNotEquals(hasierakoEgoera2, aldatutakoEgoera2);
		
		String hasierakoEgoera3 = ontzia3.getEgora();
		Egoera egoera3 = new Ezkutatua();
		ontzia3.egoeraAldatu(egoera3);
		String aldatutakoEgoera3 = ontzia3.getEgora();
		assertNotEquals(hasierakoEgoera3, aldatutakoEgoera3);
	}

	@Test
	public void testGetEgora() {
		ontzia1 = new Ontzia("Hegazkin-ontzi");
		ontzia2 = new Ontzia("Itsaspeko");
		ontzia3 = new Ontzia("Suntsitzaile");
		
		assertNotNull(ontzia1);
		assertNotNull(ontzia2);
		assertNotNull(ontzia3);
		
		assertNotNull(ontzia1.getEgora());
		assertNotNull(ontzia2.getEgora());
		assertNotNull(ontzia3.getEgora());
		
		String hasierakoEgoera1 = ontzia1.getEgora();
		Egoera egoera1 = new Ezkutatua();
		ontzia1.egoeraAldatu(egoera1);
		String aldatutakoEgoera1 = ontzia1.getEgora();
		assertNotEquals(hasierakoEgoera1, aldatutakoEgoera1);
		
		String hasierakoEgoera2 = ontzia2.getEgora();
		Egoera egoera2 = new Ezkutatua();
		ontzia2.egoeraAldatu(egoera2);
		String aldatutakoEgoera2 = ontzia2.getEgora();
		assertNotEquals(hasierakoEgoera2, aldatutakoEgoera2);
		
		String hasierakoEgoera3 = ontzia3.getEgora();
		Egoera egoera3 = new Ezkutatua();
		ontzia3.egoeraAldatu(egoera3);
		String aldatutakoEgoera3 = ontzia3.getEgora();
		assertNotEquals(hasierakoEgoera3, aldatutakoEgoera3);
	}

	@Test
	public void testGetEzkutuKontadore() {
		ontzia1 = new Ontzia("Hegazkin-ontzi");
		ontzia2 = new Ontzia("Itsaspeko");
		ontzia3 = new Ontzia("Suntsitzaile");
		
		assertNotNull(ontzia1);
		assertNotNull(ontzia2);
		assertNotNull(ontzia3);
		
		assertNotNull(ontzia1.getEgora());
		assertNotNull(ontzia2.getEgora());
		assertNotNull(ontzia3.getEgora());
		
		String hasierakoEgoera1 = ontzia1.getEgora();
		Egoera egoera1 = new Ezkutatua();
		ontzia1.egoeraAldatu(egoera1);
		String aldatutakoEgoera1 = ontzia1.getEgora();
		assertNotEquals(hasierakoEgoera1, aldatutakoEgoera1);
		
		String hasierakoEgoera2 = ontzia2.getEgora();
		Egoera egoera2 = new Ezkutatua();
		ontzia2.egoeraAldatu(egoera2);
		String aldatutakoEgoera2 = ontzia2.getEgora();
		assertNotEquals(hasierakoEgoera2, aldatutakoEgoera2);
		
		String hasierakoEgoera3 = ontzia3.getEgora();
		Egoera egoera3 = new Ezkutatua();
		ontzia3.egoeraAldatu(egoera3);
		String aldatutakoEgoera3 = ontzia3.getEgora();
		assertNotEquals(hasierakoEgoera3, aldatutakoEgoera3);
	}

	@Test
	public void testGetUkitua() {
		ontzia1 = new Ontzia("Hegazkin-ontzi");
		ontzia2 = new Ontzia("Itsaspeko");
		ontzia3 = new Ontzia("Suntsitzaile");
		
		assertNotNull(ontzia1);
		assertNotNull(ontzia2);
		assertNotNull(ontzia3);
		
		assertNotNull(ontzia1.getEgora());
		assertNotNull(ontzia2.getEgora());
		assertNotNull(ontzia3.getEgora());
		
		assertFalse(ontzia1.getUkitua());
		Egoera egoera1 = new Ukitua(3);
		ontzia1.egoeraAldatu(egoera1);
		assertTrue(ontzia1.getUkitua());
		
		assertFalse(ontzia2.getUkitua());
		Egoera egoera2 = new Ukitua(3);
		ontzia2.egoeraAldatu(egoera2);
		assertTrue(ontzia2.getUkitua());
		
		assertFalse(ontzia3.getUkitua());
		Egoera egoera3 = new Ukitua(3);
		ontzia3.egoeraAldatu(egoera3);
		assertTrue(ontzia3.getUkitua());
	}

	@Test
	public void testMinEgin() {
		ontzia1 = new Ontzia("Hegazkin-ontzi");
		ontzia2 = new Ontzia("Itsaspeko");
		ontzia3 = new Ontzia("Suntsitzaile");
		
		assertNotNull(ontzia1);
		assertNotNull(ontzia2);
		assertNotNull(ontzia3);
		
		assertNotNull(ontzia1.getEgora());
		assertNotNull(ontzia2.getEgora());
		assertNotNull(ontzia3.getEgora());
		
		assertFalse(ontzia1.getUkitua());
		ontzia1.minEgin();
		assertTrue(ontzia1.getUkitua());
		ontzia2.minEgin();
		ontzia3.minEgin();
	}

	@Test
	public void testHondoratu() {
		fail("Not yet implemented");
	}

	@Test
	public void testHondoratua() {
		fail("Not yet implemented");
	}
}