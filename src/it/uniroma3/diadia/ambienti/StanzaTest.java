package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	Stanza room;

	@Test
	public void testGetAttrezzo_stanzaVuota() {
		room = new Stanza("vuota");
		assertNull(room.getAttrezzo("inesistente"));
	}
	
	@Test
	public void testGetAttrezzo_stanzaPiena_attrezzoPresente() {
		room = new Stanza("piena");
		Attrezzo presente = new Attrezzo("presente",0);
		room.addAttrezzo(presente);
		assertNotNull(room.getAttrezzo("presente"));
	}
	
	@Test
	public void testGetAttrezzo_stanzaPiena_attrezzoAssente() {
		room = new Stanza("piena");
		Attrezzo presente = new Attrezzo("presente",0);
		Attrezzo assente = new Attrezzo("assente",0);
		room.addAttrezzo(presente);
		assertNull(room.getAttrezzo(assente.getNome()));
	}

}
