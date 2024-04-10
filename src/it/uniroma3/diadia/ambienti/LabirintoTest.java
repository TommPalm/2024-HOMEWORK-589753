package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoTest {

	private Labirinto lab = new Labirinto();
	
	
	@Test
	public void testGetCorrente_StanzaNonPresente() {
		lab.costruisci();
		Stanza stanza = new Stanza("non presente");
		assertNotEquals(lab.getCorrente(),stanza);
	}
	
	@Test
	public void testGetCorrente_StanzaPresenteCorrente() {
		lab.costruisci();
		Stanza stanza = new Stanza("corrente");
		lab.setStanzaCorrente(stanza);
		assertEquals(lab.getCorrente(),stanza);
	}
	
	@Test
	public void testGetCorrente_StanzaPresenteNonCorrente() {
		lab.costruisci();
		Stanza stanza = new Stanza("non corrente");
		assertNotEquals(lab.getCorrente(),stanza);
	}
}
