package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;
import org.junit.Test;

public class ComandoVaiTest {

	private Partita play;
	private Comando vai = new ComandoVai();
	
	@Before
	public void setTest() {
		Labirinto lab = new LabirintoBuilder()
				.addStanzaIniziale("iniziale")
				.addStanza("adiacente")
				.addAdiacenza("iniziale", "adiacente", "nord")
				.getLabirinto();
		play = new Partita(lab);
	}
	
	
	@Test
	public void testEsegui_direzioneInesistente() {
		vai.setParametro("sud");
		vai.esegui(play);
		assertTrue(play.getStanzaCorrente().getNome().equals("iniziale"));
	}
	
	@Test
	public void testEsegui_direzioneEsistente() {
		vai.setParametro("nord");
		vai.esegui(play);
		assertTrue(play.getStanzaCorrente().getNome().equals("adiacente"));
	}
	
	@Test
	public void testEsegui_senzaParametro() {
		vai.setParametro(null);
		vai.esegui(play);
		assertTrue(play.getStanzaCorrente().getNome().equals("iniziale"));
	}

}
