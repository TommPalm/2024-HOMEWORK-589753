package it.uniroma3.diadia.npc;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	protected String nome;
	protected String presentazione;
	private boolean haSalutato;

	public AbstractPersonaggio(String nome, String presentazione) {
		this.nome = nome;
		this.presentazione = presentazione;
		this.haSalutato = false; 
	}

	public String getNome() {
		return this.nome;
	}

	public boolean haSalutato() {
		return this.haSalutato;
	}
	
	public String saluta() {
		StringBuilder risposta = new StringBuilder("Ciao, io sono ");

		risposta.append(this.nome+". ");
		if (!haSalutato)
			risposta.append("("+this.presentazione+")");
		else
			risposta.append("Ci siamo gia' presentati!");

		this.haSalutato = true;
		return risposta.toString();
	}

	abstract public String agisci(Partita partita);

	@Override
	public String toString() {
		return this.getNome();
	}

	abstract public String riceviRegalo(Attrezzo att, Partita partita);
}
