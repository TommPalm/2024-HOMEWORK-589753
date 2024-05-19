package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ComandoPosaTest {
	
	private Attrezzo att;
	private Partita play;
	private Comando posa;
	
	@Before
	public void setTest() {
		att = new Attrezzo("a",1);
		posa = new ComandoPosa();
		Labirinto lab = new LabirintoBuilder()
				.addStanzaIniziale("inizio")
				.getLabirinto();
		play = new Partita(lab);
	}

	@Test
	public void testEsegui_posato() {
		play.giocatore.raccogli(att);
		posa.setParametro("a");
		posa.esegui(play);
		assertNull(play.giocatore.hasAttrezzo("a"));
	}
	
	@Test
	public void testEsegui_nonPosato() {
		play.giocatore.raccogli(att);
		posa.setParametro(null);
		posa.esegui(play);
		assertNotNull(play.giocatore.hasAttrezzo("a"));
	}

}
