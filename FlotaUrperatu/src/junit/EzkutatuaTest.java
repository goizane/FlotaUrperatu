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
		assertTrue(ezkutatua1.getKontadorea()==2);
		assertFalse(ezkutatua1.getKontadorea()==44);
		ezkutatua1.minEgin();
		assertTrue(ezkutatua1.getKontadorea()==1);
		assertFalse(ezkutatua1.getKontadorea()==2);
		ezkutatua1.minEgin();
		assertTrue(ezkutatua1.getKontadorea()==0);
		assertFalse(ezkutatua1.getKontadorea()==1);
		
		assertTrue(ezkutatua2.getKontadorea()==2);
		assertFalse(ezkutatua2.getKontadorea()==333);
		ezkutatua2.minEgin();
		assertTrue(ezkutatua2.getKontadorea()==1);
		assertFalse(ezkutatua2.getKontadorea()==2);
		ezkutatua2.minEgin();
		assertTrue(ezkutatua2.getKontadorea()==0);
		assertFalse(ezkutatua2.getKontadorea()==1);
		
		assertTrue(ezkutatua3.getKontadorea()==2);
		assertFalse(ezkutatua3.getKontadorea()==19);
		ezkutatua3.minEgin();
		assertTrue(ezkutatua3.getKontadorea()==1);
		assertFalse(ezkutatua3.getKontadorea()==2);
		ezkutatua3.minEgin();
		assertTrue(ezkutatua3.getKontadorea()==0);
		assertFalse(ezkutatua3.getKontadorea()==1);
	}

	@Test
	public void testEzkutatua() {
		assertNotNull(ezkutatua1);
		assertNotNull(ezkutatua2);
		assertNotNull(ezkutatua3);
		
		assertTrue(ezkutatua1.getKontadorea()==2);
		assertTrue(ezkutatua2.getKontadorea()==2);
		assertTrue(ezkutatua3.getKontadorea()==2);
	}

	@Test
	public void testGetKontadorea() {
		assertNotNull(ezkutatua1);
		assertNotNull(ezkutatua2);
		assertNotNull(ezkutatua3);
		
		assertNotNull(ezkutatua1.getKontadorea());
		assertNotNull(ezkutatua2.getKontadorea());
		assertNotNull(ezkutatua3.getKontadorea());
		
		assertTrue(ezkutatua1.getKontadorea()==2);
		assertTrue(ezkutatua2.getKontadorea()==2);
		assertTrue(ezkutatua3.getKontadorea()==2);
		
		assertTrue(ezkutatua1.getKontadorea()==2);
		assertFalse(ezkutatua1.getKontadorea()==44);
		ezkutatua1.minEgin();
		assertTrue(ezkutatua1.getKontadorea()==1);
		assertFalse(ezkutatua1.getKontadorea()==2);
		ezkutatua1.minEgin();
		assertTrue(ezkutatua1.getKontadorea()==0);
		assertFalse(ezkutatua1.getKontadorea()==1);
		
		assertTrue(ezkutatua2.getKontadorea()==2);
		assertFalse(ezkutatua2.getKontadorea()==333);
		ezkutatua2.minEgin();
		assertTrue(ezkutatua2.getKontadorea()==1);
		assertFalse(ezkutatua2.getKontadorea()==2);
		ezkutatua2.minEgin();
		assertTrue(ezkutatua2.getKontadorea()==0);
		assertFalse(ezkutatua2.getKontadorea()==1);
		
		assertTrue(ezkutatua3.getKontadorea()==2);
		assertFalse(ezkutatua3.getKontadorea()==19);
		ezkutatua3.minEgin();
		assertTrue(ezkutatua3.getKontadorea()==1);
		assertFalse(ezkutatua3.getKontadorea()==2);
		ezkutatua3.minEgin();
		assertTrue(ezkutatua3.getKontadorea()==0);
		assertFalse(ezkutatua3.getKontadorea()==1);
	}
}