package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;



public class BorsaTest {

	private Borsa b;
	private Attrezzo a;

	
	@Test
	public void testAddAttrezzo_attrezzoInseribile() {
		b = new Borsa();
		a = new Attrezzo("leggero",5);
		assertTrue(b.addAttrezzo(a));
	}
	
	@Test
	public void testAddAttrezzo_attrezzoNonInseribile() {
		b = new Borsa();
		a = new Attrezzo("troppo pesante",15);
		assertFalse(b.addAttrezzo(a));
	}
	
	@Test
	public void testAddAttrezzo_borsaPiena() {
		Attrezzo a2 = new Attrezzo("riempe borsa",10);
		b = new Borsa();
		a = new Attrezzo("attrezzo",1);
		b.addAttrezzo(a2);
		assertFalse(b.addAttrezzo(a));
	}

}
