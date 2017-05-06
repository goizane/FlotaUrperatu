package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Ukitua;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class UkituaTest {
	
	Ukitua ukitua1;
	Ukitua ukitua2;
	Ukitua ukitua3;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinEgin() {
		ukitua1 = new Ukitua(2);
		ukitua2 = new Ukitua(3);
		ukitua3 = new Ukitua(4);
		
		assertEquals(ukitua1.minEgin(), 1);
		assertEquals(ukitua1.minEgin(), 2);
		assertEquals(ukitua1.minEgin(), 3);
		assertEquals(ukitua1.minEgin(), 4);
		
		assertEquals(ukitua2.minEgin(), 1);
		assertEquals(ukitua2.minEgin(), 2);
		assertEquals(ukitua2.minEgin(), 3);
		assertEquals(ukitua2.minEgin(), 4);
		
		assertEquals(ukitua3.minEgin(), 1);
		assertEquals(ukitua3.minEgin(), 2);
		assertEquals(ukitua3.minEgin(), 3);
		assertEquals(ukitua3.minEgin(), 4);
	}

	@Test
	public void testUkitua() {
		ukitua1 = new Ukitua(2);
		ukitua2 = new Ukitua(3);
		ukitua3 = new Ukitua(4);
		
		assertNotNull(ukitua1);
		assertNotNull(ukitua2);
		assertNotNull(ukitua3);
	}
}