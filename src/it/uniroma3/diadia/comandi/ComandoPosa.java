package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando{

	private IOConsole IO = new IOConsole();
	private String att;
	
	public void esegui(Partita partita) {
		if(att==null)
			IO.mostraMessaggio("cosa vuoi posare ?");
		Attrezzo a;
		a= partita.giocatore.hasAttrezzo(att);
		if(a==null)
			IO.mostraMessaggio("attrezzo inesistente");
		else {
			partita.giocatore.butta(a);
			partita.getStanzaCorrente().addAttrezzo(a);
		}
		IO.mostraMessaggio("\n"+partita.getStanzaCorrente().getDescrizione());
	}
	
	public void setParametro(String parametro) {
		this.att = parametro;
	}
	
	public String getParametro() {
		return this.att;
	}
	
	public String getNome() {
		return "posa";
	}
}
