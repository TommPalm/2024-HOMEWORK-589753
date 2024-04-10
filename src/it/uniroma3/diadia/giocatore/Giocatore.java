package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {

	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	public void crea() {
		this.cfu = CFU_INIZIALI;
		borsa= new Borsa();
	}
	
	public int getCFU() {
		return this.cfu;
	}
	
	public void setCFU( int cfu) {
		this.cfu= cfu;
	}
	
	public boolean raccogli(Attrezzo attrezzo) {
		if(borsa.addAttrezzo(attrezzo))
			return true;
		else
			return false;
	}
	
	public void butta(Attrezzo attrezzo) {
		borsa.removeAttrezzo(attrezzo.getNome());
	}
	
	public Attrezzo hasAttrezzo (String att) {
		Attrezzo cerca = null;
		if(borsa.hasAttrezzo(att)) {
			cerca=borsa.getAttrezzo(att);
		}
		return cerca;
	}
}
