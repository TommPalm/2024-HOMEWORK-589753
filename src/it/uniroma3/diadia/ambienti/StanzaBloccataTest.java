package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.Partita;
import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {

	private Stanza room;
	private Stanza ad;
	private Attrezzo chiave;
	private Partita play = new Partita();
	private Comando vai;
	
	@Before
	public void setTest() {
		room = new StanzaBloccata("bloccata","nord","osso");
		ad = new Stanza("adiacente");
		chiave = new Attrezzo("osso",1);
		room.impostaStanzaAdiacente("nord",ad);
		play.labirinto.setStanzaCorrente(room);
		vai = new ComandoVai();
	}
	
	@Test
	public void testGetStanzaAdiacente_conChiave() {
		room.addAttrezzo(chiave);
		vai.setParametro("nord");
		vai.esegui(play);
		assertEquals(play.getStanzaCorrente(),ad);
	}
	
	@Test
	public void testGetStanzaAdiacente_senzaChiave() {
		vai.setParametro("nord");
		vai.esegui(play);
		assertNotEquals(play.getStanzaCorrente(),ad);
	}

}
