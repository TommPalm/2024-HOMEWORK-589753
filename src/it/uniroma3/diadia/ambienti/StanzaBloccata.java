package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private String direzione_bloccata;
	private String chiave;
	
	public StanzaBloccata(String nome,String direzione,String chiave) {
        super(nome);
        this.direzione_bloccata = direzione;
        this.chiave = chiave;
    }
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza a = this;
        if(direzione.equals(direzione_bloccata)) {
        	if(hasAttrezzo(this.chiave)) {
        		return super.getStanzaAdiacente(direzione);
        	}
        	else {
        		return a;
        	}
        }
        else return super.getStanzaAdiacente(direzione);
	}
	
}
