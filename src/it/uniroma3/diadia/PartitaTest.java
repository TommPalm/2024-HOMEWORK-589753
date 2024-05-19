package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;
	
	@Before
	public void setTest() {
		Labirinto lab = new LabirintoBuilder()
				.addStanzaIniziale("inizio")
				.addStanzaVincente("vince")
				.addAdiacenza("inizio", "vince", "nord")
				.getLabirinto();
		partita = new Partita(lab);
	}
	
	@Test
	public void testIsFinita_comandoFine() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}

	@Test
	public void testIsFinita_CfuFiniti() {
		partita.setCfu(0);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinita_vinta() {
		Stanza vince = partita.getStanzaVincente();
		partita.labirinto.setStanzaVincente(vince);
		partita.labirinto.setStanzaCorrente(vince);
		assertTrue(partita.isFinita());
	}
	
}
