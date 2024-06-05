package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.npc.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {
	
	IOConsole io = new IOConsole();

	@Override
	public String getNome() {
		return "saluta";
	}

	@Override
	public void esegui(Partita partita) {
		
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getNPC();
		if(partita.getStanzaCorrente().getNPC() !=null ) {
			io.mostraMessaggio(personaggio.saluta());
		}
		else {
			io.mostraMessaggio("chi devo salutare?");
		}
	}

}
