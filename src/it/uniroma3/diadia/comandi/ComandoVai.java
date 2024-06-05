package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {
	

	private IOConsole IO = new IOConsole();


	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza prossimaStanza = null;	
		Stanza attuale = partita.getStanzaCorrente();
		
		if(this.getParametro()==null) {
			IO.mostraMessaggio("Dove vuoi andare? specifica la direzione");
			return;
	    }
		
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
		
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
	
	
	public String getNome() {
		return "vai";
	}
}
