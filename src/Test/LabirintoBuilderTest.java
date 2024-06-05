package Test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;;

public class LabirintoBuilderTest {
	
	/*
	 * labirintoPerTest_labirintoBuilder.txt contiene un stanza iniziale "iniziale" 
	 * una stanza finale "finale"
	 * e una stanza "mezzo" collegate con iniziale-nord-> mezzo-est->finale 
	 * e una stanza "sola" non collegata
	 */
	
	
	Labirinto.LabirintoBuilder builder;
	
	@Before
	public void setTest() throws FileNotFoundException, FormatoFileNonValidoException {
		builder = new LabirintoBuilder("labirintoPerTest_labirintoBuilder.txt");
	}

	@Test
	public void testAddAttrezzo_cercaUltimaAggiunta() {
		builder.addStanzaIniziale("inizio");
		builder.addAttrezzo("att", 0);
		assertTrue(builder.getLabirinto().getCorrente().hasAttrezzo("att"));
		
	}

	
	@Test
	public void testAddAttrezzo_cercaNonUltimaAggiunta() {
		builder.addStanzaIniziale("inizio");
		builder.addAttrezzo("att", 0);
		builder.addStanza("ultima");
		builder.getLabirinto().setStanzaCorrente(builder.getStanze().get("ultima"));
		assertFalse(builder.getLabirinto().getCorrente().hasAttrezzo("att"));
	}
	
	
	
}
