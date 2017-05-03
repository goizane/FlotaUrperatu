package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Arma;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class ArmaTest {
	
	Arma arma1 = new Arma();
	Arma arma2 = new Arma();
	Arma arma3 = new Arma();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		arma1 = null;
		arma2 = null;
		arma3 = null;
	}

	@Test
	public void testGetKantitatea() {
		assertNotNull(arma1.getKantitatea());
		assertNotNull(arma2.getKantitatea());
		assertNotNull(arma3.getKantitatea());
	}

	@Test
	public void testGetPrezioa() {
		assertNotNull(arma1.getPrezioa());
		assertNotNull(arma2.getPrezioa());
		assertNotNull(arma3.getPrezioa());
	}

	@Test
	public void testGetIzena() {
		assertNull(arma1.getIzena());
		assertNull(arma2.getIzena());
		assertNull(arma3.getIzena());
	}
}