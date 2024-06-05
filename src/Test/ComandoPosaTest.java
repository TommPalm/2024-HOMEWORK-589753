package Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class ComandoPosaTest {
	
	private Attrezzo att;
	private Partita play;
	private Comando posa;
	
	@Before
	public void setTest() throws FileNotFoundException, FormatoFileNonValidoException {
		att = new Attrezzo("a",1);
		posa = new ComandoPosa();
		Labirinto lab = Labirinto.newBuilder("labirintoPerTest_comandoPosa.txt").getLabirinto();
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
		posa.setParametro("non_presente");
		posa.esegui(play);
		assertNotNull(play.giocatore.hasAttrezzo("a"));
	}

}
