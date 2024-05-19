package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoBuilderTest {
	
	LabirintoBuilder builder;
	
	@Before
	public void setTest() {
		builder = new LabirintoBuilder();
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
	
	@Test
	public void testAddAdiacenza_nessunaAdiacente() {
		builder.addStanzaIniziale("inizio");
		assertNull(builder.getLabirinto().getCorrente().getStanzaAdiacente("nord"));
		assertNull(builder.getLabirinto().getCorrente().getStanzaAdiacente("est"));
		assertNull(builder.getLabirinto().getCorrente().getStanzaAdiacente("sud"));
		assertNull(builder.getLabirinto().getCorrente().getStanzaAdiacente("ovest"));
	}

	@Test
	public void testAddAdiacenza_esisteAdiacente() {
		builder.addStanzaIniziale("inizio");
		builder.addStanza("adiacente");
		builder.addAdiacenza("inizio", "adiacente", "est");
		assertNull(builder.getLabirinto().getCorrente().getStanzaAdiacente("nord"));
		assertEquals(builder.getStanze().get("adiacente"),builder.getLabirinto().getCorrente().getStanzaAdiacente("est"));
		assertNull(builder.getLabirinto().getCorrente().getStanzaAdiacente("sud"));
		assertNull(builder.getLabirinto().getCorrente().getStanzaAdiacente("ovest"));
	}
	
}
