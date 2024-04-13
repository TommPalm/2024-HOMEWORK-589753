package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base 
 */
public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole IO = new IOConsole();

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		//Scanner scannerDiLinee;

		IO.mostraMessaggio(MESSAGGIO_BENVENUTO);
		IO.mostraMessaggio("\n"+partita.getStanzaCorrente().getDescrizione());		
		do		
			istruzione = IO.leggiRiga();
		while (!processaIstruzione(istruzione));
		
		//scannerDiLinee.close();
	}   
/**/
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		if(istruzione.isEmpty())
			return false;
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
			if(this.partita.getCfu() == 0) {   //controlla se ci sono ancora cfu per giocare
				IO.mostraMessaggio(istruzione);
				this.fine();
			}
			if (this.partita.vinta()) {
				IO.mostraMessaggio("\nHAI VINTO!");
				return true;
			} 
			return false;
		}			
		else if (comandoDaEseguire.getNome().equals("aiuto")) {
			this.aiuto();
			return false;
		}
		else if (comandoDaEseguire.getNome().equals("prendi")) {
			this.prendi(comandoDaEseguire.getParametro());	
			return false;
		}
		else if (comandoDaEseguire.getNome().equals("posa")) {
			this.posa(comandoDaEseguire.getParametro());	
			return false;
		}
		else
			IO.mostraMessaggio("Comando sconosciuto");
		
		if (this.partita.vinta()) {
			IO.mostraMessaggio("\nHAI VINTO!");
			return true;
		} else
			return false;
	}   
	// implementazioni dei comandi dell'utente:
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			IO.mostraMessaggio(elencoComandi[i]+" ");
	}
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			IO.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			IO.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.labirinto.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu-1);
			IO.mostraMessaggio("cfu rimasti: "+partita.getCfu());
		}
		IO.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		IO.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	/**
	 * comando "prendi"
	 */
	private void prendi(String NomeAtt) {
		if(NomeAtt==null)
			IO.mostraMessaggio("cosa vuoi prendere ?");
		Attrezzo a;
		a = this.partita.getStanzaCorrente().getAttrezzo(NomeAtt);
		if (a == null)
			IO.mostraMessaggio("attrezzo inesistente");
		else {
			if(this.partita.giocatore.raccogli(a))
				IO.mostraMessaggio("\nraccolto "+ this.partita.getStanzaCorrente().getAttrezzo(a.getNome()));
			else
				IO.mostraMessaggio("\nimpossibile raccogliere");
			this.partita.getStanzaCorrente().removeAttrezzo(a);
		}
		IO.mostraMessaggio("\n"+partita.getStanzaCorrente().getDescrizione());
	}
	
	/**
	 * comando "posa"
	 */
	private void posa(String NomeAtt) {
		if(NomeAtt==null)
			IO.mostraMessaggio("cosa vuoi posare ?");
		Attrezzo a;
		a= this.partita.giocatore.hasAttrezzo(NomeAtt);
		if(a==null)
			IO.mostraMessaggio("attrezzo inesistente");
		else {
			this.partita.giocatore.butta(a);
			this.partita.getStanzaCorrente().addAttrezzo(a);
		}
		IO.mostraMessaggio("\n"+partita.getStanzaCorrente().getDescrizione());
	}
	


	public static void main(String[] args) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}

	
	
}