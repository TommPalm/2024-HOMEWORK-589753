package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;
import org.junit.Test;

public class ComandoVaiTest {

	private Partita play = new Partita();
	private Stanza room1 = new Stanza("1");
	private Stanza room2 = new Stanza("2");
	private Comando vai = new ComandoVai();
	
	@Before
	public void setTest() {
		room1.impostaStanzaAdiacente("nord", room2);
		room2.impostaStanzaAdiacente("sud", room1);
		play.labirinto.setStanzaCorrente(room1);
	}
	
	
	@Test
	public void testEsegui_direzioneInesistente() {
		vai.setParametro("sud");
		vai.esegui(play);
		assertNotEquals(room2,play.getStanzaCorrente());
	}
	
	@Test
	public void testEsegui_direzioneEsistente() {
		vai.setParametro("nord");
		vai.esegui(play);
		assertEquals(room2,play.getStanzaCorrente());
	}
	
	@Test
	public void testEsegui_senzaParametro() {
		vai.setParametro(null);
		vai.esegui(play);
		assertEquals(room1,play.getStanzaCorrente());
	}

}
