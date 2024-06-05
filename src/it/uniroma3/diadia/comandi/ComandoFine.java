package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando{

	private IOConsole IO = new IOConsole();
	
	public void esegui(Partita partita) {
		partita.setFinita();
		IO.mostraMessaggio("Grazie di aver giocato!");
	}
	
	public String getNome() {
		return "fine";
	}
}
