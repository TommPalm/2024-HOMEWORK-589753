package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	private String attrezzo_luce;
	
	public StanzaBuia(String nome, String nomeAtt) {
        super(nome);
        this.attrezzo_luce = nomeAtt;
    }
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzo_luce))
			return toString();
		else
			return "qui c'è buio pesto";
	}
	
}
