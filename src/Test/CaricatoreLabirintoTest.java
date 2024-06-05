package Test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.StringReader;


import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.CaricatoreLabirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaricatoreLabirintoTest {

	private final String monolocale = 
			"Stanze:biblioteca\n"+
					"Magica:\n"+
					"Buia:\n"+
					"Bloccata:\n"+
					"Inizio:biblioteca\n"+
					"Vincente:biblioteca\n"+
					"Mago:\n"+
					"Cane:\n"+
					"Strega:\n"+
					"Attrezzi:\n"+
					"Uscite:\n";

	private final String bilocale = 
			"Stanze:N12,N11\n"+
					"Magica:\n"+
					"Buia:\n"+
					"Bloccata:\n"+
					"Inizio:N12\n"+
					"Vincente:N11\n"+
					"Mago:\n"+
					"Cane:\n"+
					"Strega:\n"+
					"Attrezzi:martello 3 N12\n"+
					"Uscite:\n";

	private CaricatoreLabirinto cl;

	@Test
	public void testMonolocale() throws FormatoFileNonValidoException, FileNotFoundException {
		cl = new CaricatoreLabirinto(new StringReader(monolocale));
		cl.carica();
		assertEquals("biblioteca", this.cl.getStanzaIniziale().getNome());
		assertEquals("biblioteca", this.cl.getStanzaVincente().getNome());
	}

	@Test
	public void testBilocale() throws FormatoFileNonValidoException, FileNotFoundException {
		cl = new CaricatoreLabirinto(new StringReader(bilocale));
		cl.carica();
		assertEquals("N12", this.cl.getStanzaIniziale().getNome());
		assertEquals("N11", this.cl.getStanzaVincente().getNome());
	}


	@Test
	public void testBilocaleAttrezzo() throws FormatoFileNonValidoException, FileNotFoundException {
		cl = new CaricatoreLabirinto(new StringReader(bilocale));
		cl.carica();
		Attrezzo expected = new Attrezzo("martello", 3);
		assertEquals(expected.getNome(), this.cl.getStanzaIniziale().getAttrezzo("martello").getNome());
		assertEquals(expected.getPeso(), this.cl.getStanzaIniziale().getAttrezzo("martello").getPeso());
	}
}
