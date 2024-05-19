package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparaAttrezziPerNome;
import it.uniroma3.diadia.attrezzi.ComparaAttrezziPerPesoNome;


public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String,Attrezzo> attrezzi = new HashMap<String,Attrezzo>();
	private int pesoMax;
	private int pesoAttuale;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.pesoAttuale = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.pesoAttuale + attrezzo.getPeso() > this.getPesoMax())
			return false;
		else {
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			this.pesoAttuale += attrezzo.getPeso();
			return true;
		}
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		
		if( this.attrezzi.containsKey(nomeAttrezzo) && nomeAttrezzo !=null) {
			return this.attrezzi.get(nomeAttrezzo);
		}
		else return null;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		
		if(this.attrezzi.containsKey(nomeAttrezzo)) {
			return this.attrezzi.remove(nomeAttrezzo);
		}
		
		else return null;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (this.attrezzi.isEmpty()) {
			s.append("Borsa vuota");
		}
		else {
			s.append("Contenuto borsa ("+this.pesoAttuale+"kg/"+this.getPesoMax()+"kg): \n");
			s.append(this.attrezziPresenti().toString());
		}
		
		return s.toString();
	}
	
	public Collection<Attrezzo> attrezziPresenti(){
		return this.attrezzi.values();
	}
	
	/*ordinamenti*/
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		
		if(this.attrezzi.isEmpty()) {
			return null;
		}
		List<Attrezzo> l = new ArrayList<Attrezzo>();
		l.addAll(this.attrezziPresenti());
		Collections.sort(l,new ComparaAttrezziPerPesoNome());
		return l;

	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		if(this.attrezzi.isEmpty()) {
			return null;
		}
		Set<Attrezzo> set = new TreeSet<Attrezzo>(new ComparaAttrezziPerNome());
		set.addAll(this.attrezziPresenti());
		return (SortedSet<Attrezzo>) set;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		if(this.attrezzi.isEmpty()) {
			return null;
		}
		Map<Integer,Set<Attrezzo>> mappa = new TreeMap<>();
		for(Attrezzo att : this.attrezziPresenti()) {
			if(mappa.containsKey(att.getPeso())) {
				mappa.get(att.getPeso()).add(att);
			}
			else {
				Set<Attrezzo> set = new TreeSet<Attrezzo>(new ComparaAttrezziPerPesoNome());
				set.add(att);
				mappa.put(att.getPeso(), set);
			}
		}
		return mappa;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		if(this.attrezzi.isEmpty()) {
			return null;
		}
		Set<Attrezzo> set = new TreeSet<Attrezzo>(new ComparaAttrezziPerPesoNome());
		set.addAll(this.attrezziPresenti());
		return (SortedSet<Attrezzo>) set;
	}
	
	
	
	
	
	
	
}