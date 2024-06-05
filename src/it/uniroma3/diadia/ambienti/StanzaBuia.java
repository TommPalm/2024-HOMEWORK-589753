package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	private String attrezzoLuce;
	
	public StanzaBuia(String nome, String nomeAtt) {
        super(nome);
        this.attrezzoLuce = nomeAtt;
    }
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoLuce))
			return toString();
		else
			return "qui c'è buio pesto";
	}
	
}
