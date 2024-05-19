package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	private Partita partita;
	private Comando comando = new ComandoPrendi();
	private Attrezzo a1;
	private Attrezzo a2;

	
	@Before
	public void setTest(){
		a1 = new Attrezzo("a", 0);
		a2 = new Attrezzo("b", 0);
		Labirinto lab = new LabirintoBuilder()
				.addStanzaIniziale("stanza")
				.getLabirinto();
		partita = new Partita(lab);
	}

	
	@Test
	public void testEsegui_presente() {
		partita.getLabirinto().getCorrente().addAttrezzo(a1);
		comando.setParametro("a");
		comando.esegui(partita);
		assertFalse(partita.getLabirinto().getCorrente().hasAttrezzo("a"));
	}
	
	@Test
	public void testEsegui_NonPresente() {
		partita.getLabirinto().getCorrente().addAttrezzo(a2);
		comando.setParametro("a");
		comando.esegui(partita);
		assertTrue(partita.getLabirinto().getCorrente().hasAttrezzo("b"));
		assertFalse(partita.getLabirinto().getCorrente().hasAttrezzo("a"));
	}

	
}

