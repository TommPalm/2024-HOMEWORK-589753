package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.Before;
import org.junit.Test;

public class StanzaBuiaTest {

	private StanzaBuia room;
	private Attrezzo lanterna;
	
	@Before
	public void setTest() {
		room = new StanzaBuia("dark","lanterna");
		lanterna = new Attrezzo("lanterna",0);
	}
	
	@Test
	public void testGetDescrizione_nienteLuce() {
		assertEquals(room.getDescrizione(),"qui c'è buio pesto");
	}
	
	@Test
	public void testGetDescrizione_illuminata() {
		room.addAttrezzo(lanterna);
		assertNotEquals(room.getDescrizione(),"qui c'è buio pesto");
	}

}
