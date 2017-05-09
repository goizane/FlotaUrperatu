package junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logika.Radar;

//Test hau amaituta dago. Ondo funtzionatzen du.

public class RadarTest {
	
	Radar radar1;
	Radar radar2;
	Radar radar3;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		radar1 = null;
		radar2 = null;
		radar3 = null;
	}

	@Test
	public void testRadar() {
		radar1 = new Radar(5);
		radar2 = new Radar(10);
		radar3 = new Radar(15);
		
		assertNotNull(radar1);
		assertNotNull(radar2);
		assertNotNull(radar3);
		
		assertEquals(radar1.getKant(), 5);
		assertEquals(radar2.getKant(), 10);
		assertEquals(radar3.getKant(), 15);
	}

	@Test
	public void testGetKant() {
		radar1 = new Radar(5);
		radar2 = new Radar(10);
		radar3 = new Radar(15);
		
		assertNotNull(radar1);
		assertNotNull(radar2);
		assertNotNull(radar3);
		
		assertEquals(radar1.getKant(), 5);
		assertNotEquals(radar1.getKant(), 6);
		assertNotEquals(radar1.getKant(), 100);
		
		assertEquals(radar2.getKant(), 10);
		assertNotEquals(radar2.getKant(), 33);
		assertNotEquals(radar2.getKant(), 100);
		
		assertEquals(radar3.getKant(), 15);
		assertNotEquals(radar3.getKant(), 25);
		assertNotEquals(radar3.getKant(), 100);
	}

	@Test
	public void testPosizioa() {
		radar1 = new Radar(5);
		radar2 = new Radar(10);
		radar3 = new Radar(15);
		
		assertNotNull(radar1);
		assertNotNull(radar2);
		assertNotNull(radar3);
		
		assertNotNull(radar1.posizioa());
		assertNotNull(radar2.posizioa());
		assertNotNull(radar3.posizioa());
	}

	@Test
	public void testPosAldatu() {
		radar1 = new Radar(5);
		radar2 = new Radar(10);
		radar3 = new Radar(15);
		
		assertNotNull(radar1);
		assertNotNull(radar2);
		assertNotNull(radar3);
		
		assertNotNull(radar1.posizioa());
		radar1.posAldatu(3, 3);
		assertNotNull(radar1.posizioa());
		
		assertNotNull(radar2.posizioa());
		radar2.posAldatu(3, 4);
		assertNotNull(radar2.posizioa());
		
		assertNotNull(radar3.posizioa());
		radar3.posAldatu(5, 6);
		assertNotNull(radar3.posizioa());
	}

	@Test
	public void testErabili() {
		radar1 = new Radar(5);
		radar2 = new Radar(10);
		radar3 = new Radar(15);
		
		assertNotNull(radar1);
		assertNotNull(radar2);
		assertNotNull(radar3);
		
		assertEquals(radar1.getKant(), 5);
		assertNotEquals(radar1.getKant(), 4);
		radar1.erabili();
		assertNotEquals(radar1.getKant(), 5);
		assertEquals(radar1.getKant(), 4);
		
		assertEquals(radar2.getKant(), 10);
		assertNotEquals(radar2.getKant(), 9);
		radar2.erabili();
		assertNotEquals(radar2.getKant(), 10);
		assertEquals(radar2.getKant(), 9);
		
		assertEquals(radar3.getKant(), 15);
		assertNotEquals(radar3.getKant(), 14);
		radar3.erabili();
		assertNotEquals(radar3.getKant(), 15);
		assertEquals(radar3.getKant(), 14);
	}
}