package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Ezkutatua;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class EzkutatuaTest {
	
	Ezkutatua ezkutatua1 = new Ezkutatua();
	Ezkutatua ezkutatua2 = new Ezkutatua();
	Ezkutatua ezkutatua3 = new Ezkutatua();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinEgin() {
		assertEquals(ezkutatua1.getKontadorea(), 2);
		assertNotEquals(ezkutatua1.getKontadorea(), 44);
		ezkutatua1.minEgin();
		assertEquals(ezkutatua1.getKontadorea(), 1);
		assertNotEquals(ezkutatua1.getKontadorea(), 2);
		ezkutatua1.minEgin();
		assertEquals(ezkutatua1.getKontadorea(), 0);
		assertNotEquals(ezkutatua1.getKontadorea(), 1);
		
		assertEquals(ezkutatua2.getKontadorea(), 2);
		assertNotEquals(ezkutatua2.getKontadorea(), 333);
		ezkutatua2.minEgin();
		assertEquals(ezkutatua2.getKontadorea(), 1);
		assertNotEquals(ezkutatua2.getKontadorea(), 2);
		ezkutatua2.minEgin();
		assertEquals(ezkutatua2.getKontadorea(), 0);
		assertNotEquals(ezkutatua2.getKontadorea(), 1);
		
		assertEquals(ezkutatua3.getKontadorea(), 2);
		assertNotEquals(ezkutatua3.getKontadorea(), 19);
		ezkutatua3.minEgin();
		assertEquals(ezkutatua3.getKontadorea(), 1);
		assertNotEquals(ezkutatua3.getKontadorea(), 2);
		ezkutatua3.minEgin();
		assertEquals(ezkutatua3.getKontadorea(), 0);
		assertNotEquals(ezkutatua3.getKontadorea(), 1);
	}

	@Test
	public void testEzkutatua() {
		assertNotNull(ezkutatua1);
		assertNotNull(ezkutatua2);
		assertNotNull(ezkutatua3);
		
		assertEquals(ezkutatua1.getKontadorea(), 2);
		assertEquals(ezkutatua2.getKontadorea(), 2);
		assertEquals(ezkutatua3.getKontadorea(), 2);
	}

	@Test
	public void testGetKontadorea() {
		assertNotNull(ezkutatua1);
		assertNotNull(ezkutatua2);
		assertNotNull(ezkutatua3);
		
		assertNotNull(ezkutatua1.getKontadorea());
		assertNotNull(ezkutatua2.getKontadorea());
		assertNotNull(ezkutatua3.getKontadorea());
		
		assertEquals(ezkutatua1.getKontadorea(), 2);
		assertEquals(ezkutatua2.getKontadorea(), 2);
		assertEquals(ezkutatua3.getKontadorea(), 2);
		
		assertEquals(ezkutatua1.getKontadorea(), 2);
		assertNotEquals(ezkutatua1.getKontadorea(), 44);
		ezkutatua1.minEgin();
		assertEquals(ezkutatua1.getKontadorea(), 1);
		assertNotEquals(ezkutatua1.getKontadorea(), 2);
		ezkutatua1.minEgin();
		assertEquals(ezkutatua1.getKontadorea(), 0);
		assertNotEquals(ezkutatua1.getKontadorea(), 1);
		
		assertEquals(ezkutatua2.getKontadorea(), 2);
		assertNotEquals(ezkutatua2.getKontadorea(), 333);
		ezkutatua2.minEgin();
		assertEquals(ezkutatua2.getKontadorea(), 1);
		assertNotEquals(ezkutatua2.getKontadorea(), 2);
		ezkutatua2.minEgin();
		assertEquals(ezkutatua2.getKontadorea(), 0);
		assertNotEquals(ezkutatua2.getKontadorea(), 1);
		
		assertEquals(ezkutatua3.getKontadorea(), 2);
		assertNotEquals(ezkutatua3.getKontadorea(), 19);
		ezkutatua3.minEgin();
		assertEquals(ezkutatua3.getKontadorea(), 1);
		assertNotEquals(ezkutatua3.getKontadorea(), 2);
		ezkutatua3.minEgin();
		assertEquals(ezkutatua3.getKontadorea(), 0);
		assertNotEquals(ezkutatua3.getKontadorea(), 1);
	}
}