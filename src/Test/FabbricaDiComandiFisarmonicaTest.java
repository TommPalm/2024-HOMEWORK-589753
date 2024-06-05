package Test;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoGuarda;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {

	private Comando comando;
	private FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
	
	
	@Test
	public void testCostruisciComando_comandoErrato() {
		comando = new ComandoNonValido();
		assertEquals(comando.getNome(),fabbrica.costruisciComando("non valido").getNome());
	}
	
	@Test
	public void testCostruisciComando_serveParametro() {
		comando = new ComandoVai();
		comando.setParametro("est");
		Comando nuovo = fabbrica.costruisciComando("vai est");
		assertEquals(comando.getParametro(),nuovo.getParametro());
	}
	
	@Test
	public void testCostruisciComando_senzaParametro() {
		comando = new ComandoGuarda();
		assertEquals(comando.getNome(),"guarda");
	}

}
