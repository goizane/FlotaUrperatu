package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logika.Laukia;
import logika.Ontzia;

public class LaukiaTest {
	
	Laukia lauki1;
	Laukia lauki2;
	Laukia lauki3;  // Frogak egiteko "null" utzi
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
		lauki3.ontziaSartu(ontzi1);
		assertFalse(lauki3.hutsik());
		assertNotNull(lauki3.ontzia());
		assertTrue(lauki1.hutsik());
		assertNull(lauki1.ontzia());
	}

	@Test
	public void testHutsik() {
		fail("Not yet implemented");
	}

	@Test
	public void testOntzia() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEgoera() {
		fail("Not yet implemented");
	}

	@Test
	public void testUkitutaDago() {
		fail("Not yet implemented");
	}

	@Test
	public void testUkitu() {
		fail("Not yet implemented");
	}
}