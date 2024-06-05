package it.uniroma3.diadia.npc;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	
	private Attrezzo regalo;
	private String preferito;

	public Cane(String nome, String presentazione, String ciboPreferito, Attrezzo regalo) {
		super(nome, presentazione);
		this.preferito = ciboPreferito;
		this.regalo = regalo;
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCFU( partita.getGiocatore().getCFU()-1 );
		return this.presentazione+" "+this.nome+" ("+this.getNome()+"ti morde e perdi 1 CFU)";
	}

	@Override
	public String riceviRegalo(Attrezzo att, Partita partita) {
		if(att.getNome().equals(preferito)) {
			partita.getGiocatore().raccogli(regalo);
			return this.presentazione+" "+this.nome+" ti dona qualcosa";
		}
		else {
			this.agisci(partita);
			return null;
		}
	}
	
	@Override
	public String getNome() {
		return super.getNome()+" cane";
	}


}
