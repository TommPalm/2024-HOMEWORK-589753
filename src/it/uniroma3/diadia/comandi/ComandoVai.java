package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	private IOConsole IO = new IOConsole();

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza prossimaStanza = null;	
		Stanza attuale = partita.getStanzaCorrente();
		
		if(direzione==null) {
			IO.mostraMessaggio("Dove vuoi andare? specifica la direzione");
			return;
	    }
		
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		
		if(prossimaStanza == attuale) {
			IO.mostraMessaggio("direzione bloccata");
			return;
		}
		
		if (prossimaStanza == null) {
			IO.mostraMessaggio("Direzione inesistente");
			return;
		}
		
		partita.labirinto.setStanzaCorrente(prossimaStanza);
		//IO.mostraMessaggio(partita.labirinto.getCorrente().getNome());  
		partita.giocatore.setCFU(partita.giocatore.getCFU()-1);
		
	}	
	
	public String getParametro() {
		return this.direzione;
	}
	
	public String getNome() {
		return "vai";
	}
}
