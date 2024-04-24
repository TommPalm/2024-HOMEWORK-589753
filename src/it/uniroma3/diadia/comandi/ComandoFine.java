package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{

	private IOConsole IO = new IOConsole();
	
	public void esegui(Partita partita) {
		partita.setFinita();
		IO.mostraMessaggio("Grazie di aver giocato!");
	}
	
	public void setParametro(String parametro) {
	}
	
	public String getParametro() {
		return "nessuno";
	}
	
	public String getNome() {
		return "fine";
	}
}
