package it.uniroma3.diadia.comandi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi{

	private IO io;
	private List<String> comandi = new ArrayList<>();

	public FabbricaDiComandiRiflessiva (IO io, List<String> comd) {
		this.io = io;
		this.comandi = comd;
	}


	@Override
	public Comando costruisciComando (String istruzione) throws Exception{
		
		Scanner scanner = new Scanner(istruzione); 
		String nomeComando = null; 
		String parametro = null; 
		Comando comando = null;

		if (scanner.hasNext())
			nomeComando = scanner.next();
		if (scanner.hasNext())
			parametro = scanner.next();

		if(!comandi.contains(nomeComando)) {
			io.mostraMessaggio("\nil comando è errato");
			return null;
		}
		StringBuilder classe = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		classe.append( Character.toUpperCase(nomeComando.charAt(0)) );
		classe.append( nomeComando.substring(1) );
		
		comando = (Comando)Class.forName(classe.toString()).newInstance();
		comando.setParametro(parametro);
		return comando;
	}	
}
