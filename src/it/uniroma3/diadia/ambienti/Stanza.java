package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.npc.AbstractPersonaggio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/
public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	
	private String nome;
    private Map<String,Attrezzo> attrezzi = new HashMap<String,Attrezzo>();
    private Map<Direzione,Stanza> stanzeAdiacenti = new HashMap<Direzione,Stanza>();
    private int numeroStanzeAdiacenti;
    private int numeroAttrezzi;
    private AbstractPersonaggio NPC;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi=0;
        this.NPC = null;
    }
    
    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
    	
        if( this.stanzeAdiacenti.containsKey(direzione)  ) {
        	this.stanzeAdiacenti.remove(direzione);
        	this.stanzeAdiacenti.put(direzione, stanza);
        }
        
        else {
        	if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
    			this.stanzeAdiacenti.put(direzione, stanza);
    			this.numeroStanzeAdiacenti++ ;
    		}
        }
    
    }
    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(Direzione direzione) {
       return this.stanzeAdiacenti.get(direzione);
	}
    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }
    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }
    
    public int getNumeroStanzaAdiacenti() {
    	return this.numeroStanzeAdiacenti;
    }
    
    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Map<String,Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }
    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	this.attrezzi.put(attrezzo.getNome(), attrezzo);
    	this.numeroAttrezzi++;
    	return this.attrezzi.containsKey(attrezzo.getNome());
    }
    
   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		risultato.append(this.getDirezioni().toString());
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(this.getAttrezzi().toString());
		if(this.NPC!=null)
			risultato.append("\nnella stanza c'è: "+this.getNPC().getNome());
		return risultato.toString();

    }
    
    
    
	/**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		
		if(this.attrezzi.containsKey(nomeAttrezzo) ) {
			return this.attrezzi.get(nomeAttrezzo);
		}
		else return null;
	}
	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		
		if(this.attrezzi.containsValue(attrezzo)  ) {
			this.attrezzi.remove(attrezzo.getNome());
	    	this.numeroAttrezzi--;
			return true;
		}
		
		else return false;
	}

	public int getNumeroAttrezzi() {
		return this.numeroAttrezzi;
	}
	
	public Set<Direzione> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
    }

	public void setNPC(AbstractPersonaggio npc) {
		this.NPC = npc;
	}
	
	public AbstractPersonaggio getNPC() {
		if(this.NPC == null) {
			return null;
		}
		else return this.NPC;
	}
	
	public List<Stanza> getStanzeAdiacenti(){
		List<Stanza> ad = new ArrayList<>();
		for(Stanza room : stanzeAdiacenti.values()) {
			ad.add(room);
		}
		return ad;
	}
	
}