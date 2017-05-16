package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logika.Ordenagailua;

public class OrdenagailuaTest {
	
	Ordenagailua ordenagailu1 = new Ordenagailua();
	Ordenagailua ordenagailu2 = new Ordenagailua();
	Ordenagailua ordenagailu3 = new Ordenagailua();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		ordenagailu1 = null;
		ordenagailu2 = null;
		ordenagailu3 = null;
	}

	@Test
	public void testOntziakKokatu() {
		assertNotNull(ordenagailu1);
		assertNotNull(ordenagailu2);
		assertNotNull(ordenagailu3);
	}

	@Test
	public void testTiroEgin() {
		fail("Not yet implemented");
	}

	@Test
	public void testEzkutuakJarri() {
		fail("Not yet implemented");
	}
}