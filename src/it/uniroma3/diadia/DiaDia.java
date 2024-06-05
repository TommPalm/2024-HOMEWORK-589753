package it.uniroma3.diadia;

//import java.util.Scanner;
import it.uniroma3.diadia.comandi.Comando;
//import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.ambienti.*;
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
public class DiaDia{

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.\n"+
			"PER USARE GLI OGGETTI, VANNO POSATI NELLA STANZA";

	private List<String> elencoComandi = new ArrayList<>();
	static final private String[] cmd = {"vai","aiuto","fine","prendi","posa","guarda","interagisci","saluta","regala"};
	private Partita partita;
	private IO IO;

	public DiaDia(Labirinto labirinto,IO io) {
		this.partita = new Partita(labirinto);
		this.IO = io;
		for(int i=0; i<9;i++) {
			elencoComandi.add(cmd[i]);
		}
	}

	public void gioca() throws Exception {
		String istruzione; 

		IO.mostraMessaggio(MESSAGGIO_BENVENUTO);

		do		
			istruzione = IO.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 * @throws Exception 
	 */
	private boolean processaIstruzione(String istruzione) throws Exception {
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva(IO, elencoComandi);
		//		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();	
		comandoDaEseguire = factory.costruisciComando(istruzione);
		if(comandoDaEseguire!=null)
			comandoDaEseguire.esegui(this.partita);

		if (this.partita.vinta())
			IO.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			IO.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}

	public static void main(String[] args) throws Exception {

		IO io = new IOConsole();
		Labirinto labirinto = Labirinto.newBuilder("labirinto1.txt").getLabirinto();
		/*Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 7)
				.addStanzaVincente("Biblioteca")
				.addStanza("Aula N11")
				.addAttrezzo("lanterna", 5)
				.addStanzaBloccata("Corridoio","nord", "bacchetta")
				.addStanzaBuia("Laboratorio Campus", "lanterna")
				.addStanzaBuia("Aula N10", "lanterna")
				//adiacenze
				.addAdiacenza("Corridoio", "Biblioteca", "nord")
				.addAdiacenza("Corridoio", "Aula N11", "est")
				.addAdiacenza("Corridoio", "Aula N10", "ovest")
				.addAdiacenza("Laboratorio Campus", "Atrio", "nord")
				.addAdiacenza("Aula N10","Atrio" ,"est" )
				.addAdiacenza("Aula N10","Corridoio" ,"nord" )
				.addAdiacenza("Aula N10","Aula N11" ,"ovest" )
				.addAdiacenza("Aula N11","Aula N10" ,"est" )
				.addAdiacenza("Aula N11","Atrio" ,"ovest" )
				.addAdiacenza("Aula N11","Laboratorio Campus" ,"sud" )
				.addAdiacenza("Atrio","Corridoio" ,"nord" )
				.addAdiacenza("Atrio","Aula N11" ,"est" )
				.addAdiacenza("Atrio","Laboratorio Campus" ,"sud" )
				.addAdiacenza("Atrio","Aula N10" ,"ovest" )
				//NPC
				.addMAGO("merlino", " posso aiutarti, fidati", "bacchetta", 1)
				.getLabirinto();
		 */

		DiaDia gioco = new DiaDia(labirinto, io);
		gioco = new DiaDia(labirinto,io);
		gioco.gioca();
	}



}