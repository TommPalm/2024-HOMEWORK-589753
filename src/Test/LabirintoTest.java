package Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	

	private Labirinto.LabirintoBuilder lab;

	
	@Before
	public void setTest() throws FileNotFoundException, FormatoFileNonValidoException {
		lab = new LabirintoBuilder("labirintoPerTest_labirinto.txt");
	}
	
	@Test
	public void testGetCorrente_StanzaNonPresente() {
		Stanza stanza = new Stanza("non presente");
		assertNotEquals(lab.getLabirinto().getCorrente().getNome(),stanza.getNome());
	}
	
	@Test
	public void testGetCorrente_StanzaPresenteCorrente() {
		assertEquals(lab.getLabirinto().getCorrente().getNome(),"corrente");
	}
	
	@Test
	public void testGetCorrente_StanzaPresenteNonCorrente() {
		assertNotEquals(lab.getLabirinto().getCorrente().getNome(),"non_corrente");
	}
}
