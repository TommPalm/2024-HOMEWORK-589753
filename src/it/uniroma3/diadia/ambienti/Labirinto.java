package it.uniroma3.diadia.ambienti;


public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	
	public static LabirintoBuilder newBuilder () {
		return new LabirintoBuilder();
	}
    
    public Stanza getVincente() {
    	return this.stanzaVincente;
    }
    public Stanza getCorrente() {
    	return this.stanzaCorrente;
    }
    
    public void setStanzaCorrente(Stanza corrente) {
    	this.stanzaCorrente= corrente;
    }
    public void setStanzaVincente(Stanza vincente) {
    	this.stanzaVincente= vincente;
    }
    
    
}
