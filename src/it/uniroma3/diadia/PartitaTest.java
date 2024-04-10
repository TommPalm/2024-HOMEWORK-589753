package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita = new Partita();
	
	
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
