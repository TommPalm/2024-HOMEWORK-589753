package it.uniroma3.diadia.npc;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio{
	
	private static final String MESSAGGIO_DONO = "Sembri un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' magia...";
	
	private static final String MESSAGGIO_REGALO = "Abbra-cadabra, il tuo oggetto è alleggerito";
	
	private Attrezzo dono;
	
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.dono = attrezzo;
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.dono!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.dono);
			this.dono = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo att, Partita partita) {
		Attrezzo nuovo = new Attrezzo(att.getNome(),att.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(nuovo);
		return MESSAGGIO_REGALO;
	}
	
	@Override
	public String getNome() {
		return super.getNome()+" mago";
	}
}

