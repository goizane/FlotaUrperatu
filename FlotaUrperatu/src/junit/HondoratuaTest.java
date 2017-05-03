package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Hondoratua;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class HondoratuaTest {
	
	Hondoratua hondoratua1 = new Hondoratua();
	Hondoratua hondoratua2 = new Hondoratua();
	Hondoratua hondoratua3 = new Hondoratua();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinEgin() {
		assertNotNull(hondoratua1);
		assertNotNull(hondoratua2);
		assertNotNull(hondoratua3);
		
		assertEquals(hondoratua1.minEgin(), 0);
		assertNotEquals(hondoratua1.minEgin(), 3);
		assertNotEquals(hondoratua1.minEgin(), 100);
		assertNotEquals(hondoratua1.minEgin(), 1);
		
		assertEquals(hondoratua2.minEgin(), 0);
		assertNotEquals(hondoratua2.minEgin(), 9);
		assertNotEquals(hondoratua2.minEgin(), 400);
		assertNotEquals(hondoratua2.minEgin(), 2);
		
		assertEquals(hondoratua3.minEgin(), 0);
		assertNotEquals(hondoratua3.minEgin(), 68);
		assertNotEquals(hondoratua3.minEgin(), 40);
		assertNotEquals(hondoratua3.minEgin(), 5);
	}

	@Test
	public void testHondoratua() {
		assertNotNull(hondoratua1);
		assertNotNull(hondoratua2);
		assertNotNull(hondoratua3);
	}
}