package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Pertsona;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class PertsonaTest {
	
	Pertsona pertsona1 = new Pertsona();
	Pertsona pertsona2 = new Pertsona();
	Pertsona pertsona3 = new Pertsona();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		pertsona1 = null;
		pertsona2 = null;
		pertsona3 = null;
	}

	@Test
	public void testSetIzena() {
		assertNotNull(pertsona1);
		assertNotNull(pertsona2);
		assertNotNull(pertsona3);
		
		pertsona1.setIzena("Pertsona bakoitzaren izena");
		pertsona2.setIzena("Nire izena");
		pertsona3.setIzena("Izen bat");
	}

	@Test
	public void testOntziaKokatuIntIntCharString() {
		assertNotNull(pertsona1);
		assertNotNull(pertsona2);
		assertNotNull(pertsona3);
		
		assertTrue(pertsona1.ontziaKokatu(3, 4, 'h', "Itsaspeko"));
		assertFalse(pertsona1.ontziaKokatu(3, 4, 'h', "Itsaspeko"));
		assertFalse(pertsona1.ontziaKokatu(50, 50, 'h', "Itsaspeko"));
		assertFalse(pertsona1.ontziaKokatu(50, 50, 'a', "Itsaspeko"));
		assertNotNull(pertsona1.getOntziak());
		
		assertTrue(pertsona2.ontziaKokatu(2, 3, 'h', "Suntsitzaile"));
		assertFalse(pertsona2.ontziaKokatu(2, 3, 'h', "Suntsitzaile"));
		assertFalse(pertsona2.ontziaKokatu(50, 50, 'h', "Suntsitzaile"));
		assertFalse(pertsona2.ontziaKokatu(50, 50, 'a', "Suntsitzaile"));
		assertNotNull(pertsona2.getOntziak());
		
		assertTrue(pertsona3.ontziaKokatu(5, 4, 'b', "Itsaspeko"));
		assertFalse(pertsona3.ontziaKokatu(5, 4, 'b', "Itsaspeko"));
		assertFalse(pertsona3.ontziaKokatu(50, 50, 'b', "Itsaspeko"));
		assertFalse(pertsona3.ontziaKokatu(50, 50, 'a', "Itsaspeko"));
		assertNotNull(pertsona3.getOntziak());
	}

	@Test
	public void testOntziakRandom() {
		assertNotNull(pertsona1);
		pertsona1.ontziakRandom();
		assertNotNull(pertsona1.getOntziak());
		
		assertNotNull(pertsona2);
		pertsona2.ontziakRandom();
		assertNotNull(pertsona2.getOntziak());
		
		assertNotNull(pertsona3);
		pertsona3.ontziakRandom();
		assertNotNull(pertsona3.getOntziak());
	}

	@Test
	public void testTiroEginIntIntStringString() {
		assertNotNull(pertsona1);
		assertEquals(pertsona1.armaKopurua("bonba"), 120);
		assertNotEquals(pertsona1.armaKopurua("bonba"), 119);
		pertsona1.tiroEgin(3, 4, "bonba", "horizontal");
		assertEquals(pertsona1.armaKopurua("bonba"), 119);
		assertNotEquals(pertsona1.armaKopurua("bonba"), 120);
		
		assertNotNull(pertsona2);
		assertEquals(pertsona2.armaKopurua("misil"), 3);
		assertNotEquals(pertsona2.armaKopurua("misil"), 2);
		pertsona2.tiroEgin(5, 3, "misil", "bertikal");
		assertEquals(pertsona2.armaKopurua("misil"), 2);
		assertNotEquals(pertsona2.armaKopurua("misil"), 3);
		
		assertNotNull(pertsona3);
		assertEquals(pertsona3.armaKopurua("misilZ"), 1);
		assertNotEquals(pertsona3.armaKopurua("misilZ"), 0);
		pertsona3.tiroEgin(4, 2, "misilZ", "boom");
		assertEquals(pertsona3.armaKopurua("misilZ"), 1);
		assertNotEquals(pertsona3.armaKopurua("misilZ"), 0);
	}
}