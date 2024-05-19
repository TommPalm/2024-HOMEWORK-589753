package it.uniroma3.diadia;

//import java.util.Scanner;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
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
	

	private Partita partita;
	private IO IO;

	public DiaDia(Labirinto labirinto,IO io) {
		this.partita = new Partita(labirinto);
		this.IO = io;
	}

	public void gioca() {
		String istruzione; 
		//Scanner scannerDiLinee;
		
		IO.mostraMessaggio(MESSAGGIO_BENVENUTO);
	
		do		
			istruzione = IO.leggiRiga();
		while (!processaIstruzione(istruzione));
		
		//scannerDiLinee.close();
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.vinta())
			IO.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			IO.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}

	public static void main(String[] args) {
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Biblioteca")
				.addStanza("Aula N11")
				.addAttrezzo("lanterna", 5)
				.addStanzaBloccata("Corridoio","nord", "tesserino")
				.addStanzaBuia("Laboratorio Campus", "lanterna")
				.addAttrezzo("tesserino", 0)
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
				.getLabirinto();
		
		DiaDia gioco = new DiaDia(labirinto,io);
		gioco.gioca();
	}

	
	
}