package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	IOConsole IO = new IOConsole();
	
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			IO.mostraMessaggio(elencoComandi[i]+" ");
	}
	
	public void setParametro(String parametro) {   //non ha bisogno di parametri
	}
	
	public String getParametro() {
		return "nessuno";
	}
	
	public String getNome() {
		return "aiuto";
	}
}
