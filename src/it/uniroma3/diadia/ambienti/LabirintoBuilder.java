package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder{

	
	private Labirinto labirinto;
	private Stanza ultimaAggiunta;
	private Map<String,Stanza> stanze;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		stanze = new HashMap<>();
	}
	
	public void setStanzaVincente (Stanza room) {
		labirinto.setStanzaVincente(room);
	}
	
	public Map<String,Stanza> getStanze(){
		return this.stanze;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public LabirintoBuilder addStanzaVincente(String vince) {
		Stanza s = new Stanza(vince);
		this.ultimaAggiunta(s);
		this.setStanzaVincente(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaIniziale(String iniziale) {
		Stanza s = new Stanza(iniziale);
		this.ultimaAggiunta(s);
		labirinto.setStanzaCorrente(s);
		return this;
	}
	
	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		this.ultimaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String stanza, String attrezzoLuce) {
		StanzaBuia s = new StanzaBuia(stanza,attrezzoLuce);
		this.ultimaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String stanza) {
		StanzaMagica s = new StanzaMagica(stanza);
		this.ultimaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata (String stanza,String direzione, String attrezzoChiave) {
		StanzaBloccata s = new StanzaBloccata(stanza,direzione,attrezzoChiave);
		this.ultimaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo att = new Attrezzo(attrezzo,peso);
		if(this.ultimaAggiunta == null) {
			return this;
		}
		this.ultimaAggiunta.addAttrezzo(att);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String s1, String s2, String direzione) {
		Stanza a = this.stanze.get(s1);
		Stanza b = this.stanze.get(s2);
		a.impostaStanzaAdiacente(direzione, b);
		return this;
	}
	
	
	public void ultimaAggiunta(Stanza room) {
		this.ultimaAggiunta = room;
		stanze.put(room.getNome(), room);
	}
	
}
