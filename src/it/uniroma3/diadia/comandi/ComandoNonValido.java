package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando{

	private IOConsole IO = new IOConsole();
	
	public void esegui(Partita partita) {
		IO.mostraMessaggio("comando non valido, riprova");
	}
	
	public String getNome() {
		return "comando non valido";
	}
}
