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
	
	
	public Partita(){
		labirinto = new Labirinto();	
		labirinto.costruisci();
		giocatore = new Giocatore();
		giocatore.crea();
		this.finita = false;
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
		return (finita || vinta() || (giocatore.getCFU() == 0));
	}
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public int getCfu() {
		return giocatore.getCFU();
	}

	public void setCfu(int cfu) {
		giocatore.setCFU(cfu);	
	}	
}
