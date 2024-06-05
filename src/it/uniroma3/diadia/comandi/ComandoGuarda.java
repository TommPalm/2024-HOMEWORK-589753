package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando{

	private IOConsole IO = new IOConsole();
	
	
	
	public void esegui(Partita partita) {
		IO.mostraMessaggio("\nCFU rimasti: "+partita.getCfu());
		IO.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	
	public String getNome() {
		return "guarda";
	}
	
}
