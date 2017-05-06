package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Normala;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class NormalaTest {
	
	Normala normala1 = new Normala();
	Normala normala2 = new Normala();
	Normala normala3 = new Normala();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinEgin() {
		assertNotNull(normala1);
		assertNotNull(normala2);
		assertNotNull(normala3);
		
		assertEquals(normala1.minEgin(), 0);
		assertNotEquals(normala1.minEgin(), 1);
		
		assertEquals(normala2.minEgin(), 0);
		assertNotEquals(normala2.minEgin(), 1);
		
		assertEquals(normala3.minEgin(), 0);
		assertNotEquals(normala3.minEgin(), 1);
	}

	@Test
	public void testNormala() {
		assertNotNull(normala1);
		assertNotNull(normala2);
		assertNotNull(normala3);
	}
}