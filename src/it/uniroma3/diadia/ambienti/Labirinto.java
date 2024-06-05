package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.npc.AbstractPersonaggio;
import it.uniroma3.diadia.npc.Mago;

public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	
	private Labirinto (String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto a = new CaricatoreLabirinto(nomeFile);
		a.carica();
		this.stanzaCorrente = a.getStanzaIniziale();
		this.stanzaVincente = a.getStanzaVincente();
	}
    
    public Stanza getVincente() {
    	return this.stanzaVincente;
    }
    public Stanza getCorrente() {
    	return this.stanzaCorrente;
    }
    
    public void setStanzaCorrente(Stanza corrente) {
    	this.stanzaCorrente= corrente;
    }
    public void setStanzaVincente(Stanza vincente) {
    	this.stanzaVincente= vincente;
    }
    
    public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
 
    
    /*******************************************************************************************/
    /*******************************************************************************************/
    
    
    public static class LabirintoBuilder {
    	
    	private Labirinto labirinto;
    	private Stanza ultimaAggiunta;
    	private Map<String,Stanza> stanze;
    	
    	public LabirintoBuilder(String lab) throws FileNotFoundException, FormatoFileNonValidoException {
    		this.labirinto = new Labirinto(lab);
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
    		StanzaBloccata s = new StanzaBloccata(stanza,Direzione.valueOf(direzione),attrezzoChiave);
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
    	
    	public LabirintoBuilder addAdiacenza(String s1, String s2, Direzione direzione) {
    		Stanza a = this.stanze.get(s1);
    		Stanza b = this.stanze.get(s2);
    		a.impostaStanzaAdiacente(direzione, b);
    		return this;
    	}
    	
    	public LabirintoBuilder addMAGO(String nome, String presentazione, String att, int peso) {
    		Attrezzo dono = new Attrezzo(att,peso);
    		AbstractPersonaggio npc = new Mago(nome,presentazione,dono);
    		this.ultimaAggiunta.setNPC(npc);
    		return this;
    	}
    	
    	public void ultimaAggiunta(Stanza room) {
    		this.ultimaAggiunta = room;
    		stanze.put(room.getNome(), room);
    	}
    }
}
