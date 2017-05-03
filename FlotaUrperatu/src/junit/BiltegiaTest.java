package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Biltegia;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class BiltegiaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance() {
		assertNotNull(Biltegia.getInstance());
	}

	@Test
	public void testBilatuArma() {
		assertNotNull(Biltegia.getInstance().bilatuArma("Bonba"));
		assertNotNull(Biltegia.getInstance().bilatuArma("Misil"));
		assertNotNull(Biltegia.getInstance().bilatuArma("MisilZuzendu"));
	}

	@Test
	public void testTamaina() {
		assertNotNull(Biltegia.getInstance().tamaina());
		assertEquals(Biltegia.getInstance().tamaina(), 3);
		assertNotEquals(Biltegia.getInstance().tamaina(), 234);
		assertNotEquals(Biltegia.getInstance().tamaina(), 59);
	}
}