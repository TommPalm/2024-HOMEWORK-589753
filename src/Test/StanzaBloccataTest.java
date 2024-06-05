package Test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.*;


import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {

	Labirinto lab;
	Comando prendi;
	Comando vai;
	Partita play;
	
	@Before
	public void setTest() throws FileNotFoundException, FormatoFileNonValidoException {
		vai = new ComandoVai();
		prendi = new ComandoPrendi();
		lab = Labirinto.newBuilder("labirintoPerTest_stanzaBloccata.txt").getLabirinto();
		play = new Partita(lab);
	}
	
	@Test
	public void testGetStanzaAdiacente_conChiave() {
		vai.setParametro("nord");
		vai.esegui(play);
		assertEquals("vincente",lab.getCorrente().getNome());
	}
	
	@Test
	public void testGetStanzaAdiacente_senzaChiave() {
		prendi.setParametro("chiave");
		prendi.esegui(play);
		vai.setParametro("nord");
		vai.esegui(play);
		assertNotEquals("vincente",lab.getCorrente().getNome());
	}

}
