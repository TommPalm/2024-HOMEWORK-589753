package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.Partita;
import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {

	private StanzaBloccata bloccata;
	private Attrezzo chiave;
	private Stanza adiacente;
	
	@Before
	public void setTest() {
		chiave = new Attrezzo("chiave",0);
		bloccata = new StanzaBloccata("bloccata", "nord", "chiave");
		adiacente = new Stanza("adiacente");
		bloccata.impostaStanzaAdiacente("nord", adiacente);
	}
	
	@Test
	public void testGetStanzaAdiacente_conChiave() {
		bloccata.addAttrezzo(chiave);
		assertEquals(adiacente,bloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacente_senzaChiave() {
		assertEquals(bloccata,bloccata.getStanzaAdiacente("nord"));
	}

}
