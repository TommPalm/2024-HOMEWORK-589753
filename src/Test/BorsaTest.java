package Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;



public class BorsaTest {

	private Borsa b;
	private Attrezzo a;
	private Attrezzo a1;
	private Attrezzo a2;
	private Attrezzo a3;
	private List<Attrezzo> L_ordinataPeso;
	private List<Attrezzo> L_ordinataNome;
	private Map<Integer,Set<Attrezzo>> M_raggruppaPerPeso;
	private Set<Attrezzo> set5 = new HashSet<Attrezzo>();
	private Set<Attrezzo> set15 = new HashSet<Attrezzo>();
	private Set<Attrezzo> set10 = new HashSet<Attrezzo>(); 
	private Set<Attrezzo> set_ordinatoPesoNome = new HashSet<Attrezzo>();
	
	@Before
	public void setTest() {
		a = new Attrezzo("palla",5);
		a1 = new Attrezzo("macchina",15);
		a2 = new Attrezzo("mattone",10);
		a3 = new Attrezzo("bottiglia",5);
		L_ordinataPeso = new ArrayList<>();
		L_ordinataPeso.add(a3);
		L_ordinataPeso.add(a);
		L_ordinataPeso.add(a2);
		L_ordinataPeso.add(a1);
		L_ordinataNome = new ArrayList<>();
		L_ordinataNome.add(a3);
		L_ordinataNome.add(a1);
		L_ordinataNome.add(a2);
		L_ordinataNome.add(a);
		set5.add(a);
		set5.add(a3);
	    set10.add(a2);
		set15.add(a1);
		M_raggruppaPerPeso = new HashMap<>();
		M_raggruppaPerPeso.put(10, set10);
		M_raggruppaPerPeso.put(5, set5);
		M_raggruppaPerPeso.put(15, set15);
		set_ordinatoPesoNome.add(a3);
		set_ordinatoPesoNome.add(a);
		set_ordinatoPesoNome.add(a2);
		set_ordinatoPesoNome.add(a1);
	}

	
	@Test
	public void testAddAttrezzo_attrezzoInseribile() {
		b = new Borsa();
		assertTrue(b.addAttrezzo(a));
	}
	
	@Test
	public void testAddAttrezzo_attrezzoNonInseribile() {
		b = new Borsa();
		assertFalse(b.addAttrezzo(a1));
	}
	
	@Test
	public void testAddAttrezzo_borsaPiena() {
		b = new Borsa();
		b.addAttrezzo(a2);
		assertFalse(b.addAttrezzo(a));
	}
	
	
	// TEST DEI GET ORDINATI 
	
	@Test
	public void test_ordinatoPerPeso_inputDisordinato() {
		b = new Borsa(100);
		b.addAttrezzo(a);
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		b.addAttrezzo(a3);
		assertEquals(L_ordinataPeso,b.getContenutoOrdinatoPerPeso());
	}
	@Test
	public void test_ordinatoPerPeso_inputOrdinato() {
		b = new Borsa(100);
		b.addAttrezzo(a3);
		b.addAttrezzo(a);
		b.addAttrezzo(a2);
		b.addAttrezzo(a1);
		assertEquals(L_ordinataPeso,b.getContenutoOrdinatoPerPeso());
	}
	@Test
	public void test_ordinatoPerPeso_inputVuoto() {
		b = new Borsa();
		assertNull(b.getContenutoOrdinatoPerPeso());
	}
	
//************
	
	@Test
	public void test_ordinatoPerNome_inputDisordinato() {
		b = new Borsa(100);
		b.addAttrezzo(a);
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		b.addAttrezzo(a3);
		assertEquals(L_ordinataNome.toString(),b.getContenutoOrdinatoPerNome().toString());
	}
	@Test
	public void test_ordinatoPerNome_inputOrdinato() {
		b = new Borsa(100);
		b.addAttrezzo(a);
		b.addAttrezzo(a3);
		b.addAttrezzo(a2);
		b.addAttrezzo(a1);
		assertEquals(L_ordinataNome.toString(),b.getContenutoOrdinatoPerNome().toString());
	}
	@Test
	public void test_ordinatoPerNome_inputVuoto() {
		b = new Borsa();
		assertNull(b.getContenutoOrdinatoPerNome());
	}
	
// ***************
	
	@Test
	public void test_raggruppatoPerPeso_inputDisordinato() {
		b = new Borsa(100);
		b.addAttrezzo(a);
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		b.addAttrezzo(a3);
		assertEquals(M_raggruppaPerPeso,b.getContenutoRaggruppatoPerPeso());
	}
	@Test
	public void test_raggruppatoPerPeso_inputOrdinato() {
		b = new Borsa(100);		
		b.addAttrezzo(a);
		b.addAttrezzo(a3);
		b.addAttrezzo(a2);
		b.addAttrezzo(a1);
		assertEquals(M_raggruppaPerPeso,b.getContenutoRaggruppatoPerPeso());
	}
	@Test
	public void test_raggruppatoPerPeso_inputVuoto() {
		b = new Borsa();
		assertNull(b.getContenutoRaggruppatoPerPeso());
	}
	
// *******************	
	
	@Test
	public void test_sortedSet_ordinatoPerPeso_inputDisordinato() {
		b = new Borsa(100);
		b.addAttrezzo(a);
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		b.addAttrezzo(a3);
		assertEquals(set_ordinatoPesoNome,b.getSortedSetOrdinatoPerPeso());
	}
	@Test
	public void test_sortedSet_ordinatoPerPeso_inputOrdinato() {
		b = new Borsa(100);
		b.addAttrezzo(a);
		b.addAttrezzo(a3);
		b.addAttrezzo(a2);
		b.addAttrezzo(a1);
		assertEquals(set_ordinatoPesoNome,b.getSortedSetOrdinatoPerPeso());
	}
	@Test
	public void test_sortedSet_ordinatoPerPeso_inputVuoto() {
		b = new Borsa();
		assertNull(b.getSortedSetOrdinatoPerPeso());
	}
	
}
