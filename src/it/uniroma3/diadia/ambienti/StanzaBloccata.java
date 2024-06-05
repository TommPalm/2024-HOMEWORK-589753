package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private Direzione direzioneBloccata;
	private String chiave;
	
	public StanzaBloccata(String nome,Direzione direzione,String chiave) {
        super(nome);
        this.direzioneBloccata = direzione;
        this.chiave = chiave;
    }
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		Stanza a = this;
        if(direzione.equals(direzioneBloccata)) {
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
