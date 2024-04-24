package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private Comando comando;
	private Stanza room = new Stanza("room");
	
	@Before
	public void setTest(){
		partita = new Partita();
		attrezzo = new Attrezzo("a", 0);
		comando = new ComandoPrendi();
		room = partita.getStanzaCorrente();	
	}

	
	@Test
	public void testEsegui_presente() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("a");
		comando.esegui(partita);
		assertFalse(room.hasAttrezzo("a"));
	}
	
	@Test
	public void testEsegui_NonPresente() {
		comando.setParametro("a");
		comando.esegui(partita);
		assertFalse(room.hasAttrezzo("a"));
	}

	
}

