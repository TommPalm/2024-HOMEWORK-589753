package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{

	private IOConsole IO = new IOConsole();
	private String att;
	
	public void esegui(Partita partita) {
		if(this.att==null) {
			IO.mostraMessaggio("cosa vuoi prendere ?");
		}
		Attrezzo a;
		a = partita.getStanzaCorrente().getAttrezzo(this.att);
		if (a == null) {
			IO.mostraMessaggio("attrezzo inesistente");
		}
		else {
			if(partita.giocatore.raccogli(a)) {
				IO.mostraMessaggio("\nraccolto "+ partita.getStanzaCorrente().getAttrezzo(a.getNome()));
				partita.getStanzaCorrente().removeAttrezzo(a);
			}
			else
				IO.mostraMessaggio("\nimpossibile raccogliere");
		}
		IO.mostraMessaggio("\n"+partita.getStanzaCorrente().getDescrizione());
	}
	
	public void setParametro(String attrezzo) {
		this.att = attrezzo;
	}
	
	public String getParametro() {
		return this.att;
	}
	
	public String getNome() {
		return "prendi";
	}
	
}
