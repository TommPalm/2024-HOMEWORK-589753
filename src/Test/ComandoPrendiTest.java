package Test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {

	private Partita partita;
	private Comando comando = new ComandoPrendi();

	
	@Before
	public void setTest() throws FileNotFoundException, FormatoFileNonValidoException{
		Labirinto lab = Labirinto.newBuilder("labirintoPerTest_comandoPrendi.txt").getLabirinto();
		partita = new Partita(lab);
	}

	
	@Test
	public void testEsegui_presente() {
		comando.setParametro("presente");
		comando.esegui(partita);
		assertFalse(partita.getLabirinto().getCorrente().hasAttrezzo("presente"));
	}
	
	@Test
	public void testEsegui_NonPresente() {
		comando.setParametro("non_presente");
		comando.esegui(partita);
		assertTrue(partita.getLabirinto().getCorrente().hasAttrezzo("presente"));
		assertFalse(partita.getLabirinto().getCorrente().hasAttrezzo("non_presente"));
	}

	
}

