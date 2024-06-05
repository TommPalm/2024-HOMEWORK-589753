package Test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {

	private Giocatore player= new Giocatore();;
	
	
	@Test
	public void testGetCFU_partenza() {	 
		assertEquals(20,player.getCFU());
	}

	@Test
	public void testGetCFU_attualiGiusti() {	
		player.setCFU(9);
		assertEquals(9,player.getCFU());
	}
	
	@Test
	public void testGetCFU_attualiErrati() {
		player.setCFU(3);
		assertNotEquals(20,player.getCFU());
	}
}
