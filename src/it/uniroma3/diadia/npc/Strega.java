package it.uniroma3.diadia.npc;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		
		Stanza molti = null; //stanza con molti attrezzi
		Stanza pochi = null; //stanza con pochi attrezzi
		int maxAttrezzi = 0;
		int minAttrezzi = 0;
		List<Stanza> adiacenti = new ArrayList<>();
		adiacenti = partita.getStanzaCorrente().getStanzeAdiacenti();
		
		for( Stanza s : adiacenti) {
			if( s.getNumeroAttrezzi() > maxAttrezzi) {
				molti = s;
				maxAttrezzi = s.getNumeroAttrezzi();
			}
			if( s.getNumeroAttrezzi() <= minAttrezzi) {
				pochi = s;
				minAttrezzi = s.getNumeroAttrezzi();
			}
		}
		
		//se è stata salutata trasporta nella stanza adiacente con più attrezzi, sennò in quella con meno
		if(this.haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(molti);
			return "ora lasciami stare... (sei stato teletrasportato)";
		}
		else {
			partita.getLabirinto().setStanzaCorrente(pochi);
			return " va via! (sei stato teletrasportato)";
		}
	}

	@Override
	public String riceviRegalo(Attrezzo att, Partita partita) {
		return "grazie del regalo, muhahahahaha!"+this.agisci(partita);
	}
	
	@Override
	public String getNome() {
		return super.getNome()+" strega";
	}

}
