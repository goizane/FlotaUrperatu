package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Laukia;
import logika.Ontzia;

// AMAITUTA!!!

public class LaukiaTest {
	
	Laukia lauki1;
	Laukia lauki2;
	Laukia lauki3;
	Ontzia ontzi1;

	@Before
	public void setUp() throws Exception {
		lauki1 = new Laukia();
		lauki2 = new Laukia();
		ontzi1 = new Ontzia("Itsaspeko");
	}

	@After
	public void tearDown() throws Exception {
		lauki1 = null;
		lauki2 = null;
	}

	@Test
	public void testLaukia() {
		assertNotNull(lauki1);
		assertNotNull(lauki2);
		assertNull(lauki3);
	}

	@Test
	public void testUraDa() {
		lauki1.uraDa();
		assertTrue(lauki1.hutsik());
	}

	@Test
	public void testInprimatu() {
		lauki1.uraDa();
		assertTrue(lauki1.hutsik());
		lauki1.inprimatu();
		lauki2.ontziaSartu(ontzi1);
		assertFalse(lauki2.hutsik());
		lauki2.inprimatu();
	}

	@Test
	public void testOntziaSartu() {
		//lauki3.ontziaSartu(ontzi1);
		//assertFalse(lauki3.hutsik());
		//assertNotNull(lauki3.ontzia());
		assertTrue(lauki1.hutsik());
		assertNull(lauki1.ontzia());
	}

	@Test
	public void testHutsik() {
		lauki1.uraDa();
		assertTrue(lauki1.hutsik());
	}

	@Test
	public void testOntzia() {
		lauki1.uraDa();
		assertNull(lauki1.ontzia());
	}

	@Test
	public void testGetEgoera() {
		lauki1.uraDa();
		Laukia lauki4 = new Laukia();
		lauki4.uraDa();
		assertEquals(lauki1.getEgoera(), lauki4.getEgoera());
	}

	@Test
	public void testUkitutaDago() {
		lauki1.uraDa();
		assertFalse(lauki1.ukitutaDago());
		Laukia lauki5 = new Laukia();
		Ontzia ontzi5 = new Ontzia("Itsaspeko");
		lauki5.ontziaSartu(ontzi5);
		lauki5.ukitu();
		assertTrue(lauki5.ukitutaDago());
	}

	@Test
	public void testUkitu() {
		Laukia lauki6 = new Laukia();
		Ontzia ontzi6 = new Ontzia("Itsaspeko");
		lauki6.ontziaSartu(ontzi6);
		lauki6.ukitu();
		assertTrue(lauki6.ukitutaDago());
	}
}