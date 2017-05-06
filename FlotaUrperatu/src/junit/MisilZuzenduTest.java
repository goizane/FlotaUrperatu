package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.MisilZuzendu;
import logika.Taula;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class MisilZuzenduTest {

	MisilZuzendu misilZuzendu1 = new MisilZuzendu(5);
	MisilZuzendu misilZuzendu2 = new MisilZuzendu(10);
	MisilZuzendu misilZuzendu3 = new MisilZuzendu(15);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMisilZuzendu() {
		assertNotNull(misilZuzendu1);

		assertNotNull(misilZuzendu2);

		assertNotNull(misilZuzendu3);

		assertEquals(misilZuzendu1.getIzena(), "misilZuzendua");
		assertEquals(misilZuzendu1.getKantitatea(), 5);
		assertEquals(misilZuzendu1.getPrezioa(), 30);

		assertEquals(misilZuzendu2.getIzena(), "misilZuzendua");
		assertNotEquals(misilZuzendu2.getIzena(), "Okerra den izena!");
		assertEquals(misilZuzendu2.getKantitatea(), 10);
		assertNotEquals(misilZuzendu2.getKantitatea(), 330);
		assertEquals(misilZuzendu2.getPrezioa(), 30);
		assertNotEquals(misilZuzendu2.getPrezioa(), 100000);

		assertEquals(misilZuzendu3.getIzena(), "misilZuzendua");
		assertNotEquals(misilZuzendu3.getIzena(), "Okerra den izena!");
		assertEquals(misilZuzendu3.getKantitatea(), 15);
		assertNotEquals(misilZuzendu3.getKantitatea(), 789);
		assertEquals(misilZuzendu3.getPrezioa(), 30);
		assertNotEquals(misilZuzendu3.getPrezioa(), 4567);
	}

	@Test
	public void testMinEginHorizontal() {
		assertNotNull(misilZuzendu1);

		assertNotNull(misilZuzendu2);

		assertNotNull(misilZuzendu3);
		
		Taula taula1 = new Taula();
		misilZuzendu1.minEginHorizontal(taula1, 5);

		Taula taula2 = new Taula();
		misilZuzendu2.minEginHorizontal(taula2, 4);

		Taula taula3 = new Taula();
		misilZuzendu3.minEginHorizontal(taula3, 7);
	}

	@Test
	public void testMinEginBertikal() {
		assertNotNull(misilZuzendu1);

		assertNotNull(misilZuzendu2);

		assertNotNull(misilZuzendu3);
		
		Taula taula1 = new Taula();
		misilZuzendu1.minEginBertikal(taula1, 8);

		Taula taula2 = new Taula();
		misilZuzendu2.minEginBertikal(taula2, 3);

		Taula taula3 = new Taula();
		misilZuzendu3.minEginBertikal(taula3, 2);
	}

	@Test
	public void testBereziaErabili() {
		assertNotNull(misilZuzendu1);

		assertNotNull(misilZuzendu2);

		assertNotNull(misilZuzendu3);
		
		assertTrue(misilZuzendu1.bereziaErabili("horizontal"));
		assertFalse(misilZuzendu1.bereziaErabili("horizontal"));
		assertTrue(misilZuzendu1.bereziaErabili("bertikal"));
		assertFalse(misilZuzendu1.bereziaErabili("bertikal"));
		assertTrue(misilZuzendu1.bereziaErabili("boom"));
		assertFalse(misilZuzendu1.bereziaErabili("boom"));
		
		assertTrue(misilZuzendu2.bereziaErabili("horizontal"));
		assertFalse(misilZuzendu2.bereziaErabili("horizontal"));
		assertTrue(misilZuzendu2.bereziaErabili("bertikal"));
		assertFalse(misilZuzendu2.bereziaErabili("bertikal"));
		assertTrue(misilZuzendu2.bereziaErabili("boom"));
		assertFalse(misilZuzendu2.bereziaErabili("boom"));
		
		assertTrue(misilZuzendu3.bereziaErabili("horizontal"));
		assertFalse(misilZuzendu3.bereziaErabili("horizontal"));
		assertTrue(misilZuzendu3.bereziaErabili("bertikal"));
		assertFalse(misilZuzendu3.bereziaErabili("bertikal"));
		assertTrue(misilZuzendu3.bereziaErabili("boom"));
		assertFalse(misilZuzendu3.bereziaErabili("boom"));
	}

	@Test
	public void testBereziKop() {
		assertNotNull(misilZuzendu1);

		assertNotNull(misilZuzendu2);

		assertNotNull(misilZuzendu3);
		
		assertEquals(misilZuzendu1.bereziKop("horizontal"), 1);
		assertTrue(misilZuzendu1.bereziaErabili("horizontal"));
		assertNotEquals(misilZuzendu1.bereziKop("horizontal"), 1);
		assertEquals(misilZuzendu1.bereziKop("horizontal"), 0);
		assertFalse(misilZuzendu1.bereziaErabili("horizontal"));
		assertEquals(misilZuzendu1.bereziKop("bertikal"), 1);
		assertTrue(misilZuzendu1.bereziaErabili("bertikal"));
		assertNotEquals(misilZuzendu1.bereziKop("bertikal"), 1);
		assertEquals(misilZuzendu1.bereziKop("bertikal"), 0);
		assertFalse(misilZuzendu1.bereziaErabili("bertikal"));
		assertEquals(misilZuzendu1.bereziKop("boom"), 1);
		assertTrue(misilZuzendu1.bereziaErabili("boom"));
		assertNotEquals(misilZuzendu1.bereziKop("boom"), 1);
		assertEquals(misilZuzendu1.bereziKop("boom"), 0);
		assertFalse(misilZuzendu1.bereziaErabili("boom"));
		
		assertEquals(misilZuzendu2.bereziKop("horizontal"), 1);
		assertTrue(misilZuzendu2.bereziaErabili("horizontal"));
		assertNotEquals(misilZuzendu2.bereziKop("horizontal"), 1);
		assertEquals(misilZuzendu2.bereziKop("horizontal"), 0);
		assertFalse(misilZuzendu2.bereziaErabili("horizontal"));
		assertEquals(misilZuzendu2.bereziKop("bertikal"), 1);
		assertTrue(misilZuzendu2.bereziaErabili("bertikal"));
		assertNotEquals(misilZuzendu2.bereziKop("bertikal"), 1);
		assertEquals(misilZuzendu2.bereziKop("bertikal"), 0);
		assertFalse(misilZuzendu2.bereziaErabili("bertikal"));
		assertEquals(misilZuzendu2.bereziKop("boom"), 1);
		assertTrue(misilZuzendu2.bereziaErabili("boom"));
		assertNotEquals(misilZuzendu2.bereziKop("boom"), 1);
		assertEquals(misilZuzendu2.bereziKop("boom"), 0);
		assertFalse(misilZuzendu2.bereziaErabili("boom"));
		
		assertEquals(misilZuzendu3.bereziKop("horizontal"), 1);
		assertTrue(misilZuzendu3.bereziaErabili("horizontal"));
		assertNotEquals(misilZuzendu3.bereziKop("horizontal"), 1);
		assertEquals(misilZuzendu3.bereziKop("horizontal"), 0);
		assertFalse(misilZuzendu3.bereziaErabili("horizontal"));
		assertEquals(misilZuzendu3.bereziKop("bertikal"), 1);
		assertTrue(misilZuzendu3.bereziaErabili("bertikal"));
		assertNotEquals(misilZuzendu3.bereziKop("bertikal"), 1);
		assertEquals(misilZuzendu3.bereziKop("bertikal"), 0);
		assertFalse(misilZuzendu3.bereziaErabili("bertikal"));
		assertEquals(misilZuzendu3.bereziKop("boom"), 1);
		assertTrue(misilZuzendu3.bereziaErabili("boom"));
		assertNotEquals(misilZuzendu3.bereziKop("boom"), 1);
		assertEquals(misilZuzendu3.bereziKop("boom"), 0);
		assertFalse(misilZuzendu3.bereziaErabili("boom"));
	}
}