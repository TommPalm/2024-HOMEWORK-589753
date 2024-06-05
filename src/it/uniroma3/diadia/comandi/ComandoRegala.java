package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {
	
	private IOConsole io = new IOConsole();
	private String att;

	@Override
	public String getNome() {
		return "regala";
	}

	@Override
	public void esegui(Partita partita) {
		if(att==null) {
			io.mostraMessaggio("cosa vuoi regalare?");
		}
		Attrezzo a;
		a= partita.giocatore.hasAttrezzo(att);
		if(a==null) {
			io.mostraMessaggio("non hai questo oggetto");
		}
		else {
			partita.giocatore.butta(a);
			io.mostraMessaggio(partita.getStanzaCorrente().getNPC().riceviRegalo(a, partita));
		}
	}
	
	public void setParametro(String nome) {
		this.att = nome;
	}
	public String getParametro() {
		return this.att;
	}

}
