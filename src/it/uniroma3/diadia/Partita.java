package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Partita {

	public Giocatore giocatore;
	public Labirinto labirinto;
	private boolean finita;
	
	
	public Partita(Labirinto lab){
		this.labirinto = lab;	
		giocatore = new Giocatore();
		this.finita = false;
	}
	
	public void setLabirinto (Labirinto lab) {
		this.labirinto = lab;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public void setGiocatore(Giocatore player) {
		this.giocatore = player;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
 

	public Stanza getStanzaVincente() {
		return labirinto.getVincente();
	}

	public Stanza getStanzaCorrente() {
		return labirinto.getCorrente();
	}
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}
	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return (finita || this.vinta() || (giocatore.getCFU() == 0));
	}
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public boolean giocatoreIsVivo() {
		if(giocatore.getCFU()<=0) {
			return false;
		}
		return true;
	}
	
	public int getCfu() {
		return giocatore.getCFU();
	}

	public void setCfu(int cfu) {
		giocatore.setCFU(cfu);	
	}	
}
