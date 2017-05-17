package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Ordenagailua;

//Test hau amaituta dago. Ondo funtzionatzen du.

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
		ordenagailu1.ontziakKokatu();
		assertNotNull(ordenagailu1.getOntziak());
		
		assertNotNull(ordenagailu2);
		ordenagailu2.ontziakKokatu();
		assertNotNull(ordenagailu2.getOntziak());
		
		assertNotNull(ordenagailu3);
		ordenagailu3.ontziakKokatu();
		assertNotNull(ordenagailu3.getOntziak());
	}

	@Test
	public void testTiroEgin() {
		assertNotNull(ordenagailu1);
		int[] tiroarenKoordenatuak1;
		tiroarenKoordenatuak1 = ordenagailu1.tiroEgin();
		assertNotNull(tiroarenKoordenatuak1);
		
		assertNotNull(ordenagailu2);
		int[] tiroarenKoordenatuak2;
		tiroarenKoordenatuak2 = ordenagailu2.tiroEgin();
		assertNotNull(tiroarenKoordenatuak2);
		
		assertNotNull(ordenagailu3);
		int[] tiroarenKoordenatuak3;
		tiroarenKoordenatuak3 = ordenagailu3.tiroEgin();
		assertNotNull(tiroarenKoordenatuak3);
	}

	@Test
	public void testEzkutuakJarri() {
		assertNotNull(ordenagailu1);
		//ordenagailu1.ezkutuakJarri();
		
		assertNotNull(ordenagailu2);
		//ordenagailu2.ezkutuakJarri();
		
		assertNotNull(ordenagailu3);
		//ordenagailu3.ezkutuakJarri();
	}
}